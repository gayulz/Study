package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.payDTO;
import rentalInfo.Rental_contract;

public class RentContractDAO extends Resource_DAO {
    private static RentContractDAO self = null;

    private RentContractDAO() {
    }

    private static ArrayList<payDTO> list = new ArrayList<>();

    public static RentContractDAO getInstance() {
        if (self == null) self = new RentContractDAO();
        return self;
    }

    public static ArrayList<payDTO> getList() {
        if (!list.isEmpty()) return list;
        return null;
    }

    // 사용자가 입력한 면허에 따른 렌트 가능 차의 목록을 가져와서 반환시켜주는 메서드
    public void licenseTpyeCars(String license) {
        Boolean trueConn = isConnections();
        if (trueConn) {
            try {
                // 1종 보통인지 다른 면허인지 확인
                if (license.equals("1종대형")) {
                    sql = "select * from rPossible_Van";
                    psmt = conn.prepareStatement(sql);
                    rs = psmt.executeQuery();
                }else if (license.equals("1종보통") || license.equals("2종보통")) {
                    sql = "select * from rPossible_NotVan";
                    psmt = conn.prepareStatement(sql);
                    rs = psmt.executeQuery();
                } else {
                    throw new Exception("잘못된 입력입니다");
                }
                // 결과 참조 가능하도록 연결
                while (rs.next()) {
                    payDTO tmp = new payDTO();
                    tmp.car_number = rs.getString("car_number");
                    tmp.car_title = rs.getString("car_title");
                    tmp.car_mnfct = rs.getString("car_mnfct");
                    tmp.car_fuel = rs.getString("car_fuel");
                    tmp.setDay_price(rs.getInt("day_price"));
                    tmp.setOver_price(rs.getInt("over_pirce"));
                    list.add(tmp);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("차량 조회 실패");
            } finally {
                resourcesClose();
            }
        }
    }


    // 예약 처리를 완료하는 메서드
    @Override
    public void setSqlquery_DAO() {
        Rental_contract rentTmp = Rental_contract.getInstance();
        boolean trueConn = isConnections();
        if (trueConn) {
            try {
                sql = "INSERT INTO lender VALUES(?,?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi'),?,default,?,?,?,?,?)";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, rentTmp.getLender_name());
                psmt.setString(2, rentTmp.getLender_age());
                psmt.setString(3, rentTmp.getLender_phone());
                psmt.setString(4, rentTmp.getLender_start());
                psmt.setInt(5, rentTmp.getLender_time());
                psmt.setString(6, rentTmp.getLender_pass());
                psmt.setString(7, rentTmp.getLender_licenseType());
                psmt.setString(8, rentTmp.getCar_number());
                psmt.setString(9, rentTmp.getLender_licenseNum());
                psmt.setInt(10, rentTmp.getTotal_price());
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 예약 되었습니다.");
                System.out.println("총 지불금액 : " + rentTmp.getTotal_price()+"입니다");
                status_change(rentTmp.getCar_number());
            } catch (Exception e) {
                System.out.println("차량 등록 오류");
                e.printStackTrace();
            } finally {
                resourcesClose();
            }
        }
    }


    // 차량 등록을 위한 sql query 처리 메서드
    public void status_change(String car_number) {
        boolean trueConn = isConnections();
        if (trueConn) {
            try {
                sql = "update RentCar set car_status='Y' where car_number=?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, car_number);
                psmt.executeQuery();
            } catch (Exception e) {
                System.out.println("차량 등록 오류");
            } finally {
                resourcesClose();
            }
        }
    }

    // 총 계산 메서드
    public payDTO get_Cost(String car_number) {
        boolean trueConn = isConnections();
        try {
            if (trueConn) {
                sql = "SELECT p.DAY_PRICE AS day_price, p.OVER_PRICE AS OVER_PRICE  FROM PAY p INNER JOIN RentCar r ON r.car_type = p.CAR_TYPE WHERE car_number = ?";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, car_number);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    payDTO tmp = new payDTO();
                    tmp.setDay_price(rs.getInt("DAY_PRICE"));
                    tmp.setOver_price(rs.getInt("OVER_PRICE"));
                    return tmp;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {

        } finally {
            resourcesClose();
        }
        return null;
    }
}
