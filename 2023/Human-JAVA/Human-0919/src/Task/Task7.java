package Task;

public class Task7 {
    public static void main(String[] args) {
        int roadx = 20;
        int roady = 100;

        // 위 좌표는 도로의 시작점 좌표이다.
        // 1차선은 10의 너비를 가진다
        // 도로는 4차선이다
        // 도로의 길이는 50이다.
        // 도로의 길이는 50이다. 도로의 길이는  y좌표에서 -50으로 계산한다.

        // 자동차의 현재 위치
        int carx = 32;
        int cary = 70;
        int size = 8;

        // 자동차는 사각형이며 사이즈는 가로,세로 각 8이다
        // 자동차는 몇 차선에서 주행하고 있는가 ?
        // 판단의 기준은 자동차 앞의 중간 지점이다.

        /*
         1차선의 범위 : x(20) ~ x+9 , y 50~100
         2차선의 범위 : x+10 ~ x+19 , y 50~100
         3차선의 범위 : x+20 ~ x+29 , y 50~100
         4차선의 범위 : x+30 ~ x+39 , y 50~100
        */

        if (roadx <= carx && carx <= roadx+40) {                                 // 도로의 x값 정의 20 ~ 60 사이에 car 있는지 확인 맞다면 아래로 이동
            if (roady - 50 <= cary && cary + size <= roady) {                    // 도로의 y값 정의 50 ~ 100 사이에 car 있는지 확인 맞다면 아래로 이동
                if (carx >= roadx && carx + size <= roadx + 10) {                // 도로의 x값(20) 과 carx값(32) 비교(참) && carx+8(40)과 roadx+10(30)비교(거짓)
                    System.out.println("1차선에 있다");                             // 참 && 거짓 = 거짓 으로 해당 행 실행 안됨
                } else if (roadx + 10 <= carx && carx + size <= roadx + 20) {    // 도로 x값(30)과 carx값(32) 비교(참) && carx+8(40)과 roadex+20(40)비교(참)
                    System.out.println("2차선에 있다");                             // 참 과 참 임으로 참 , 해당 문 실행
                } else if (roadx + 20 <= carx && carx + size <= roadx + 30) {    // 도로 x값(40)과 carx값(32) 비교(거짓) && carx+8(40)과 roadex(50)비교(참)
                    System.out.println("3차선에 있다");                             // 거짓 && 참 = 거짓 임으로 , 해당문 실행 안됨
                } else if (roadx + 30 <= carx && carx + size <= roadx + 40) {    // 도로 x값(50)과 carx값(32) 비교(거짓) && carx+8(40)과 roadex(60)비교(참)
                    System.out.println("4차선에 있다");                             // 거짓 && 참 = 거짓 임으로 , 해당문 실행 안됨
                }
            } else {
                System.out.println("차선에 없다 ");                                 // x 축과 y 축 전체 범위에 포함 되지 않을 경우 차선에 없다 라고 진행
            }
        }




    }
}