package QandA;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.QaDAO;
import DTO.QaDTO;

public class QandA_Admin {
	// 이 클래스에 add, mod, del, list, search에서는
	// 모두 데이터 베이스 작업을 할 것이다... 즉 QaDAO객체의 주소를 모두 참조할 것이다.
	// 그래서 필요할 때마다 QaDAO를 만들지 말고.. 하나를 만들어서 사용하겠다.
	// 그래서 가장 적당한 멤버변수 위치에 선언한다.
	//private QaDAO qadao = new QaDAO(); // 아직 싱글톤은 아닙니다.
	private QaDAO qadao = QaDAO.getInstance();
	private Scanner in = new Scanner(System.in);

	public QandA_Admin() {
		// 메뉴선택 코딩
		boolean flag = true;
		while (flag) {
			System.out.println("1.add 2.mod 3. del 4. list 5. search");
			int num = in.nextInt();
			in.nextLine();

			if (num == 1) {
				add();
			} else if (num == 2) {
				mod();
			} else if (num == 3) {
				del();
			} else if (num == 4) {
				list();
			} else if (num == 5) {
				search();
			}
		}
	}

	private void add() {
		// 새로운 문의글을 만든다..(QaDTO 객체를 생성한다.튜플 한개를 의미한다.)
		QaDTO newQa = new QaDTO();
		// 문의글을 작성한다 (위에서 생성한 객체에 멤버변수의 값을 저장한다)
		System.out.println("작성자입력");
		String wruser = in.nextLine();
		// 작성자가 2건 이상인지 체크...
		int cnt = qadao.chkWrCnt(wruser);
		if(cnt < 2) {
			System.out.println(wruser+"님 현재 "+cnt+ "건 작성하셨습니다.");
			newQa.setWr(wruser);
			System.out.println("제목입력");
			newQa.setTitle(in.nextLine());
			System.out.println("내용입력");
			newQa.setMemo(in.nextLine());
			System.out.println("비밀번호입력 4글자");
			newQa.setPass(in.nextLine());
			System.out.println("비밀글 여부 1번은 공개글 , 2번은 비밀글");
			newQa.setScret(in.nextInt());
			in.nextLine();
			// 작성된 글을DB에 저장 (위에서 생성한 객체의 주소를 qaDAO메서드를 호출한다)
			qadao.insert(newQa);
		}else {
			System.out.println("한 사람이 3건 이상은 올릴 수 없습니다. ");
		}
		
	}

	private void search() {
		// 검색이란 ? 검색어가 있으면 결과값이 있다.
		// 기술적으로 검색어 문자열이 있으면 데이터베이스에서 조회해서
		// 한개 이상의튜플을 리턴한다.. 우리는 이렇게 분석을 해야 한다..
		System.out.println("검색어 입력 <제목검색>");
		String mtitle = in.nextLine();
		ArrayList<QaDTO> slist = qadao.selectSearch(mtitle);
		if (slist.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("총 " + slist.size() + " 건이 검색되었습니다.");
			for (QaDTO a : slist) {
				a.prt();
			}
		}

	}

	private void list() {
		// TODO Auto-generated method stub
		// 테이블로 부터 튜플을 보두 가져와야 한다. 튜플은 한개 이상일 수 있다.
		ArrayList<QaDTO> l = qadao.selectAll();
		if (l.size() != 0) {
			for (QaDTO a : l) {
				a.prt();
			}
		}

	}

	private void del() {
		System.out.println("삭제할 제목 입력");
		String mtitle = in.nextLine();
		QaDTO retunrdto = qadao.selectOne(mtitle);
		System.out.println("비밀번호를 입력하세요");
		String newPass = in.nextLine();
		if(newPass.equals(retunrdto.getPass())) {
			// db작업
			qadao.delete(mtitle);
		}else {
			System.out.println("비번틀림");
		}	

	}

	private void mod() {
		// 절차 정의... 제목으로 수정한다. 내용만 수정이 가능하다..
		// 이전 작성글의 내용을 봐야 한다.. DB select * from qanda where title=검색어
		System.out.println("수정할 제목 입력");
		String mtitle = in.nextLine();
		QaDTO retunrdto = qadao.selectOne(mtitle); // 매개변수 넘기고 해당 글을 리턴받아야 한다.
		if (retunrdto != null) {
			retunrdto.prt();
		}
		System.out.println("비밀번호를 입력하세요");
		String newPass = in.nextLine();
		if(newPass.equals(retunrdto.getPass())) {
			System.out.println("내용을 수정하세요");
			mtitle = in.nextLine();
			retunrdto.setMemo(mtitle);
			// db update
			qadao.update(retunrdto);
		}else {
			System.out.println("비밀번호 틀림");
		}

	}

}
