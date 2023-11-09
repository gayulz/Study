package controller;

import daywork.Functions;
import daywork.workDefine;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkMod {
    private Functions fn = new Functions();
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private workDefine w = null;

    // 일정 수정 메서드
    WorkMod(){
        w = new workDefine();
        String sql = null;
        System.out.println("수정하실 항목을 적어주세요");
        System.out.println("1. 일정 날짜");
        System.out.println("2. 일정 내용");
        System.out.println("3. 작성자");
        int num = Integer.parseInt(fn.retrunText("번호"));
        switch (num){
            case 1:
                break;
            case 2 :
                break;
            case 3 :
                break;
            default:
                System.out.println("잘못된 입력압니다.");
        }
    }

}
