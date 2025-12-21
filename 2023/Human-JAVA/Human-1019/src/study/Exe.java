package study;

import java.util.Scanner;

public class Exe {
    Scanner in = new Scanner(System.in);
    final static String EXIT = "EXIT";
    // 입력받을 변환 전 숫자 변수
    int inPutNum = 0;
    // 입력받을 변환 전 아스키코드 변수
    String inputAscii = "";
    // 입력받을 변환 전 아스키코드 변수
    String inputHex = "";
    // 변경 전 진수 선택 변수
    String beforNum = "";
    // 변경 후 진수 선택
    String afterNum = "";
    String[] mathList = {"2진수", "8진수", "10진수", "16진수", "아스키코드"};

    // 생성자
    public Exe() {
        info();
        in.nextLine();
        boolean flag = true;
        while(flag){
            switch (calculatorsMenu()){
                case 0 :
                    // 입력값 = 2진수
                    break;
                case 1 :
                    // 입력값 = 8진수
                    break;
                case 2 :
                    // 입력값 = 10진수
                    break;
                case 3 :
                    // 입력값 = 16진수
                    break;
                case 4 :
                    // 입력값 = 아스키코드
                    break;
            }
            // i 값 : 0 = 2진수 , 1 = 8진수, 2 = 10진수, 3 = 16진수, 4 = 아스키코드
        }

    }

    // 사용자가 변경 전 후의 진수와 입력할 숫자 및 문자 확인
    private int calculatorsMenu() {
        int answer = 0;
        System.out.print("\t입력 할 내용의 진수 or 아스키코드인지 입력 >> ");
        beforNum = in.nextLine();
        boolean flag = true;
        for (int i = 0; i < mathList.length; i++) {
            if (i < 3 && mathList[i].equals(beforNum)) {
                System.out.print("\t입력할 숫자 입력 >> ");
                inPutNum = in.nextInt();
                answer = i;
            } else if (mathList[3].equals(beforNum)) { // 16진법인 경우
                System.out.print("\t입력할 16진법 입력 >> ");
                inputHex = in.nextLine();
                answer = i;
            } else if (mathList[4].equals(beforNum)) { // 아스키 코드인 경우
                System.out.print("\t입력할 아스키 코드 숫자나 문자를 입력 >> ");
                inputAscii = in.nextLine();
                answer = i;
            }
        }
        if (flag == true) {
            System.out.print("\t변경 후 내용[진수 or 아스키코드] 입력 >> ");
            afterNum = in.nextLine();
            System.out.println(" 변경 전 [" + mathList[answer] + "] ----> 변경 후[" + afterNum + "]을 선택하였습니다.");
        }
        // i 값 : 0 = 2진수 , 1 = 8진수, 2 = 10진수, 3 = 16진수, 4 = 아스키코드
        return answer;
    }

    // 사용법 메서드 정의
    private void info() {
        System.out.println("  ＾  　0o0\n" +
                " ミ ・ 。・ ミ\t\t\t [ 진수 변환 계산기 ]\n" +
                "—○———○———————\n");
        System.out.println(" =͟͟͞͞♡ 사용법 =͟͟͞͞♡ ");
        System.out.println(" ✎⁾⁾⁾__ [ 메뉴 : 2진수 , 8진수, 10진수, 16진수, 아스키코드 ]");
        System.out.println(" ✎⁾⁾⁾__ 입력할 내용의 진수 or 아스키코드 여부 입력 (예 : 2진수, 16진수, 아스키코드...)");
        System.out.println(" ✎⁾⁾⁾__ 변환 할 숫자or문자(아스키코드) 1개 입력 (예 : 65 , A , B ...)");
        System.out.println(" ✎⁾⁾⁾__ 변환 할 진수 or 아스키코드 입력(예 : 2진수,10진수,16진수...)");
        System.out.println(" ✎⁾⁾⁾__ 종료시 EXIT (소문자 입력도 가능)입력 후 엔터");
        System.out.println(" ✎⁾⁾⁾__ 게임시작 ! Enter를 눌러주세요");
    }


}
