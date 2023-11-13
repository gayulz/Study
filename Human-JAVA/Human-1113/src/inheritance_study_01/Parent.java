package inheritance_study_01;

public class Parent {
    String name = "Human";
    Parent(){
        System.out.println("슈퍼 클래스 생성자입니다");
    }
    public void aaa(){
        System.out.println("super Class : " + name);
    }
}
