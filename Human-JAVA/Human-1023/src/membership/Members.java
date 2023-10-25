package membership;
// 클래스 정의 : 1명의 고객을 정의
public class Members {
    /*
       생성자를 작성하지 않으면 자바는 자동으로 생성자를 생성해준다.
       아래 생성자는 생략이 가능하다
       Members() { }
    */
    String name = null;
    String addr = null;
    int age = 0;

    public void prt(){
        System.out.println(" Name : " + name);
        System.out.println(" Addr : " + addr);
        System.out.println("  Age : " + age);
    }
}
