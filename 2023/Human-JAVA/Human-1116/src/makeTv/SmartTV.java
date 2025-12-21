package makeTv;
import internet.KTnet;
import internet.ispInf;

public class SmartTV extends TV {
    public SmartTV(){}
    ispInf net = null;

    public void setting(String makeDay, String makeCom, ispInf net){
        super.makeDay=makeDay;
        super.makeCom=makeCom;
        this.net = net;
    }

    public void testing(){
        System.out.println(super.makeDay);
        System.out.println(super.makeCom);
        turnOn();
        turnOff();
    }

    public void turnOn() {
        super.turnOn();
        System.out.println("모뎀이 켜져있는지 확인한다");
    }

    @Override
    public void turnOff() {
        System.out.println("스마트 티비 종료 절차");
        System.out.println("인터넷 종료 확인, 전원 종료 ");
    }
}
