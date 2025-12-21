package members;

// 회원을 정의하는 클래스
public class MemberDefine {
    public String memberName = null;
    public String memberPass = null;
    public boolean memberTicketCheck = false;
    public int[] memberBuySeet = new int[5];
    
    public void membersInfoPrt(){
        System.out.println("[   성함 ] : " + memberName);
        if (memberTicketCheck) {
            for (int i = 0; i < memberBuySeet.length; i++) {
                if (0 != memberBuySeet[i]) {
                    System.out.println("[ 예약 좌석 ] : " + memberBuySeet[i]);
                }
            }
        } else System.out.println("[ 예약 좌석 ] : 없음 ");
    }
}
