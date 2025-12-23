package WordADM;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.DaydayDAO;
import DTO.DaydayDTO;

public class WordM {
	private Scanner in = new Scanner(System.in);
	private DaydayDAO daydao = new DaydayDAO();
	
	public WordM() {
		boolean flag=true;
		while(flag) {
			System.out.println("1.add 2.mod 3.del 4.list");
			int selNum = in.nextInt();
			in.nextLine();
			if(selNum == 1) {
				add();
			}else if(selNum == 2) {
				mod();
			}else if(selNum == 3) {
				del();
			}else if(selNum == 4) {
				list();
			}
			
		}	
		
	}

	private void list() {
		// TODO Auto-generated method stub
		ArrayList<DaydayDTO> allList=  daydao.selectAll();  //select * from dayday
		if(allList.size() != 0) {
			for(DaydayDTO d : allList) {
				System.out.println(d.getTitle()+"/"+d.getMemo());
			}
		}
	}

	private void del() {
		// TODO Auto-generated method stub
		// 순서.. 제목을 입력하고 삭제 한다...
		System.out.println("삭제할 제목을 입력하세요");
		String delTitle = in.nextLine();
		
		// 이전글을 확인하지 않고 바로 삭제 해 볼께요.  확인을 해되 된다. 그건 개발자 마음..
		daydao.delete(delTitle);
		
	}

	private void mod() {
		// 수정할 일정의 제목을 입력하세요..
		// 일정의 제목을 찾아서 가져와야 한다... 쿼리
		// select * from dayday where title=?
		// insert delete update는 쿼리의 리턴이 정수 였다면
		// select 쿼리의 리턴이 튜플이 됩니다. 즉 daydayDTO객체로 가져가야 한다..
		
		System.out.println("수정할 제목을 입력하세요");
		String sTitle = in.nextLine();
		DaydayDTO nowDay = daydao.oneSelect(sTitle);
		System.out.println(nowDay.getMemo()+"/"+nowDay.getTitle());
		
		System.out.println("내용만 수정이 가능합니다. \n 내용을 입력하세요");
		String newMemo = in.nextLine();
		nowDay.setMemo(newMemo);
		daydao.update(nowDay);
		// dao에서 갱신의 기능을 수행하는 메서드를 호출
		// 메서드 정의시 다음과 같이 고려하여 dao 정의.
		// 호출입장에서는 리턴값이 필요할까? 없어도 된다.
		// 호출시 넘겨 줘야 하는 매개변수가 필요한가? 필요
	}

	private void add() {
		// TODO Auto-generated method stub
		System.out.println("일정을 추가하세요");
		DaydayDTO addday= new DaydayDTO();
		addday.setTitle(in.nextLine());
		addday.setMemo(in.nextLine());		
		daydao.add(addday);
		
	}
	
}
