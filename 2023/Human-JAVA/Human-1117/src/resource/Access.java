package resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Access {

    private final static String url = "jdbc:oracle:thin:@localHost:1521:XE";
    private final static String username = "system";
    private final static String pass = "oracle";
    public static Connection connect;
    public static PreparedStatement psmt;
    public static ResultSet resultSet;
    public static String sql;

    // 커넥션 시도 리턴값 : 성공/실패
    public static boolean isConnect() {
        try {
            connect = DriverManager.getConnection(url, username, pass);
            System.out.println("Connections Success");
            return true;
        } catch (Exception e) {
            System.out.println("Connections Failed");
        }
        return false;
    }


    // 자원 반납 메서드정의
    public static void resourcesClose(){
        try {
            if ( psmt != null ) psmt.close();
            if ( connect != null ) connect.close();
            System.out.println("Resources return Success");
        }catch (Exception e){
            System.out.println("Resources return Failed");
        }
    }

}
