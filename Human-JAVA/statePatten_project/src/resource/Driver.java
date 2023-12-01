package resource;

public class Driver {

    private static Driver instance;
    private Driver(){}
    public static Driver getInstance(){
        if(instance == null){
            instance = new Driver();
        }
        return instance;
    }

    public void loadDriver(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        }catch (ClassNotFoundException e){
            System.out.println("드라이버 로드 실패");
            e.printStackTrace();
        }
    }
}
