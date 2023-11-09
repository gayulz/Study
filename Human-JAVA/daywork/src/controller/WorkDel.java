package controller;

import daywork.Functions;
import daywork.workDefine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkDel {
    private Functions fn = new Functions();
    private Connection conn = null;
    private PreparedStatement psmt = null;
    private workDefine w = null;

    // 일정 삭제 메서드
    WorkDel() {
        w = new workDefine();
        String sql = null;
        System.out.println("삭제하실 메뉴를 선택하세요");
        System.out.println("작성자 조회 / 날짜 조회");
        String choic = fn.retrunText("");
        if (CRUD.getConn()) {
            try {
                if (choic.contains("작성자")) {
                    w.setUserName(fn.retrunText("작성자 이름"));
                    sql = "DELETE FROM daylist WHERE username=?";
                    psmt.setString(1, w.getUserName());
                } else {
                    w.setItDate(fn.retrunText("삭제 날짜"));
                    sql = "DELETE FROM daylist WHERE itDate=?";
                    psmt.setString(1, w.getItDate());
                }
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 수 삭제 완료");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                // 자원 바납
                try {
                    if (psmt != null) psmt.close();
                    if (conn != null) conn.close();
                } catch (Exception e2) {
                }
            }
        } else System.out.println("커넥션 정보 없음");
    }
}

