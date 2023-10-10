package TASK;

import java.util.Random;
import java.util.Scanner;

public class task04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int[] road = {0, 1, 0, 0, 0, 1, 8, 8, 2, 8, 4, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 1, 7, 8, 0, 3, 0, 0, 7, 0, 0, 8, 0, 0, 1, 3, 0, 0, 1, 0};
        int me = -1; // 초기값으로 돌아감
        int randomInt = 0; // 랜덤 주사위 숫자 저장 변수
        int tot = 0;  // 주사위 숫자의 총 합산 = 총 이동거리 변수


        for (int i = 0; i < road.length; i++) {
            System.out.println("현재 인덱스 [" + i + "] 주사위를 던지세요 : 엔터키 입력");
            randomInt = r.nextInt(6) + 1; // 랜덤 수 입력
            in.nextLine();
            System.out.println("주사위 숫자 : " + randomInt); // 현재 주사위 수 출력
            tot += randomInt; // 거리에 주사위값 누적
            i += randomInt - 1; // 인덱스 이동 , 주사위 갯수에 -1을 하여 이동한다

            // i의 숫자가 44 이상일 경우(road 길이값) 출력후 게임 종료
            if (i >= road.length - 1) {
                System.out.println("------------도착 완료---------------");
                System.out.println("현재 i의 숫자 : " + i);
                System.out.println("총 거리는 : " + tot + "입니다");
                break;
            }

            // 인덱스[i]값이 1일 경우
            if (road[i] == 1) {
                System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                System.out.println("1칸 뒤로");
                i--;
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
            }

            // 인덱스[i]값이 2일 경우
            else if (road[i] == 2) {
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                i++;
                System.out.println("1칸 앞으로 | " + "현재 인덱스 번호 : " + i);
            }


            // 인덱스[i]값이 3일 경우
            else if (road[i] == 3) {
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                System.out.println("    [ 가위 바위 보 ]\n 이기면 1칸 앞으로 , 지면 1칸 뒤로, 비기면 제자리");
                int rpsPc = r.nextInt(2); // 가위바위보 pc 랜점정의 0 주먹 1 가위 2 보
                int userRps = 0;
                int[][] rpsRoll = {{0, -1, 1}, {1, 0, -1}, {-1, 1, 0}};
                for (int j = 0; j < 1; j++) {
                    System.out.println("0 : 주먹\n1 : 가위\n2 : 보\n0~2까지 숫자를 입력해주세요");
                    userRps = in.nextInt();
                    if (userRps < 0 || userRps > 2) {
                        System.out.println("다시 입력 해 주세요");
                        j--;
                    } else {
                        continue;
                    }
                }
                System.out.println("PC : " + rpsPc + " | User : " + userRps);
                int result = rpsRoll[rpsPc][userRps];
                System.out.println("결과는 : [" + result + "] 입니다");
                i = i + result;
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                in.nextLine();
            }


            // 인덱스[i]값이 4일 경우
            else if (road[i] == 4) {
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                System.out.println("----------------------------------------------");
                System.out.println("랜덤수를 추첨합니다 , 짝수이면 앞으로 3칸 , 홀수이면 뒤로 3칸");
                int tmp = r.nextInt();
                System.out.println("뽑힌 수는 [" + tmp + "]입니다");
                if (tmp % 2 == 0){
                    System.out.println("짝수입니다 + 3 이동합니다");
                    i+=3;
                    System.out.println("3칸 앞으로 >> " + "현재 인덱스 번호 : " + i);
                } else {
                    System.out.println("홀수 입니다 - 3 이동합니다");
                    i -= 3;
                    System.out.println("3칸 뒤로 >> " + "현재 인덱스 번호 : " + i);
                }
                in.nextLine();
            }


            // 인덱스[i]값이 7일 경우
            else if (road[i] == 7) {
                System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                i = me;
                System.out.println(" 처음으로 돌아가기 ");
            }


            // 인덱스[i]값이 8일 경우
            else if (road[i] == 8) {
                System.out.println("현재 인덱스 번호 : " + i + "현재 인덱스 번호 값 : " + road[i]);
                System.out.println("----------------------------------------------");
                System.out.println("    [ 업&다운 게임(0~10) ] \n3번의 기회가 주어집니다\n이기면 + 5 , 지면 - 3 입니다 ");
                int rpsPc = r.nextInt(10); // 업다운 게임 pc 입력 값
                for (int j = 0; j < 3; j++) {
                    System.out.print("숫자를 입력해 주세요 : ");
                    int userRps = in.nextInt();

                    if (rpsPc > userRps){
                        System.out.println("업");
                    } else if ( rpsPc < userRps ) {
                        System.out.println("다운");
                    } else {
                        System.out.println("PC의 값은 : " + rpsPc + "입니다");
                        System.out.println("이겼습니다 , 앞으로 5칸 이동합니다");
                        i+=5;
                        System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                        break;
                    }
                    if (j == 2 && rpsPc != userRps ){
                        System.out.println("PC의 값은 : " + rpsPc + "입니다");
                        System.out.println("졌습니다. 뒤로 3칸 이동합니다");
                        i-=3;
                        System.out.println("현재 인덱스 번호 : " + i + "\n현재 인덱스 번호 값 : " + road[i]);
                    }
                }
                in.nextLine();
            }
            else {
                System.out.println("현재 인덱스 번호 : " + i);
                System.out.println("해당 인덱스 번호 값 : " + road[i]);
            }
            System.out.println("----------------------------------------------");
        }
    }
}
