package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {
    boolean trueConn = AccessDAO.getConnection();

    public void bookinsert() {
        if (trueConn == true) {
            Connection conn = AccessDAO.getConn();
            PreparedStatement psmt = null;

            try {
                String sql = "insert into Book values (?,?,default)";
                psmt = conn.prepareStatement(sql);

            } catch (Exception e) {

            }

        }
    }
}

