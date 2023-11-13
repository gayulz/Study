package DAO;

import static DAO.AccessDAO.*;

public class ReviewDAO_1 extends ReviewDAO {
    public static void reviewDel(int delReviewNum){
        boolean trueConn = getConnection();
        if (trueConn) {
            try {
                String sql = "delete from review where rnum=?";
                psmt = conn.prepareStatement(sql);
                psmt.setInt(1,delReviewNum);
                int resultInt = psmt.executeUpdate();
                System.out.println(resultInt + "건 삭제 성공");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
