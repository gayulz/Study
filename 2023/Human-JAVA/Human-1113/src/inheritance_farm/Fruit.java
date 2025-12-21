package inheritance_farm;

public class Fruit extends Mini_Farm {
    int brics = 20;
    public Fruit(){}
    public void brics_prt(){

    }

    @Override
    public void g_grocess() {
        super.g_grocess();
        System.out.println("이틀에 한번씩 물을 주세요");
    }

    @Override // 재 정의 표시
    public void prt(){
        super.prt();
        System.out.println("안녕 나는 서브클래스야");
        System.out.println("당도 : " + brics);
    }
    // 추상 메서드가 1개라도 있다면 클래스도 추상화 클래스로 만들어줘야한다

    @Override
    public void ww() {

    }
}
