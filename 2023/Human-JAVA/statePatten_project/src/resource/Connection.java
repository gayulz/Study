package resource;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "oracle";
    protected static String sql;
    protected static java.sql.Connection connection;
    protected static ResultSet resultSet;
    protected static PreparedStatement psmt;
    protected static CallableStatement csmt;

    protected Connection(){}
    protected Boolean isConnect(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("연결 성공");
            return true;
        }catch (Exception e){
            System.out.println("연결 실패");
            e.printStackTrace();
            return false;
        }
    }

    protected void resourceClose(){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(psmt != null){
                psmt.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("자원해제 실패");
        }
    }
}
