import java.util.Scanner;

public class SeatMain {
    Scanner in = new Scanner(System.in);
    // 시트에 대한 정보
    BookingInfo[][] booking = new BookingInfo[3][10];
    // 현재 접속된 유저의 정보를 알고싶기때문에 그대로 받기함
    Member nowUser = null;
    // 사용불가 자리
    int[][] badSeatInfo = {{0, 0, 0, 0, 1, 1},
            {0, 1, 8, 9, 0, 9}}; // 좌석이 아닌 곳 정보 좌표

    // 생성자 호출시 init을 바로 호출
    // SeetMain 클래스를 호출할때 init을 바로 호출하여 초기환경을 구성함
    SeatMain() {
        init();
    }

    // 앉을 수 없다는 내용
    private void init() {
        BookingInfo noSeat = new BookingInfo();
        noSeat.userName = "NOseat";
        for (int i = 0; i < badSeatInfo[0].length; i++) {
            booking[badSeatInfo[0][i]][badSeatInfo[1][i]] = noSeat;
        }
        noSeat = null;
    }

    public void prt() {
        System.out.print("행/열");
        for (int i = 0; i < booking[0].length; i++) {
            System.out.print((i) + " ");
        }
        System.out.println();
        for (int i = 0; i < booking.length; i++) {
            System.out.print("  " + i + " ");
            for (int j = 0; j < booking[0].length; j++) {
                if (booking[i][j] == null) {
                    System.out.print("□ ");
                } else if (booking[i][j].userName.equals("NOseat")) {
                    System.out.print("■ ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void menu(Member m) {
        nowUser = m;
        boolean f = true;
        while (f) {
            System.out.println("1. 예매");
            System.out.println("2. 예매확인");
            System.out.println("3. 나의 예매 확인");
            System.out.println("4. 예매정보수정");
            System.out.println("5. 예매정보삭제");
            System.out.println("6. 예약상황보기");
            System.out.println("7. 좌석변경");
            System.out.println("8. 종료");
            System.out.println(" 메뉴 선택 >> ");
            int selMenu = in.nextInt();
            in.nextLine();
            if (selMenu == 1) {
                if (loginCheck()) {
                    add();
                }
            } else if (selMenu == 2) {
                if (loginCheck()) {
                    ser();
                }
            } else if (selMenu == 4) {
                if (loginCheck()) {
                    mod();
                }
            } else if (selMenu == 5) {
                if (loginCheck()) {
                    del();
                }
            } else if (selMenu == 6) {
                bookingPrt();
            } else if (selMenu == 7) {
                if (loginCheck()) {
                    changeSeat();
                }
            } else if (selMenu == 8) {
                f = false;
            } else if (selMenu == 3) {
				if (loginCheck()) {
					mybooking();
				}
            }
        }
    }

	// 나의 예매 확인
	private void mybooking() {
		System.out.println(" [ " + nowUser.name + " ]님의 예약 내역입니다");
        for (int i = 0; i < nowUser.mybookingList.length; i++) {
            if (nowUser.mybookingList[i] != null) {
                System.out.println(nowUser.mybookingList[i].userName);
                System.out.println(nowUser.mybookingList[i].userPass);
            }
        }
//		int[] idx = nowUser.mybookingList;
//		if (idx == null) {
//			System.out.println("예약 내역이 없어요");
//		} else {
//			BookingInfo binfo = findUserBooking(idx[0], idx[1]);
//			System.out.println(
//					"예약정보 : 행 " + idx[0] + "/ 열 " + idx[1] + "(" + binfo.userName + "/" + binfo.userPass + ")");
//		}
	}

	private void changeSeat() {
        System.out.println("<좌석변경은 예약자 확인 후 이루어 집니다> \n 예약자 이름 입력");
        String userName = in.nextLine();
        int[] idx = searchUserName(userName);
        BookingInfo binfo = findUserBooking(idx[0], idx[1]);
        if (idx != null) {
            prt();
            System.out.println("좌석을 선택하세요.");
            System.out.println("행과 열을 차례대로 입력하세요. \n행입력");
            int row = in.nextInt();
            in.nextLine();
            System.out.println("열을 입력하세요");
            int col = in.nextInt();
            in.nextLine();
            if (findUserBooking(row, col) == null) {
                binfo.row = row;
                binfo.col = col;
                booking[row][col] = binfo;
                booking[idx[0]][idx[1]] = null;
                System.out.println("좌석변경이 완료 되었습니다");
            } else {
                System.out.println("이미 예약된 자리는 선택 할 수 없습니다.");
            }
        }
        binfo = null;
    }

    private void del() {
        // TODO Auto-generated method stub
        System.out.println("<예매삭제> 예약자 이름을 입력하세요");
        String userName = in.nextLine();
        int[] idx = searchUserName(userName);
        if (idx == null) {
            System.out.println("예약 내역이 없어요");
        } else {
            booking[idx[0]][idx[1]] = null;
        }
    }

    private void mod() {
        // TODO Auto-generated method stub
        System.out.println("<예매수정> 예약자 이름을 입력하세요");
        String userName = in.nextLine();
        int[] idx = searchUserName(userName);
        if (idx == null) {
            System.out.println("예약 내역이 없어요");
        } else {
            BookingInfo binfo = findUserBooking(idx[0], idx[1]);
            System.out.println("<비밀번호 수정하세요>");
            String pass = in.nextLine();
            binfo.userPass = pass;
        }
    }

    private void bookingPrt() {
        // TODO Auto-generated method stub
        prt();
        System.out.println();
        for (int i = 0; i < booking.length; i++) {
            // System.out.print(" " + i + " ");
            for (int j = 0; j < booking[0].length; j++) {
                if (booking[i][j] == null) {
                    System.out.println((i + "행 / " + j + "열 " + "[예약가능]"));
                } else if (booking[i][j] != null) {
                    if (booking[i][j].userName.equals("NOseat")) {
                    } else {
                        String maskingName = booking[i][j].userName.charAt(0) + "**";
                        System.out.print((i + "행 / " + j + "열 " + "[예약됨] " + maskingName + "님"));
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }

    }

    private boolean loginCheck() {
        if (nowUser == null) {
            System.out.println("회원 서비스 입니다 ");
            return false;
        }
        return true;
    }

    private void ser() {
        System.out.println("<예매확인> 예약자 이름을 입력하세요");
        String userName = in.nextLine();
        int[] idx = searchUserName(userName);
        if (idx == null) {
            System.out.println("예약 내역이 없어요");
        } else {
            BookingInfo binfo = findUserBooking(idx[0], idx[1]);
            System.out.println(
                    "예약정보 : 행 " + idx[0] + "/ 열 " + idx[1] + "(" + binfo.userName + "/" + binfo.userPass + ")");
        }

    }

    private BookingInfo findUserBooking(int row, int col) {
        if (booking[row][col] != null) {
            return booking[row][col];
        }
        return null;

    }

    private int[] searchUserName(String userName) {
        int[] idx = null;
        for (int i = 0; i < booking.length; i++) {
            for (int j = 0; j < booking[0].length; j++) {
                if (booking[i][j] != null) {
                    if (booking[i][j].userName.equals(userName)) {
                        idx = new int[2];
                        idx[0] = i;
                        idx[1] = j;
                        return idx;
                    }
                }
            }
        }
        return null;
    }

    private void add() {
        prt();
        System.out.println("행과 열을 차례대로 입력하세요. \n행입력");
        int row = in.nextInt();
        in.nextLine();
        System.out.println("열을 입력하세요");
        int col = in.nextInt();
        in.nextLine();

        if (findUserBooking(row, col) == null) {
            BookingInfo newBooking = new BookingInfo();
            System.out.println("예약자 명을 입력하세요");
            String userName = in.nextLine();
            int[] idx = searchUserName(userName);
            if (idx == null) {
                System.out.println("비밀번호를 입력하세요");
                newBooking.userPass = in.nextLine();
                newBooking.userName = userName;
                newBooking.row = row;
                newBooking.col = col;
                booking[row][col] = newBooking;
                nowUser.inputBooking(newBooking);
            } else {
                System.out.println(userName + "님은 이미 예약 정보가 있습니다");
            }

        } else {
            System.out.println("선택한 좌석은 없거나 이미 예약 됨");
        }

    }

}
