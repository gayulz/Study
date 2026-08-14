package reflection.data;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 14.
 * @fileName : BasicData
 */
public class BasicData {
    public String publicField;
    private int privatedFiled;


    public BasicData() {
        System.out.println("BasicData Class 기본 생성자 호출");
    }

    private BasicData(String data) {
        System.out.println("BasicData Class 파라미터 생성자 호출: " + data);
    }

    public void call(){
        System.out.println("BasicData.call() 호출");
    }

    public String hello(String str) {
        System.out.println("BasicData.hell() 호출");
        return str + " : hello";
    }
    private void privateMethod(){
        System.out.println("BasicData.privateMethod() 호출");
    }
    void defaultMethod(){
        System.out.println("BasicData.defaultMethod() 호출");
    }

    protected void protectedMethod(){
        System.out.println("BasicData.protectedMethod() 호출");
    }
}
