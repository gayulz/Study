package resource;
import java.sql.Connection;
import java.sql.PreparedStatement;

class Resource_Close_ALL {
    private Resource_Close_ALL() {}
    private static Connection conn = null;
    private static PreparedStatement psmt = null;
    private static Resource_Close_ALL self = null;

    static {
        try {
            if ( psmt != null ) psmt.close();
            if ( conn != null ) conn.close();
        }catch (Exception e){
            System.out.println("Resource return Error");
        }
    }

    public static Resource_Close_ALL getCloseAll(){
        if (self == null) self = new Resource_Close_ALL();
        return self;
    }
}
