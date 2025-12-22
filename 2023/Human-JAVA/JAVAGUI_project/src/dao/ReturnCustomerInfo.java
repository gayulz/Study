package dao;

import dto.CustomerDTO;
import dto.customerANDbookingList;
import oracle.jdbc.OracleTypes;
import resource.Connection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReturnCustomerInfo extends Connection {
    // 싱글톤
    private ReturnCustomerInfo(){}
    private static class holderInstance{
        public static final ReturnCustomerInfo INSTANCE = new ReturnCustomerInfo();
    }
    public static ReturnCustomerInfo getInstance(){
        return holderInstance.INSTANCE;
    }

    // 멤버변수
    private static List<customerANDbookingList> customerList;

    /*
    -- 입력한 사용자 정보로 조회되는지 확인
    SELECT COUNT(*) FROM Customer
    WHERE customerName = ?
    AND password =  ?
    AND customerPhone = ?
    GROUP BY bookingNumber;
     */

    // 입력한 데이터로 조회되는 건이 있는지 확인하는 dao
    public boolean isUserInfo(CustomerDTO customerDTO) {
        if (isConnect()) {
            try {
                sql = "SELECT COUNT(*) FROM Customer WHERE customerName = ? AND password =  ? AND customerPhone = ? ";
                psmt = connection.prepareStatement(sql);
                psmt.setString(1, customerDTO.getCustomerName());
                psmt.setString(2, customerDTO.getPassword());
                psmt.setString(3, customerDTO.getCustomerPhone());
                resultSet = psmt.executeQuery();
                if (resultSet != null) {
                    return true;
                } else {
                    System.out.println("입력된 정보를 찾을 수 없습니다");
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resourceClose();
            }
        }
        return false;
    }

    public List<customerANDbookingList> userReservationReturn(CustomerDTO customer) {
        customerList = new ArrayList<>();
        if (isConnect()) {
            try {
                csmt = connection.prepareCall("{call reservation_info_proc(?,?,?,?)}");
                csmt.setString(1, customer.getCustomerName());
                csmt.setString(2, customer.getCustomerPhone());
                csmt.setString(3, customer.getPassword());
                csmt.registerOutParameter(4, OracleTypes.CURSOR);
                csmt.executeQuery();
                resultSet = (ResultSet) csmt.getObject(4);
                while (resultSet.next()) {
                    customerANDbookingList tmpCustomer = customerANDbookingList.getInstance();
                    // 오류발생
                    tmpCustomer.setLodgingName(resultSet.getString("lodgingName"));
                    tmpCustomer.setLodgingTel(resultSet.getString("lodgingTel"));
                    tmpCustomer.setLodgingAddr(resultSet.getString("lodgingAddr"));
                    tmpCustomer.setBookingNumber(resultSet.getInt("bookingNumber"));
                    tmpCustomer.setRoomName(resultSet.getString("roomName"));
                    tmpCustomer.setPriceTotal(resultSet.getInt("priceTotal"));
                    tmpCustomer.setReservationDay(resultSet.getInt("reservationDay"));
                    tmpCustomer.setCheckIn(String.valueOf(resultSet.getDate("checkIn")));
                    tmpCustomer.setCheckOut(String.valueOf(resultSet.getDate("checkOut")));
                    customerList.add(tmpCustomer);
                }
                return customerList;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resourceClose();
            }
        }
        return null;
    }
}
