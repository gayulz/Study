import java.util.Scanner;

public class MemberMain {

	Scanner in = new Scanner(System.in);

	Member[] mlist = new Member[5];
	// Public은 누구나 접근 가능하다
	// static 공용 변수로써 객체를 만들지 않더라도 적용 가능하다
	// 접근 제어자는 public , defalut , private가 있다
	public static MemberMain membermainInstance = null;
	Member m = null;
	// 멤버메인의 의미는 객체가 1개만 있어야 한다.
	// 객체를 만든 곳은 멤버변수이다.
	// 멤버 변수의 특징 , 클래스가 객체가 만들어질때 할당되는 범위
	// 사용할 수 있는 클래스 내부의 객체이다

	private MemberMain() {
		// 접근 제어자를 private로 선언하면 같은 클래스 내에서만 접근이 가능하다.
		// 싱글톤은 내가 아닌 다른 클레스에서 객체를 만들 수 없다
		// 객체를 만드려면 내가 만들면 된다
	}

	public static MemberMain getInstance(){
		if ( membermainInstance == null ) membermainInstance = new MemberMain();
		return membermainInstance;
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
		System.out.println("삭제할 이름 입력 >>");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					mlist[i] = null;
					break;
				}
			}
		}

	}

	private void mod() {
		System.out.println("수정할 이름 입력 >>");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					System.out.println(" 수정 주소 입력");
					String newaddr = in.nextLine();
					mlist[i].addr = newaddr;
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
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
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
		Member m = null;  // Member Class의 자료형으로 이용하고 m이라는 변수를 일단 빈값으로 선언 (공간생성)
		m = new Member();  // Member Class를 자료형으로 이용하여 새로운 객체를 이때 생성(Heap 주소값이 이때 생기고 m에 대입됨)
		System.out.println(" 이름 입력 하세요 <특수문자 1개 이상 필수>");
		String name = in.nextLine();
		m.name = name;
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] == null) {
				mlist[i] = m;
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
