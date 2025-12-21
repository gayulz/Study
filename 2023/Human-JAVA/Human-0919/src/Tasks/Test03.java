package Tasks;

public class Test03 {
    public static void main(String[] args) {
        /*
        3. 철수는 사냥놀이를 하고 있다.

        현재 종이모양의 새가 x축에는 30, y축에는 20
        철수의 총알이 ballx =3, bally=5에 위치해 있다.
        총알이 진행방향으로 직선으로만 날아간다고 가정한다.

        철수의 총알이 새를 맞출 수 있을까?
        */
        /*
        기울기 계산법
        x 증가량 / y 증가량 = 기울기값
        */
        int birdx = 30; // 3의 배수
        int birdy = 20; // 5의 배수
        int bulletX = 3;
        int bulletY = 5;

        double bulletavg = (float)bulletY/bulletX;
        double birdavg = (float)birdy/birdx;

        // 5/3 = 1.666666
        // 30/3 : 10 / 3 = 3.3 .....
        // 20/5 : 4 / 5 = 0.8 .....


        if(bulletavg == birdavg){
            System.out.println("총에 맞는다");
        } else {
            System.out.println("총에 맞지 않는다");
        }

    }
}
