package inheritance_farm;

public abstract class Mini_Farm {
    // super Class
    String name = null;
    int size = 0;
    int cnt = 0;
    public Mini_Farm(){}
    public void g_grocess(){
        System.out.print("물 주는 법 : ");
    }
    public void prt(){
        System.out.println("---------------");
        System.out.println("이름 : " + name);
        System.out.println("크기 : " + size);
        System.out.println("수량 : " + cnt);
    }

    // 추상메서드
    // 공통점 : 물주기 기능이 있다?
    public abstract void ww();
}
