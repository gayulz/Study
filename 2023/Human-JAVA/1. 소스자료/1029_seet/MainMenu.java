import java.util.Scanner;
public class MainMenu {
	Scanner in = new Scanner(System.in);
	MemberMain memberMain = MemberMain.getInstance();
	SeatMain seatMain = new SeatMain();
	Member nowUser = null;
	//멤버 변수는 클래스 내 범위에서만 사용할 수 있다

	// 객체가 실행 되자마자 메뉴를 띄우겠다는 의도로 생성자를 사용
	MainMenu() {
		// TODO Auto-generated constructor stub
		// 메뉴선택하기..
		boolean f = true;
		while (f) {
			menu();
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				join();
			} else if (selMenu == 2) {
				login();
			} else if (selMenu == 3) {
				booking();
			}
		}
	}

	// 비회원서비스
	private void booking() {
		// TODO Auto-generated method stub
		seatMain.menu(null);
	}

	private void login() {
		// TODO Auto-generated method stub
		System.out.println("이름을 입력하세요");
		String name = in.nextLine();
		nowUser = memberMain.findUser(name);
		if(nowUser != null) {
			seatMain.menu(nowUser);
		}
	}

	private void join() {
		// TODO Auto-generated method stub
		memberMain.init();

	}
	public void menu() {
		System.out.println("1.  회원가입");
		System.out.println("2.  로그인");
		System.out.println("3.  비회원서비스");
	}




}
