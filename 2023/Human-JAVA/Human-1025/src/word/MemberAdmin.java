package word;

import java.util.Scanner;

//클래스 정의 : 회원관리(추가,검색,수정,삭제)
public class MemberAdmin {
	Scanner in = new Scanner(System.in);
	Member[] mlist = new Member[5];
	Fnc fncLink = new Fnc();
	Member m = null;

	MemberAdmin() {

	}
	public void init() {
		boolean f = true;
		while (f) {
			menu();
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				add();
			} else if (selMenu == 2) {
				viewList();
			} else if (selMenu == 3) {
				ser();
			} else if (selMenu == 4) {
				mod();
			} else if (selMenu == 5) {
				del();
			} else if (selMenu == 6) {
				f = false;
			}
		}
	}

	private void del() {
		//  이름으로 삭제하기
		System.out.println("삭제할 이름 입력 >>");
		String name= in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					mlist[i]=null;
					break;
				}
			}
		}

	}

	private void mod() {
		//  이름으로 삭제하기
		System.out.println("수정할 이름 입력 >>");
		String name= in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					System.out.println(" 수정 주소 입력");
					String newaddr = in.nextLine();
					mlist[i].addr=newaddr;
					break;
				}
			}
		}

	}

	public void ser() {
		System.out.println(" 검색할 이름을 입력하세요");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					mlist[i].prt();
					break;
				}
			}
		}

	}


	public Member findUser(String name) {
		//System.out.println(" 검색할 이름을 입력하세요");
		//String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					//mlist[i].prt();
					//break;
					return mlist[i];
				}
			}
		}
		return null;

	}
	public void menu() {
		System.out.println("1. 신규가입");
		System.out.println("2. 전체보기");
		System.out.println("3. 검색하기");
		System.out.println("4. 수정하기");
		System.out.println("5. 삭제하기");
		System.out.println("6. 종료하기");
	}

	public void add() {
		System.out.println(" 신규가입입니다 ..... ");
		Member m = null;
		m = new Member();
		System.out.println(" 이름 입력 하세요 <특수문자 1개 이상 필수>");
		String name = in.nextLine();
		m.name = name;
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] == null) {
				mlist[i] = m;
				// m=null;
				break;
			}
		}

	}

	public void viewList() {
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				mlist[i].prt();
			}
		}
	}

}
