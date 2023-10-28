package movietiket;
import java.util.Scanner;

public class TicketAdmin {
    Scanner in = new Scanner(System.in);
    static Members[] members = new Members[10];
    String[] defaultSeet = new String[30];
    Members tmpUser = null;
    Functions fnc = new Functions();


    public void infodesk(Members loginUser) {
        tmpUser = loginUser;
        System.out.println(" [ " + tmpUser.memberName + " ] 고객님 반갑습니다. 정상 로그인 되었습니다.");
        boolean flag = true;
        while (flag) {
            info();
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1: // 티켓 예매
                    ticketBuy();
                    // 예매 정보를 회원 정보에 등록
                    break;
                case 2: // 예매 확인
                    ticketConfirm();
                    break;
                case 3: // 전체 좌석 보기
                    defaultSeetPrt();
                    break;
                case 4: // 좌석 수정
                    seetEdit();
                    break;
                case 5: // 티켓 취소
                    seetCancel();
                    break;
                case 6:
                    System.out.println("로그아웃 ➜ ➜ ➜ 감사합니다");
                    tmpUser = null;
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 번호 입니다. 다시 입력하세요");
            }
        }
    }

    // 티켓 취소
    private void seetCancel() {
        System.out.println(" 티켓 취소 메뉴 입니다 ");
        System.out.println(" [ " + tmpUser.memberName + " ] 님의 예약 정보입니다 ");
        tmpUser.memberInfoPrt();
        System.out.print("취소할 인원수를 입력하세요 : ");
        int cancelCnt = in.nextInt();
        in.nextLine();
        System.out.println("취소할 좌석 번호를 입력하세요");
        for (int i = 0; i < cancelCnt; i++) {
            System.out.print("\t ✐ 입력 (" + (i + 1) + "/" + cancelCnt + ") ➜ ");
            String seetInput = in.nextLine();
            int tmpInputNumber = fnc.normalizeInt(seetInput);
            for (int j = 0; j < 1; j++) {
                if (defaultSeet[tmpInputNumber] != null) {
                    defaultSeet[tmpInputNumber] = null;
                } else System.out.println("비워져 있는 좌석입니다.");
            }
            fnc.memberSeetAllClear(tmpUser, tmpInputNumber);
        }
        tmpUser.memberCheck = fnc.ticketCheck(tmpUser);
        System.out.println(tmpUser.memberName + "고객님의 요청하신 " + cancelCnt + "건 취소 완료 되었습니다.");
    }

    // 예매 수정
    private void seetEdit() {
        int editcnt = 0 ;
        int beforSeetNum = 0, afterSeetNum = 0;

        System.out.println("좌석 수정 메뉴 입니다");
        // 현재 예약자 정보 출력
        tmpUser.memberInfoPrt();
        System.out.print("\t ✐ " + tmpUser.memberName + "님 비밀번호 ➜ ");
        String pass = in.nextLine();
        if (tmpUser.memberPass.equals(pass)) {
            // 전체 시트 자리 null로 변경 및 유저 정보에 있는 예약 시트 넘버 초기화
            System.out.println("수정할 좌석 개수를 입력하세요");
            System.out.print("\t ✐ 숫자만 입력 ➜ ");
            editcnt = in.nextInt();
            in.nextLine();
            for (int i = 0; i < editcnt; i++) {
                System.out.println("기존 좌석 번호를 입력하세요");
                System.out.print("\t ✐ 입력 (" + (i + 1) + "/" + editcnt + ") ➜ ");
                String beforSeet = in.nextLine();
                System.out.println("이동 할 좌석 번호를 입력하세요");
                System.out.print("\t ✐ 입력 (" + (i + 1) + "/" + editcnt + ") ➜ ");
                String afterSeet = in.nextLine();
                beforSeetNum = fnc.normalizeInt(beforSeet);
                afterSeetNum = fnc.normalizeInt(afterSeet);
                if ( defaultSeet[afterSeetNum] != null ) {
                    System.out.println("예약할 수 없는 자리입니다 처음으로 돌아갑니다");
                    break;
                }
                fnc.changeSeet(tmpUser, beforSeetNum, afterSeetNum);
                if (defaultSeet[tmpInputNumber] == null) {
                    // 고객 정보 예약 시트번호 변수 배열에 예약번호 넣어주기
                    tmpUser.memberSeet[i] = tmpInputNumber;
                }
            }
//            fnc.clearMemberSeet(tmpUser, defaultSeet);
            // 기존 시트배열 번호에 정보 업데이트
            for (int i = 0; i < tmpUser.memberSeet.length; i++) {
                if (tmpUser.memberSeet[i] != 0) {
                    defaultSeet[tmpUser.memberSeet[i]] = fnc.maskingName(tmpUser.memberName);
                } else if (tmpUser.memberSeet[i] == 0) break;
            }
            if (tmpUser.memberCheck) {
                System.out.println("예약 완료");
                System.out.print(tmpUser.memberName + " 고객님의 예약 : ");
                // 예약된 자리 출력
                for (int i = 0; i < editcnt; i++) {
                    if (tmpUser.memberSeet[i] != 0) System.out.print(tmpUser.memberSeet[i] + "번 ");
                }
                System.out.println();
            }
        } else System.out.println("입력된 정보로는 찾을 수 없습니다.");
    }


    // 티켓 예매 확인
    private void ticketConfirm() {
        System.out.println("[ " + tmpUser.memberName + " ] 고객님의 예약된 정보입니다 ");
        if (tmpUser.memberCheck) {
            for (int i = 0; i < tmpUser.memberSeet.length; i++) {
                if (tmpUser.memberSeet[i] != 0)
                    System.out.println((i + 1) + "번째 예약 : 좌석 번호 [ " + tmpUser.memberSeet[i] + "번 ] ");
            }
        } else System.out.println("[ " + tmpUser.memberName + "] 고객님의 예약된 정보가 없습니다.");
    }

    // 티켓 예매
    private void ticketBuy() {
        System.out.println("티켓 예매입니다.");
        if (tmpUser.memberCheck) {
            System.out.println(tmpUser.memberName + "님의 예약된 정보가 있습니다.추가 불가합니다");
        } else {
            System.out.println("현재 좌석 내용 입니다.");
            defaultSeetPrt();
            System.out.println("예약 인원을 선택하세요");
            System.out.print("\t ✐ 입력 ➜ ");
            int person = in.nextInt();
            if (person < 5) {
                in.nextLine();
                System.out.println("예약할 좌석 번호를 입력하세요");
                for (int i = 0; i < person; i++) {
                    System.out.print("\t ✐ 입력 (" + (i + 1) + "/" + person + ") ➜ ");
                    String seetInput = in.nextLine();
                    int tmpInputNumber = fnc.normalizeInt(seetInput);
                    if (defaultSeet[tmpInputNumber] == null) {
                        // 고객 정보 예약 시트 변수 배열에 예약번호 넣어주기
                        tmpUser.memberSeet[i] = tmpInputNumber;
                        // 고객 정보 예약확인 부분에 체크 true로 바꿔주기
                        tmpUser.memberCheck = true;
                    }
                }
                // 기존 시트에 정보 업데이트
                for (int i = 0; i < tmpUser.memberSeet.length; i++) {
                    if (tmpUser.memberSeet[i] != 0) {
                        defaultSeet[tmpUser.memberSeet[i]] = fnc.maskingName(tmpUser.memberName);
                    } else if (tmpUser.memberSeet[i] == 0) break;
                }
                if (tmpUser.memberCheck) {
                    // 예약된 자리 출력
                    tmpUser.memberInfoPrt();
                } else System.out.println("이미 예약된 자리입니다. 예약 진행이 종료됩니다");
            }
        }
    }


    // 현재 좌석 상태 출력
    public void defaultSeetPrt() {
        System.out.println("현재 잔여 좌석입니다");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ [ S C R E E N ] ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        for (int i = 0; i < defaultSeet.length+1; i++) {
            if (i == 5 || i == 10 || i == 15 || i == 20 || i == 20) System.out.println();
            String tmp = String.format("%10s", i + 1);
            if (i + 1 < defaultSeet.length+1 && defaultSeet[i + 1] != null) {
                String strTmp = tmp + "번 " + defaultSeet[i + 1];
                System.out.print(String.format("%10s", strTmp));
            } else if (defaultSeet[i] == null) System.out.print(tmp + "번 가능");
        }
        System.out.println();
    }

    // 회원 가입
    public Members memberAdd() {
        int cnt = 0;
        while (cnt < 3) {
            System.out.println("회원가입");
            System.out.print("\t ✐ 이름 입력 ➜ ");
            String name = in.nextLine();
            System.out.print("\t ✐ 비밀번호 입력 ➜ ");
            String pass = in.nextLine();
            // 비밀번호 유효성 체크
            if (!fnc.passValidity(pass)) {
                System.out.println("입력한 패스워드는 사용할 수 없습니다 다시 시작합니다");
                break;
            }
            // 중복 체크
            Members serUser = new Members();
            if (findName(name) == null) {
                serUser.memberName = name;
                serUser.memberPass = pass;
                for (int i = 0; i < members.length; i++) {
                    if (members[i] == null) {
                        members[i] = serUser;
                        System.out.println("회원 가입이 완료 되었습니다");
                        break;
                    }
                }
                return serUser;
            } else {
                System.out.println("일치된 성함이 있습니다. 다시 입력하세요");
                cnt++;
                System.out.println("남은 입력 횟수 (" + cnt + "/3)");
            }
        }
        return null;
    }

    // 일치된 이름찾기
    public Members findName(String name) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) {
                if (members[i].memberName.equals(name)) {
                    return members[i];
                }
            }
        }
        return null;
    }

    private void info() {
        System.out.println("회원 전용 메뉴 입니다");
        System.out.println("1. 티켓 예매");
        System.out.println("2. 예매 확인");
        System.out.println("3. 전체 좌석 보기");
        System.out.println("4. 좌석 수정");
        System.out.println("5. 티켓 취소");
        System.out.println("6. 로그아웃 ➜ 초기화면 이동");
        System.out.print("\t ✐ 입력 ➜ ");
    }
}
