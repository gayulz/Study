package resource;

public class Driver {
    // todo : driver class
    // 싱글톤 구성
    private Driver(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Load Succese");
        } catch (Exception e){
            System.out.println("Driver Load Failed");
        }
    }
    private static Driver self = null;
    public static Driver getInstance(){
        if ( self == null ) self = new Driver();
        return self;
    }
}
