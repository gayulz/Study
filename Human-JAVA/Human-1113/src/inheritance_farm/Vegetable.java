package inheritance_farm;

public class Vegetable extends Mini_Farm {
    public Vegetable(){}

    @Override
    public void g_grocess() {
        super.g_grocess();
        System.out.println("일주일에 한번 물을 주세요");
    }

    @Override
    public void ww() {

    }
}
