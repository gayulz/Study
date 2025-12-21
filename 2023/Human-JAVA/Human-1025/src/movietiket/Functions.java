package movietiket;

public class Functions {


    // String 변수에 있는 내용 중 숫자만 추출하는 메서드
    public int normalizeInt(String inStr) {
        int number = Integer.parseInt(inStr.replaceAll("[^0-9]*$", ""));
        return number;
    }


    // 이름 마스킹 처리 메서드
    public String maskingName(String name) {
        StringBuilder nameRegex = new StringBuilder(name.substring(0, 1));
        for (int j = 0; j < name.length() - 1; j++) {
            nameRegex.append("*");
        }
        return nameRegex.toString();
    }


    // 좌석 수정 시 예전 좌석 번호와 변경할 좌석 번호와 유저주소값을 입력받아
    // 자리이동시켜주는 메서드
    public void changeSeet(Members user, int befor, int after){
        for (int i = 0; i < user.memberSeet.length; i++) {
            if (user.memberSeet[i]==befor) {
                user.memberSeet[i]=after;
                break;
            }
        }
    }

    // 좌석 예매 수정시 기본좌석 및 고객 구매 좌석 배열 초기화
    public void clearMemberSeet(Members user, String[] defaultSeet) {
        for (int i = 0; i < user.memberSeet.length; i++) {
            if (user.memberSeet[i] != 0) {
                defaultSeet[user.memberSeet[i]] = null;
            } else if (user.memberSeet[i] == 0) break;
        }
        user.memberSeet = new int[5];
    }

    // 입력한 수 만큼 고객이 예약한 좌석 초기화 하는 메서드
    public void memberSeetAllClear(Members user, int seetNum) {
        for (int j = 0; j < user.memberSeet.length; j++) {
            if (user.memberSeet[j] == seetNum) {
                user.memberSeet[j] = 0;
                break;
            }
        }
    }

    // 고객이 갖고있는 잔여좌석 여부에 따라서 체크값 리턴해주는 메서드
    public boolean ticketCheck(Members user) {
        for (int i = 0; i < user.memberSeet.length; i++) {
            if (user.memberSeet[i] != 0) {
                return true;
            }
        }
        return false;
    }


    // 비밀번호 규칙유효성 체크
    public boolean passValidity(String pass) {
        // 제약사항
        // 비밀번호는 영문과 숫자만 특수문자를 혀옹한다
        // 비밀번호 길이는 최소 5이상 , 숫자는 필수 1개이상, 3개이하 , 특수문자 필수 1개이상 3개이하
        boolean answer = false;
        int spePass = pass.replaceAll("\\w", "").length(); // 특수문자
        int numPass = pass.replaceAll("\\D", "").length(); // 숫자
        int engPass = pass.replaceAll("[^A-Za-z]", "").length(); // 영어
        answer = spePass > 1 && spePass < 4;
        answer = numPass > 1 && numPass < 4;
        answer = (spePass + numPass + engPass) > 4;

        return answer;
    }


}

