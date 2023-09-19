package TEST01;

public class sampleTEST06 {
    public static void main(String[] args) {
        //  문제 6
        //  골프장 벙커에 빠진 공

        //  int x = 30;
        //  int y = 24;
        //  int size = 20; // 벙커의 크기
        //  x와 y는 좌표이다.
        //  초기값을 뜻함
        //  벙커의 크기는 시작점이  x,y에서 사각형모양으로  x좌표에서 + 20만큼, y좌표에서 -20만큼 위치되어 있다.
        //  벙커 사이즈와 위치 정의
        int x = 30;
        int y = 24;
        int size = 20;
        int xx = x + size;
        int yy = y - size;

        //  현재 볼의 위치는 다음과 같고 볼의 크기는 다음과 같다.
        //  int ballx=40;
        //  int bally=34;
        //  int ballsize=3;
        //  ballx에서 + 3, bally에서 +3만큼이 볼의 크기이다.
        //  볼도 사각형모양이다
        //  공은 벙커에 빠졌는지.. 판단하는 프로그램을 작성하시오.

        int ballx = 40;
        int bally = 34;
        int ballsize = 3;

//       x(30) ~ xx(50) , yy(4) ~ y(24)
//       x <= ballx <= xx , yy <= bally+3 <= y
//       x <= ballx && ballx <= xx , yy <= bally && bally+3 <= y

        if ((x <= ballx) && (ballx + 3 <= xx)) {
            if ((yy <= bally) && (bally + 3 <= y)) {
                System.out.println("벙커 안에 있다");
            } else {
                System.out.println("벙커 안에 없다");
            }
        }



        String r = (x <= x + size && y - size <= y) &&
                (ballx + 3 <= x + size && bally + 3 <= y) ?  "벙커 안에 있다" : "벙커 안에 없다" ;
        System.out.println(r);



    }
}
