package makeTv;

public class BasicTV extends TV{
    public BasicTV(){}

    public void setting(String mm, String mnfc){
        super.makeDay=mm;
        super.makeCom=mnfc;
    }

    public void testing(){
        System.out.println(super.makeDay);
        System.out.println(super.makeCom);
        turnOn();
        turnOff();
    }

    public void turnOn() {
        super.turnOn();
        System.out.println("전원이 켜져있는지 확인한다");
    }

    @Override
    public void turnOff() {
        System.out.println("일반 티비 종료 절차");
        System.out.println("전원 종료 ");
    }
}
