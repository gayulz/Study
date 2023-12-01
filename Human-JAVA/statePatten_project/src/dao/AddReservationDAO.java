package dao;

import changeFrame.BookingFrame;
import dto.CustomerDTO;
import resource.Connection;

import java.sql.Date;
import java.sql.ResultSet;

public class AddReservationDAO extends Connection {
    // 싱글톤
    private AddReservationDAO(){}
    private static class holderInstance{
        public static final AddReservationDAO INSTANCE = new AddReservationDAO();
    }
    public static AddReservationDAO getInstance(){
        return holderInstance.INSTANCE;
    }

    // 멤버 변수 선언
    private static AddReservationDAO instance;
    private static CustomerDTO customer;

    public static int getBookingNumber() {
        return bookingNumber;
    }

    private static int bookingNumber;

    public boolean addReservation(CustomerDTO customerDTO){
        customer = customerDTO;
        boolean result = true;
        if (isConnect()){
            try {
                csmt = connection.prepareCall("{CALL Insert_customer_proc(?,?,?,?,?,?,?)}");
                csmt.setInt(1, customerDTO.getRoomNumber());
                csmt.setString(2, customerDTO.getCustomerName());
                csmt.setString(3, customerDTO.getCustomerPhone());
                csmt.setString(4, customerDTO.getPassword());
                csmt.setString(5, customerDTO.getPaymentInfo());
                csmt.setDate(6, Date.valueOf(customerDTO.getCheckIn()));
                csmt.setDate(7, Date.valueOf(customerDTO.getCheckOut()));
                if (csmt.execute()) return result;
            } catch (Exception e){
                e.printStackTrace();
                result = false;
            } finally {
                resourceClose();
            }
        }
        return result;
    }

    public int reservationNumberReturn(){
        if (isConnect()){
            try {
                sql = "Select bookingNumber From Customer WHERE customerName = ? AND customerPhone = ? AND password = ?";
                psmt = connection.prepareStatement(sql);
                psmt.setString(1, customer.getCustomerName());
                psmt.setString(2, customer.getCustomerPhone());
                psmt.setString(3, customer.getPassword());
                resultSet = psmt.executeQuery();
                if (resultSet.next()) {
                    if (bookingNumber == resultSet.getInt("BookingNumber")){
                        System.out.println("예약번호 확인 : " + bookingNumber);
                        return bookingNumber;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resourceClose();
            }
        }
        return 0;
    }
}
