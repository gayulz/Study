package members;

public class MemberFunctions {
    // 제약사항
    // 비밀번호는 영문과 숫자만 특수문자를 혀옹한다 (^%$#! 문자 비포함)
    // 비밀번호 길이는 최소 5이상 , 숫자는 필수 1개이상, 3개이하 , 특수문자 필수 1개이상 3개이하
    public boolean passValidity(String pass) {
        boolean answer = false;
        int spePass = pass.replaceAll("\\w", "").length(); // 특수문자
        int numPass = pass.replaceAll("\\D", "").length(); // 숫자
        int engPass = pass.replaceAll("[^A-Za-z]", "").length(); // 영어
        answer = spePass > 1 && spePass < 4;
        answer = numPass > 1 && numPass < 4;
        answer = (spePass + numPass + engPass) > 4;
        return answer;
    }

    // 이름이 동일한 정보를 찾아 리턴해주는 메서드
    public MemberDefine memberWho(String name){
        for (int i = 0; i < MemberList.getInstance().listArray.length; i++) {
            MemberDefine tmp = MemberList.getInstance().listArray[i];
            if ( tmp.memberName.equals(name) ) return tmp;
        }
        return null;
    }
}
