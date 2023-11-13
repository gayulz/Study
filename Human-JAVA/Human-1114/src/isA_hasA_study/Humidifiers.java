package isA_hasA_study;

public class Humidifiers {
    // todo : 가습기 super Class
    String powerStatus;
    String waterSupply = "물을 넣는다";
    String pushButton = "버튼을 누른다";
    String waterSpray = "물을 분사한다";
    int power = 0;
    public void processes(){
        power_Status_Prt(this.powerStatus);
        System.out.println(this.waterSupply);
        System.out.println(this.pushButton);
        System.out.println(this.waterSpray);
    }
    public void power_Status_Prt(String power){
       if (powerStatus.equals("powerOFF")){
           System.out.println("전원이 꺼져있습니다. 전원을 켜주세요");
       } else System.out.println("전원 연결 정상입니다.");
    }
}
