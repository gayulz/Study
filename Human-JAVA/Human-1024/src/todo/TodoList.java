package todo;

import javax.swing.*;
import java.util.Scanner;

public class TodoList {
    Fnc fn = new Fnc();
    Scanner in = new Scanner(System.in);
    // 저장할 to do list를 저장할 배열 선언
    Work[] workList = new Work[30];
    // 관리자 ID
    String managerId = "ADMIN";
    // 관리자 패스워드
    String managerPass = "!!12345!!";

    TodoList() {
        // 로그인 확인
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("관리자 ID를 입력하세요 ➜ ");
            String adminId = in.nextLine();
            System.out.print("비밀번호를 입력하세요 ➜ ");
            String adminPw = in.nextLine();
            if (managerId.equals(adminId) && managerPass.equals(adminPw)) {
                System.out.println(" ✔ 관리자님 로그인 완료");
                break;
            } else {
                cnt++;
                System.out.println("✘ 일치되지 않습니다 ✘ (" + cnt + "/3)");
            }
        }
        // 오답횟수가 3번 미만인 경우 프로그램 접속 시작
        if (cnt < 3) {
            boolean flag = true;
            while (flag) {
                // 프로그램 시작 후 첫 메뉴
                info();
                System.out.print("\t ✐ 입력 ➜ ");
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1:
                        // 일정 추가
                        addWork();
                        break;
                    case 2:
                        // 일정 수정
                        editWork();
                        break;
                    case 3:
                        // 일정 삭제
                        delWork();
                        break;
                    case 4:
                        // 일정 전체 보기
                        totalList();
                        break;
                    case 5:
                        // 종료
                        flag = false;
                        System.out.println(" ◡̈⋆* 프로그램을 종료합니다. ");
                        break;
                }
            }

        } else {
            // 로그인 횟수 오류 3번 이상부턴 프로그램 종료
            System.out.println("✘ 로그인 횟수 초과 / 프로그램 종료합니다 ✘");
        }
    }
    private void totalList() {
        // 일정 전체보기
        System.out.println("\t✔ 중요도가 높은 순서대로 보여집니다 ");
        // 전체 일정 출력
        for (int i = 0; i < workList.length; i++) {
            if (workList[i] != null){
                workList[i].todoPrt();
            }
        }
    }

    private void delWork() {
        // 일정 삭제 메서드
        System.out.println("삭제 할 날짜를 입력하세요(예시 : 20201111) 입력 ➜ ");
        System.out.print("\t ✐ 입력 ➜ ");
        String day = in.nextLine();
        for (int i = 0; i < workList.length; i++) {
            if (workList[i] != null) if (workList[i].day.equals(day)) {
                workList[i] = null;
                System.out.println("[ " + day.substring(0, 4) + "년 " + day.substring(4, 6) + "월 " + day.substring(6) + "일 ] ✔ 삭제 완료 ");
                break;
            } else
                System.out.println("[ " + day.substring(0, 4) + "년 " + day.substring(4, 6) + "월 " + day.substring(6) + "일 ] ✘ 찾을 수 없습니다 ✘ ");
        }
    }

    private void editWork() {
        // 일정 수정 메서드
        System.out.print("수정 하려는 날짜를 입력하세요( 예 : 20230101 ) 입력 ➜ ");
        String dayTmp = in.nextLine();
        System.out.println("① 날짜 변경 ② 내용 변경 ③ 중요도 변경 ");
        System.out.print("\t ✐ 입력 ➜ ");
        int choice = in.nextInt();
        in.nextLine();

        // 찾은 일정의 주소를 tmp 객체에 넣어준다
        Work tmp = loopData(dayTmp);
        switch (choice) {
            case 1:
                // 사용자 입력이 1번인 경우
                System.out.print("\t ✐ 수정할 날짜 입력 (예 : 20231223 ) ➜ ");
                String tmpStr = in.nextLine();
                if (fn.dayInspect(tmpStr)) {
                    tmp.day = tmpStr;
                    System.out.println(" ✔ 수정 완료 ");
                } else System.out.println("✘ 불가능한 날짜 입니다 ✘");
                break;
            case 2:
                // 사용자 입력이 2번인 경우
                System.out.print("\t ✐ 수정할 내용 입력 ( 한글/영어만 가능 ) ➜ ");
                String strtmp = in.nextLine();
                if (fn.textInspect(strtmp)) {
                    tmp.text = strtmp;
                    System.out.println(" ✔ 수정 완료 ");
                } else System.out.println("✘ 불가한 내용이 포함되어 있습니다 ✘");
                break;
            case 3:
                // 사용자 입력이 3번인 경우
                System.out.print(" ✐ 수정할 중요도 입력 ( 숫자 1,2,3 만가능 ) ➜ ");
                int iptTmp = in.nextInt();
                in.nextLine();
                if (fn.iptWorkInspect(iptTmp)) {
                    tmp.iptWork = iptTmp;
                    System.out.println(" ✔ 수정 완료 ");
                } else System.out.println("✘ 선택 불가능한 숫자입니다 ✘");
                break;
            default:
                System.out.println("✘ 처리되지 않았습니다 ✘");
        }
        tmp = null;
    }

    private void addWork() {
        // 사용자 일정 등록하는 메서드
        Work dayTmp = new Work();
        System.out.println("날짜 입력은 년월일 숫자 총 8자리로 입력해주세요 , 예 ) 2023/10/10  -> 입력 : 20231010 ");
        System.out.print("\t ✐ 입력 ➜ ");
        dayTmp.day = in.nextLine();
        System.out.println("일정 내용을 입력 해 주세요. 일정 내용은 특수 문자 없이 영어 및 한글만 작성 가능합니다 ");
        System.out.print("\t ✐ 입력 ➜ ");
        dayTmp.text = in.nextLine();
        System.out.println("일정의 중요도를 입력 해 주세요. 1 : 별1개 , 2 : 별2개 , 3 : 별3개 , 숫자만 입력되며 1~3까지 입력해주세요");
        System.out.print("\t ✐ 입력 ➜ ");
        dayTmp.iptWork = in.nextInt();
        in.nextLine();
        // 정상적인 규칙 확인, 정상일 경우 등록되며 아닐경우 규칙 오류로 등록되지 않는다
        // 날짜 규칙
        // 1000년 초과, 12월 이하, 31일 이하로 입력해야만 정상 등록됩니다.
        // 내용 규칙
        // 특수문자가 포함되지않는 영어와 한글만 가능
        // 중요도 규칙
        // 1 , 2 , 3 만 가능하다
        if (fn.dayInspect(dayTmp.day) && fn.textInspect(dayTmp.text) && fn.iptWorkInspect(dayTmp.iptWork)) {
            for (int i = 0; i < workList.length; i++) {
                if (workList[i] == null) {
                    workList[i] = dayTmp;
                    System.out.println("[ " + workList[i].day + " ] ✔ 등록 완료 ");
                    dayTmp = null;
                    break;
                }
            }
            listSort();
        } else {
            System.out.println("✘✘ 규칙 오류 / 등록되지 않습니다 ✘✘");
            dayTmp = null;
        }
    }

    public void listSort() {
        // 중요도가 높은 순 으로 바꿔주기
        for (int i = 0; i < workList.length; i++) {
            if (workList[i] != null) {
                for (int j = 0; j < workList.length; j++) {
                    Work tmp = new Work();
                    if (workList[j] != null){
                        if (workList[i].iptWork > workList[j].iptWork){
                            tmp = workList[j];
                            workList[j] = workList[i];
                            workList[i] = tmp;
                        }
                    }
                }
            }
        }
    }

    // 원하는 특정 날짜의 객체 주소를 찾아서 반환해주는 메서드
    public Work loopData(String day) {
        Work dayTmp = new Work();
        for (int i = 0; i < workList.length; i++) {
            if (workList[i] != null) {
                if (workList[i].day.equals(day)) {
                    dayTmp = workList[i];
                    break;
                }
            }
        }
        return dayTmp;
    }
    // 인포메뉴
    private void info() {
        System.out.println("|××××××××××|××××××××××|××××××××××|××××××××××|××××××××××|");
        System.out.println("\t\t▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄\n" +
                "\t\t█░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀██████░\n" +
                "\t\t░░░░░░░░░░░▀█▄█▄███▀░░░ ▀██▄█▄███▀░\n");
        System.out.println("\t\t✎⁾⁾⁾ ︎ToDo List 메모장 입니다 ");

        System.out.println("\t❶ 일정 등록\n\t❷ 일정 수정\n\t❸ 일정 삭제\n\t❹ 전체 보기\n\t❺ 종료");
        System.out.println("|××××××××××|××××××××××|××××××××××|××××××××××|××××××××××|");
    }


}
