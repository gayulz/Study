package word;

import java.util.Scanner;

public class WordPadMain {
	Scanner in = new Scanner(System.in);
	WordAdmin wordadmin = new WordAdmin();
	MemberAdmin memberadmin = new MemberAdmin();
	Member nowUser = null;
	public WordPadMain() {
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
			}
		}

	}

	private void login() {
		// TODO Auto-generated method stub
		// 로그인 과정은 공사중
		//new WordAdmin();
		System.out.println("이름입력하세요 >");
		String loginid =  in.nextLine();
		nowUser = memberadmin.findUser(loginid);
		if(nowUser == null) {
			System.out.println("회원이 아닙니다.");
		}else {
			wordadmin.init();
		}

	}

	private void join() {
		// TODO Auto-generated method stub
		//new MemberAdmin();
		memberadmin.init();
		//MemberAdmin m = new MemberAdmin();
		//m.init();

	}

	public void menu() {
		System.out.println("1.  회원가입");
		System.out.println("2.  로그인");
	}

}
