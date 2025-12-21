package movietiket;

public class Members {
    // 회원 이름
    String memberName = null;
    // 회원 비밀번호
    String memberPass = null;
    // 예약 여부
    boolean memberCheck = false;
    // 예약 좌석 번호 저장 배열
    int[] memberSeet = new int[5];

    // 정보 출력 메서드
    public void memberInfoPrt() {
        System.out.println("[   성함 ] : " + memberName);
        if (memberCheck) {
            for (int i = 0; i < memberSeet.length; i++) {
                if (0 != memberSeet[i]) {
                    System.out.println("[ 예약 좌석 ] : " + memberSeet[i]);
                }
            }
        } else System.out.println("[ 예약 좌석 ] : 없음 ");
    }
}
