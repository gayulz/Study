package block1.block;
import java.util.Scanner;

public class MemoryTest {
    String[] engArr = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    String[] userArr = new String[engArr.length]; // 사용자의 답안지
    boolean[] X = new boolean[engArr.length]; // 정답인 것들 체크 ( true 일때 정답 )
    int cnt = 0; // 정답카운트
    int hint = 0; // 틀릴때마다 나오는 힌트문자의수
    boolean chk = false; // 정답, 오답 체크
    boolean flag = false; // 루프문 조건
    long startTime = System.currentTimeMillis(); // game Init Time
    long t1 = 0; // start
    long t2 = 0; // end
    String tmp = "";
    String userIn = "";
    Scanner in = new Scanner(System.in);

    public MemoryTest() {
        Opening(); // 외워야할 단어 출력 , 엔터 대기상태
        GamePlaying(); // 게임 진행
        ElapsedTime(); // 전체 소요 시간 계산 및 출력
    }

    public void GamePlaying() {
        while (cnt < 12 && flag == false) {
            Display(); // 콘솔창에 출력
            Input(); // 단어입력
            Answer(); // 정답 판별
        }
    }

    public void Opening() {
        Init_Display();
        System.out.println("\n");
        System.out.println("단어들을 암기하세요. 테스트 준비가 되셨으면 Enter를 누르세요!");
        in.nextLine();
    }

    public void Init_Display() { // 초기 배열(단어)값 대입후 출력
        ArrLoop(0);
        ArrLoop(1);
    }

    public void Display() { // 현재 배열상태를 콘솔에 출력
        ArrLoop(2);
    }

    public void Input() { // 사용자 단어입력
        t1 = System.currentTimeMillis(); // 타이머측정시작 시점
        System.out.println("\n" + "단어를 입력하고 엔터를 누르세요. (" + (cnt + 1) + "/ 12)");
        System.out.println("q 입력시 게임을 종료합니다.");
        String strInput = in.nextLine();
        userIn = strInput; // 입력받은 단어를 userIn에 저장
    }

    public void Answer() {
        if (userIn.equals("q")) { // q일때 루프문 종료 ( 게임 종료 )
            System.out.println("게임을 종료합니다. 부순 불록의 갯수는 " + cnt + " 개 입니다.");
            flag = true;
            cnt = 12;
        }
        if (flag == false) { // 바깥 while문 조건 ( 게임 종료 상태가 아닐때 )
            ArrLoop(3);
            if (chk == false) { // 오답일때
                ArrLoop(4);
                hint++;
                System.out.println("일치하는 단어가 존재하지않습니다. 다시 입력하세요.\n");
            } else {
                t2 = System.currentTimeMillis(); // 시간측정 종료
                System.out.println("정답입니다 !! " + userIn + " 을(를) 맞추는데까지의 소요시간 : " + ((t2 - t1) / 1000) + " 초\n");
                chk = false; // reset
                if (cnt == 12) { // 모두맞췄을때
                    System.out.println("모든 문제를 맞추셨습니다!! 게임을 종료합니다.");
                }
            }
        }
    }

    public void ArrLoop(int cond) { // 루프 제어
        for (int i = 0; i < engArr.length; i++) {
            if ( cond == 0 ) { // 암기할 단어 출력
                for (int j = 0; j < engArr[i].length(); j++) {
                    tmp += "☆";
                }
                userArr[i] = tmp;
                tmp = "";
            } else if ( cond == 1 ) {
                System.out.print(String.format("◇  %-10s", engArr[i]));
                if ((i + 1) % 4 == 0) { // 4의 배수마다 줄바꿈
                    System.out.println();
                }
            } else if ( cond == 2 ) { // 현재 배열의 상태 출력
                System.out.print(String.format("◇  %-10s", userArr[i]));
                if ((i + 1) % 4 == 0) { // 4의 배수마다 줄바꿈
                    System.out.println();
                }
            } else if (cond == 3) { // 정답체크
                if (userIn.equals(engArr[i])) {
                    chk = true;
                    userArr[i] = "★" + userIn + "★";
                    X[i] = true; // 정답처리
                    cnt++; // 정답횟수
                }
            } else if (cond == 4) { // 오답일때 힌트주는 단락
                if (X[i] == false) { // 정답을 맞추지않은 문제일때
                    for (int j = 0; j < engArr[i].length(); j++) {
                        if (j <= hint) { // hint변수 값에 따라서 힌트문자 대입
                            tmp += engArr[i].charAt(j);
                        } else {
                            tmp += "☆";
                        }
                    }
                    userArr[i] = tmp;
                    tmp = "";
                }
            }
        }
    }

    public void ElapsedTime() { // 소요시간 계산 및 출력
        t2 = System.currentTimeMillis(); // 측정후 단위 밀리세컨드
        System.out.println("소요 시간 : " + ((t2 - startTime) / 1000 / 60) + " 분 " + (((t2 - startTime)/1000)%60) + " 초");
    }
}
