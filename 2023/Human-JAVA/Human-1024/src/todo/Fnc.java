package todo;


public class Fnc {

    // 유효성 검사 : 입력된 숫자가 정상적인 날짜인지 검사
    // 1000년 초과, 12월 이하, 31일 이하로 입력해야만 정상 등록됩니다.
    public boolean dayInspect(String tmp) {
        boolean answer = false;
        int yyyy = 0;
        int mm = 0;
        int dd = 0;
        if (tmp.matches("^[0-9]*$")) {
            if (tmp.length() == 8) {
                yyyy = Integer.parseInt(tmp.substring(0, 5));
                mm = Integer.parseInt(tmp.substring(4, 6));
                dd = Integer.parseInt(tmp.substring(6));
            }
        }
        if (yyyy > 1000 && mm <= 12 && dd <= 31) answer = true;
        return answer;
    }

    // 유효성 검사 : 일정 내용 중 한글, 영어 외 입력 된 부분이 있는지 확인
    public boolean textInspect(String tmp) {
        boolean answer = false;
        if (tmp.matches("^[a-zA-Z가-힣]*$")) {
            answer = true;
        }
        return answer;
    }

    // 유효성 검사 : 중요도 1.2.3 범위인지 아닌지확인
    public boolean iptWorkInspect(int tmp) {
        boolean answer = false;
        if (tmp > 0 && tmp < 4) {
            answer = true;
        }
        return answer;
    }
}
