package inheritance_study_01;

public class Main {
    public static void main(String[] args) {
        // todo : test
        // 서브 클래스 객체를 생성 시 자동으로 슈퍼클래스가 생성된다
        // new Child();
        // new Child();
        // new Child();
        Parent a = new Child();
        System.out.println(a.name);

        Child b = new Child();
        b.name = "AI";
        System.out.println(b.name);

        // 다형성
        Parent c = new Child();
        // super 클래스의 멤버변수가 우선된다
        System.out.println(c.name);

        // 부모클래스 변수명 = new 자식클래스
        // 슈퍼클래스 참조 변수는 슈퍼클래스를 상속 받은 객체도 참조가 가능하다
        // 슈퍼클래스 자료형
        Parent d = new Child_2();

        Parent f = new Child_2();
        System.out.println("----------");
        f.aaa();
        System.out.println(f.name);
        System.out.println(d.name);

//        a.b -> Error
//        자식이 만들어 놓은 객체는 부모는 접근할 수 없다
//        부모가 자식이 가진 변수명과 메서드명을 모르면 접근을 할 수 없다
//        a.aaa(); -> Error
        a.aaa();
        d.aaa();

    }
}
