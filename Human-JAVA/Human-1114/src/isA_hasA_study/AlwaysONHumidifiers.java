package isA_hasA_study;

public class AlwaysONHumidifiers extends Humidifiers {
    // todo : 상시 전원이 필요한 가습기
    // 0 전원꺼짐
    // 1 전원켜짐

    public void always_ON_Humidifiers_Power(int power){
        if (power == 0) super.powerStatus = "powerOFF";
        if (power == 1) super.powerStatus = "powerON";
    }
}
