package Task;

public class Task6 {
    public static void main(String[] args) {
        int me = 0;
        int you = 0;
        String Victory = "";

        // 1은 가위, 2는 바위, 0은 보이다
        // 가위바위보 게임의 승자를 판별하시오
        // me you 숫자 차이가 1만 나면 큰수가 이기고
        // me you 숫자 차이가 2가 나면 낮은 수가 이긴다

        if (me > you) {
            Victory = (me - you == 1)? "me가 이겼어요" : "you가 이겼어요"; }
        if(me < you) {
            Victory =  ( you - me == 1) ? "you가 이겼어요 " : "me가 이겼어요";}
        if(me==you){
            Victory = "동점이예요"; }
        System.out.println(Victory);

    }
}
