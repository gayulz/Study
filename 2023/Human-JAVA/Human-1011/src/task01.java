import java.util.Scanner;

import static java.lang.Character.*;

public class task01 {
    public static void main(String[] args) {
        // #human@study@today!!@#$%^&*#
        Scanner in = new Scanner(System.in);
        boolean flag = true;

        // flag 값이 최종 false로 될때까지 무한 반복한다.

        while (flag) {
            // @ 카운트 변수 선언
            int speCnt = 0;
            // @ 를 제외한 나머지 특수문자 카운트 선언
            int notSpeCnt = 0;
            // 숫자 카운트
            int intSpeCnt = 0;
            // 입력 불가 특수문자 선언
            String sign = "!@#$%^&*";
            // id 입력
            System.out.print("[ 필수 특수문자 @ 1개 , 필수 숫자 3개이상 ] \n\t\tID 를 입력 해 주세요 : ");
            // id 키보드 입력받기
            String idStr = in.nextLine();
            // 검사 진행 시 편리를 위해 char배열로 처리함
            char[] arrIdStr = idStr.toCharArray();

            // 검사 시작
            for (int i = 0; i < arrIdStr.length; i++) {
                // 배열별 값을 iTmp로 임시저장
                char iTmp = arrIdStr[i];

                // 영문일 경우 별다른 처리 없이 건너띔
                // iTmp 값이 영어 대문자-소문자가 아닐경우(특수 문자일 경우)
                if (!isAlphabetic(arrIdStr[i])) {
                    for (int j = 0; j < sign.length(); j++) {
                        char jTmp = sign.charAt(j);
                        // @ 특수문자 갯수 카운팅
                        if (iTmp == '@') {
                            speCnt++;
                            break;
                        }
                        // 그외 특수문자 갯수 카운팅
                        else if (iTmp == jTmp) {
                            notSpeCnt++;
                            break;
                        }
                        // 숫자 일 경우 숫자 카운팅
                        else if (iTmp >= 48 && iTmp <= 57) {
                            intSpeCnt++;
                            break;
                        }
                    }
                }
            }

            if (idStr.trim().isEmpty()) {
                System.out.println("입력하신 ID가 없습니다. 다시 입력해 주세요");
                System.out.println("----------------------------------------------------------------------------------");
            }
            // @개 2개부터 , 그외 특수문자 1개부터 , 특수문자 3개 미만 경우 : 재입력
            else if (notSpeCnt > 0 || (speCnt >= 2 && intSpeCnt < 3)) {
                System.out.println("입력된 @ 문자 개수: " + speCnt);
                System.out.println("입력 불가 특문 개수 : " + notSpeCnt);
                System.out.println("입력된 숫자 개수 : " + intSpeCnt);
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("\t|| 삭제할 @ 개수 : " + (speCnt - 1) + " ||\t|| 삭제할 특수문자 개수 : " + notSpeCnt + " ||\t|| 추가할 숫자 개수 : " + (3 - intSpeCnt + " ||"));
                System.out.println("----------------------------------------------------------------------------------");

            }
            // 모든 검사 항목이 정상 : while 문의 flag를 false로 변경 ,  while문 탈출
            else if (intSpeCnt >= 3 && notSpeCnt <= 0 && speCnt == 1) {
                System.out.println("입력하신 ID [" + idStr + "] 는 사용 가능한 ID 입니다\n당신의 ID는 [" + idStr + "] 입니다");
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("프로그램을 종료합니다");
                flag = false;
            }
            // 모든 사항이 아닐 경우 : 재입력
            else {
                System.out.println("입력하신 ID는 유효하지 않습니디. 다시 입력해 주세요");
                System.out.println("-----------------------------------------------------------------------------");
            }
        }
    }
}