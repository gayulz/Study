package DAO;
import DTO.Rental_Success;
import java.util.ArrayList;

public class RentSuccessDAO extends Resource_DAO {
    private static RentSuccessDAO self = null;
    private RentSuccessDAO(){}
    private static ArrayList<Rental_Success> list = new ArrayList<>();

    public static RentSuccessDAO getInstance(){
        if (self == null) self = new RentSuccessDAO();
        return self;
    }
    public static ArrayList<Rental_Success> getList() {
        if (list.size() > 0) return list;
        return null;
    }

    @Override
    public void setSqlquery_DAO() {
        boolean trueConn = isConnections();
        if (trueConn) {
            try {
                sql = "SELECT * FROM Rental_Success";
                psmt = conn.prepareStatement(sql);
                rs = psmt.executeQuery();
                while (rs.next()) {
                    Rental_Success tmp = new Rental_Success();
                    tmp.setCar_number(rs.getString("car_number"));
                    tmp.setLender_name(rs.getString("lender_name"));
                    tmp.setLender_start(rs.getString("lender_start"));
                    tmp.setLender_end(rs.getString("lender_end"));
                    list.add(tmp);
                }
            } catch (Exception e) {
                System.out.println("!!예외발생!!");
                e.printStackTrace();
            } finally {
                resourcesClose();
            }
        }
    }
}
