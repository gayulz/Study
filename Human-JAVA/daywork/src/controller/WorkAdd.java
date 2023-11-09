package controller;

import daywork.Functions;
import daywork.workDefine;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class WorkAdd {
    private Functions fn = new Functions();
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private workDefine w = null;
    // 일정 추가 클래스
    WorkAdd() {
        w = new workDefine();
        w.setItDate(fn.retrunText("일정 추가 (예시 : 20231011) "));
        w.setWorkText(fn.retrunText("일정 내용"));
        w.setUserName(fn.retrunText("등록자"));
        if (CRUD.getConn()) {
            try {
                String sql = "INSERT into DAYLIST values(?,?,?)";
                psmt = conn.prepareStatement(sql);
                // 매핑하기
                psmt.setString(1, w.getItDate());
                psmt.setString(2, w.getWorkText());
                psmt.setString(3, w.getUserName());
                // 쿼리 전송 하고 리턴 값 받기
                int resultInt = psmt.executeUpdate(); // 쿼리를 실제로 전송해주는 메서드
                // 리턴값 처리하기
                System.out.println(resultInt + " 건 성공 ");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (Exception e2) {
                System.out.println("insert 오류");
                e2.printStackTrace();
            } finally {
                // 자원 반납하기
                try {
                    if (psmt != null) psmt.close();
                    if (conn != null) conn.close();
                } catch (Exception e3) {}
            }
        } else {
            System.out.println("커넥션 정보 없음");
        }
    }
}