package Tasks;

public class Test01 {
    public static void main(String[] args) {

        /*
        1.  철수의 점수 60점을 입력하고.
        철수의 점수가 짝수이면 철수의 점수에서 10%를 더하여 저장하세요
        철수의 점수가 홀수이면 철수의 점수에서 10%를 마이너스 하여 저장하세요.
        */

        double point = 100;

        if(point % 2 ==0){
            point += +point*0.1;
        } else if (point % 2 == 1){
            point -= point*0.1;
        }

        System.out.println((int)point);
    }
}
