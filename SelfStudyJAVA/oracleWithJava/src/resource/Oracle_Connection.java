package resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Oracle_Connection {

    private final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private final static String username = "system";
    private final static String pass = "oracle";
    private static Connection self = null;
    static {
        try {
            self = DriverManager.getConnection(url, username, pass);
//            System.out.println("DataBase Connection Success");
        } catch (SQLException e) {
            throw new RuntimeException("DataBase Connection fail", e);
        }
    }
    private Oracle_Connection() {}

    public static Connection getConnection(){
        return self;
    }
}
