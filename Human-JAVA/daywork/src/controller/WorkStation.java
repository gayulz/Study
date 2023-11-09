package controller;

import daywork.Functions;

public class WorkStation {
    // 일정 관리 프로그램
    Functions fn = new Functions();
    public WorkStation()  {
        boolean flag = true;
        while (flag) {
            info();
            int user = Integer.parseInt(fn.retrunText("번호"));
            switch (user) {
                case 1: // 일정 추가
                    new WorkAdd();
                    break;
                case 2:  // 일정 수정
                    new WorkMod();
                    break;
                case 3: // 일정 삭제
                    new WorkDel();
                    break;
                case 4:  // 일정 전체보기
                    new WorkReview();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다");
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 번호입니다 ");
            }
        }
    }
    private void info(){
        System.out.println("일정 관리프로그램 입니다.");
        System.out.println("1. 일정 추가");
        System.out.println("2. 수정 추가");
        System.out.println("3. 일정 삭제");
        System.out.println("4. 등록된 일정 전체보기");
        System.out.println("5. 프로그램 종료");
    }
}
