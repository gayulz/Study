package member;

public class Functions {
    // 비밀번호 유효성 검사
    public boolean isPass(String pass){
        // 비밀번호는 5자리 이상 특수문자 "!@#$%^&*"  1개 이상 포함되어야한다
        String spe = "!@#$%^&*";
        int cnt = 0;
        for (int i = 0; i < pass.length(); i++) {
            for (int j = 0; j < spe.length(); j++) {
                if ( pass.charAt(i) == spe.charAt(j)) cnt++;
            }
        }
        if ( cnt >= 1 && pass.length() > 4) return true;
        return false;
    }

    // id 유효성검사
    // id 생성시 규칙은 5자리이상, 한글 불가 영어 대소문자 포함 가능 , 특수문자 1개 이상
    public boolean isId(String id) {
        String tmpId = id.toUpperCase();
        String spe = "!@#$%^&*";
        int cnt = 0;
        for (int i = 0; i < tmpId.length(); i++) {
            if ( tmpId.charAt(i) >= 65 || tmpId.charAt(i) <= 90 ) {
                for (int j = 0; j < spe.length(); j++) {
                    if ( id.charAt(i) == spe.charAt(j)) cnt++;
                }
            }
        }
        if ( cnt >= 1 && id.length() > 4) return true;
        return false;
    }
}
