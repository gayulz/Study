package word;

import java.util.Scanner;

public class WordAdmin {
	Scanner in = new Scanner(System.in);
	Word[] wlist = new Word[5]; // 모든 일정을 하나의 변수로 관리

	WordAdmin() {

	}

	public void init() {
		// 메뉴선택하기..
		boolean f = true;
		while (f) {
			menu();
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				add();
			} else if (selMenu == 2) {
				allList();
			} else if (selMenu == 3) {
				mod();
			} else if (selMenu == 4) {
				del();
			} else if (selMenu == 5) {
				search();
			} else if (selMenu == 9) {
				f = false;
			}
		}
	}

	private void search() {
		// 제목을 입력받는다.. 이 제목과 일치하는 객체를 찾으면 된다.
		String sTitle = in.nextLine();
		// 검색 할 제목을 지정했고. 이 제목과 일치하는 객체를 배열을 순회하면서 찾는다
		for (int i = 0; i < wlist.length; i++) {
			if (wlist[i] != null) {
				if (wlist[i].title.equals(sTitle)) {
					wlist[i].prt();
					// 같은 제목이 여러개 있을 수 있다고 가정해서 break는 안함.
					System.out.println(" 관심 일정으로 구분하려면 y or no");
					char f = in.nextLine().charAt(0);
					if (f == 'y') {
						wlist[i].myChkFlag = true;
					}
				}
			}
		}

	}

	public void menu() {
		System.out.println("1. 일정등록");
		System.out.println("2. 전체보기");
		System.out.println("3. 수정하기");
		System.out.println("4. 삭제하기");
		System.out.println("5. 검색하기");
		System.out.println("9. 종료하기");
	}

	// 특수문자 체크하는 메서드 정의
	// 매개변수로 체크한 문자열을 받으면 .. 그 결과를 알려 준다.
	// 매개변수는 문자열로 받고, 리턴값이 있어야 한다..
	// 리턴값을 어떻게 할 것인가? 있다?없다 할수도 있고
	// 몇개가 있는지 숫자를 넘길수도 있다. < 채택
	public int chk(String txt) {
		int cnt = 0;
		String sign = "!@#$%^&*";
		for (int i = 0; i < txt.length(); i++) {
			for (int j = 0; j < sign.length(); j++) {
				if (txt.charAt(i) == sign.charAt(j)) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public void add() {
		Word newWord = new Word();// 새일정을 만든다 즉, word라는 객체를 새로 만든다
		// 새로 만든 일정에 일정을 기록하는 부분의 시작
		System.out.println("새로운 일정의 제목을 입력하세요");
		String title = in.nextLine();
		if (chk(title) == 0) {
			newWord.title = title;
			System.out.println("새로운 일정의 내용을 입력하세요");
			newWord.memo = in.nextLine();
			System.out.println("새로운 일정의 중요도를 높음(3) -> 낮음(1)으로 입력하세요");
			newWord.flag = in.nextInt();
			in.nextLine();
			// <-- 새로 만든 일정에 일정을 기록하는 끝 부분
			// 새로운 일정을 만들었다. 이제는 일정을 관리하는 배열에 저장시키자. 빈곳을 찾아서
			for (int i = 0; i < wlist.length; i++) {
				if (wlist[i] == null) {
					wlist[i] = newWord; // 주소를 복사..왜냐하면 참조변수이때문에
					break;
				}
			}
			dataSort(); // 일정을 입력하면 배열을 재정렬하겠다.
		} else {
			System.out.println("제목에 특수문자 있으면 안되요. 처음부터 다시 하세요.");
		}

	}

	private void dataSort() {
		// TODO Auto-generated method stub

	}

	public void del() {
		// 제목을 입력받는다.. 이 제목과 일치하는 것을 삭제할 것이다.
		String delTitle = in.nextLine();
		// 삭제할 제목을 지정했고. 이 제목과 일치하는 객체를 배열을 순회하면서 찾는다
		for (int i = 0; i < wlist.length; i++) {
			if (wlist[i] != null) {
				if (wlist[i].title.equals(delTitle)) {
					System.out.println("정말 삭제? y입력");
					String chk = in.nextLine();
					if (chk.equals("y")) {
						wlist[i] = null;
					} else {
						System.out.println("취소하였습니다.");
					}
					// 같은 제목이 여러개 있을 수 있다고 가정해서 break는 안함.
				}
			}
		}
	}

	public void mod() {
		// 제목으로 검색 후 제목과 일치하는 객체를 찾아서 멤버변수를 수정
		String delTitle = in.nextLine();
		// 수정할 제목을 지정했고. 이 제목과 일치하는 객체를 배열을 순회하면서 찾는다
		for (int i = 0; i < wlist.length; i++) {
			if (wlist[i] != null) {
				if (wlist[i].title.equals(delTitle)) {
					// 조건이 참이면 수정할 객체를 찾은 것이죠.. 그 객체는 wlist[i]
					System.out.println("내용을 수정하세요");
					String newMemo = in.nextLine();
					wlist[i].memo = newMemo;
					System.out.println("중요도를 입력하세요");
					int newFlag = in.nextInt();
					in.nextLine();
					wlist[i].flag = newFlag;
				}
			}
		}
	}

	public void allList() {
		// 1. 배열을 순회한다.
		// 2. 배열의 값에 저장된 것은 word객체의 주소이므로 이 주소를 참조한다.
		// 주의 할 점의 배열의 값에 null있다는 것은 주소가 없다.. if(wlist[i] != null)
		// 3. 객체의 자원중에.. prt()라는 메서드를 호출하면 그 객체의 정보를 출력한다.
		for (int i = 0; i < wlist.length; i++) {
			if (wlist[i] != null) {
				wlist[i].prt();
			}
		}

	}

}
