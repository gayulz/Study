package dao;

import dto.customerANDbookingList;
import resource.Connection;

public class cancelReservationDAO extends Connection {
    // 싱글톤
    private cancelReservationDAO(){}
    private static class holderInstance{
        public static final cancelReservationDAO INSTANCE = new cancelReservationDAO();
    }
    public static cancelReservationDAO getInstance(){
        return holderInstance.INSTANCE;
    }

    // 멤버변수
    private customerANDbookingList customer;


    public boolean deleteUserReservation(customerANDbookingList customer){
        this.customer = customer;
        if (isConnect()){
            try {
                sql = "DELETE FROM Customer WHERE bookingNumber = ?";
                psmt = connection.prepareStatement(sql);
                psmt.setInt(1, customer.getBookingNumber());
                resultSet = psmt.executeQuery();
                if ( resultSet != null ) return true;
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                resourceClose();
            }
        }
        return false;
    }

}