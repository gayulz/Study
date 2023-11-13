package inheritance_farm;

import java.util.ArrayList;

public class Main {
        // 이 자료형이 가지고 있는 변수와 메서드를 접근하는 것
        // 다형성이란 ?
        // 변수의 값으로 참조할 수 있는 것이
        // super Class로 부터 상속받은 모든 객체다.
        // 단 조건은 변수의 자료형이 super Class여야 한다
    public static void main(String[] args) {

        // 추상화 클래스는 객체로 만들어 질 수 없다
        // 추상메서드는 무조건 상속을 받아야 하며 재정의를 해야한다
        // 추상화 클래스를 쓰는 이유 ?

        ArrayList<Mini_Farm> vlist = new ArrayList<>();
        
        Vegetable v1 = new Vegetable();
        v1.name = "상추";
        vlist.add(v1);
        v1 = new Vegetable();
        v1.name = "배추";
        vlist.add(v1);

        Fruit f1 = new Fruit();
        f1.name = "사과";
        vlist.add(f1);
        f1 = new Fruit();
        f1.name = "포도";
        vlist.add(f1);

        for (Mini_Farm v : vlist) {
            v.g_grocess();
            v.prt();
        }

    }
}
