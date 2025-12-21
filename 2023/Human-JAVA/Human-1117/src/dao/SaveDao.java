package dao;

import dto.WordDTO;
import resource.Access;

public class SaveDao extends Access implements daoInterface {
    // todo : 버튼을 눌렀을때 입력한 문자를 Oracle DB에 저장하기
    private SaveDao(){}
    private static SaveDao self = null;
    public static SaveDao getInstance(){
        if (self == null) self = new SaveDao();
        return self;
    }

    @Override
    public WordDTO daoTransper(WordDTO tmp) {
        boolean trueConn = isConnect();
        if (trueConn){
            try{
                sql = "INSERT INTO Word VALUES(?,?)";
                psmt = connect.prepareStatement(sql);
                psmt.setString(1, tmp.getEngWord());
                psmt.setString(2, tmp.getKorWord());
                psmt.executeQuery();
                return tmp;
            } catch (Exception e){
            } finally {
                resourcesClose();
            }
        }
        return null;
    }
}
