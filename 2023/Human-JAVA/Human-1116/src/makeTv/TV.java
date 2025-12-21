package makeTv;

public abstract class TV {
    public TV(){}
    String makeDay = null;
    String makeCom = null;
    public void turnOn(){
        System.out.println("절차 : 전원 확인 , 화면 표시");
    }
    public abstract void turnOff();
}
