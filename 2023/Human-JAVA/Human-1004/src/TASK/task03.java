package TASK;
import java.util.Random;
import java.util.Scanner;

public class task03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int[] road = {0, 1, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 7, 0, 0, 3, 0, 0, 7, 0, 0, 8, 0, 0, 1, 3, 0, 0, 1, 0};
        int me = -1; // 초기값으로 돌아감
        int randomInt = 0; // 랜덤 주사위 숫자 저장 변수
        int tot = 0;  // 주사위 숫자의 총 합산 = 총 이동거리 변수

        for (int i = 0; i < 44; i++) {
            System.out.println("현재 인덱스 [" + i + "] 주사위를 던지세요 : 엔터키 입력");
            in.nextLine();
            randomInt = r.nextInt(6) + 1; // 랜덤 수 입력
            System.out.println("주사위 숫자 : " + randomInt); // 현재 주사위 수 출력
            tot+=randomInt; // 거리에 주사위값 누적
            i+=randomInt-1; // 인덱스 이동 , 주사위 갯수에 -1을 하여 이동한다
            if (i >= road.length) {  // i의 숫자가 44 이상일 경우(road 길이값)
                System.out.println("------------도착 완료---------------");
                System.out.println("총 거리는 : " + tot + "입니다");
                break;
            }
            if (road[i] == 1) {  // i의 값이 1일 경우
                System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                System.out.println("1칸 뒤로");
                i--;
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
            } else if (road[i] == 2) {
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                i++;
                System.out.println("1칸 앞으로 | " + "현재 인덱스 번호 : " + i );

            } else if (road[i] == 7) {
                System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                i = me;
                System.out.println(" 처음으로 돌아가기 ");
            } else {
                System.out.println("현재 인덱스 번호 : " + i);
                System.out.println("해당 인덱스 번호 값 : " + road[i]);
            }
            System.out.println("----------------------------------------------");
        }
    }
}
