package dao;

import resource.Access;
import dto.WordDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FindDao extends Access implements daoInterface {
    // todo : 클릭한 글자를 가지고 Oracle DB에서 가져오기
    private FindDao() {}

    // 싱글톤
    private static FindDao self;
    public static synchronized FindDao getInstance() {
        if (self == null) self = new FindDao();
        return self;
    }

    public static List<String> getAllWordsDB(){
        List<String> words = new ArrayList<>();
        if (isConnect()) {
            try {
                sql = "SELECT * FROM Word";
                PreparedStatement pstmt = connect.prepareStatement(sql);
                ResultSet resultSet = pstmt.executeQuery();
                while (resultSet.next()) {
                    words.add(resultSet.getString("engWord"));
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                resourcesClose();
            }
        }
        return words;
    }

    @Override
    public WordDTO daoTransper(WordDTO tmp) {
        if (isConnect()) {
            try {
                sql = "SELECT * FROM Word WHERE engWord = ?";
                PreparedStatement pstmt = connect.prepareStatement(sql);
                pstmt.setString(1, tmp.getEngWord());
                ResultSet resultSet = pstmt.executeQuery();
                if (resultSet.isBeforeFirst()) {
                    resultSet.next();
                    WordDTO nowDto = WordDTO.getInstance();
                    nowDto.setEngWord(resultSet.getString("engWord"));
                    nowDto.setKorWord(resultSet.getString("korWord"));
                    return nowDto;
                }
            } catch (Exception e) {
                e.printStackTrace(); // Print the full stack trace for debugging
            } finally {
                resourcesClose();
            }
        }
        return null;
    }
}
