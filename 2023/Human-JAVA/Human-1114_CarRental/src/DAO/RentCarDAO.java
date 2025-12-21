package DAO;
import rentalInfo.Rental_CarAdd;

public class RentCarDAO extends Resource_DAO{
    // todo : 차량 등록을 위한 DAO
    public RentCarDAO(Rental_CarAdd newCar){
        super.newCar = newCar;
        setSqlquery_DAO();
    }
    @Override
    public void setSqlquery_DAO() {
        // 차량 등록을 위한 sql query 처리 메서드
        boolean trueConn = isConnections();
        if (trueConn){
            try {
                sql = "INSERT INTO RentCar VALUES(?,?,?,?,?,?,?,'N')";
                psmt = conn.prepareStatement(sql);
                psmt.setString(1, newCar.car_number);
                psmt.setString(2, newCar.owner_name);
                psmt.setString(3, newCar.owner_phone);
                psmt.setString(4, newCar.car_title);
                psmt.setString(5, newCar.car_type);
                psmt.setString(6, newCar.car_mnfct);
                psmt.setString(7, newCar.car_fuel);
                psmt.executeQuery();
                System.out.println(newCar.car_title + " 등록완료");
            } catch (Exception e){
                System.out.println("차량 등록 오류");
            } finally {
                resourcesClose();
            }
        }
    }
}
