package Member;

import java.util.ArrayList;
import java.util.Scanner;
public class MemberADM {
	private Scanner in = new Scanner(System.in);
	private ArrayList<Member> mlist = new ArrayList<>();	
	public MemberADM() {
		boolean flag = true;
		while(flag) {
			System.out.println("1. add 2. mod 3. del 4. list");
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
	private void add() {
		Member m = new Member();
		String id = keyData("?????",2);
		int result = serchIdx(id);
		if(result == -1) {
			m.setId(id);
			m.setPass(keyData("??��??",1));
			mlist.add(m);
		}else {
			System.out.println("??? ?????????");
		}
	}
	private String keyData(String title, int level) {
		String data = null;
		while(data == null) {
			System.out.println(title +"?? ????? ?????");
			data = in.nextLine();
			if(level == 1) {
				if(data.length() < 4) {
					System.out.println("????? 4???? ???????? ????. ");
					data=null;
				}
			}else if(level == 2) {
				String s = "!@#$%^&*";
				int cnt=0;
				for(int i=0; i < data.length(); i++) {
					for(int j=0; j < s.length(); j++) {
						if(data.charAt(i)== s.charAt(j)) {
							cnt++;
						}
					}
				}
				if(data.length() > 3) {
					if(cnt <= 0) {
						System.out.println("??????? ?????? ????? ");
						data=null;
					}
				}else {
					System.out.println("????? 4???? ???????? ????. ");
					data=null;
				}
			}
		}
		return data;
	}
	
	private void list() {
	/*	for(int i=0; i < mlist.size(); i++) {
			mlist.get(i).prt();
		}*/
		//????  for
		for(Member m : mlist) {  //mlist?? ????? ??????? Member???
			m.prt();             // ??????? ???? ?????? ??????  m?????? ???????.
		}
	}

	private void del() {
		// TODO Auto-generated method stub
		String id = keyData("?????",2);
		int delIdx = serchIdx(id);
		if (delIdx != -1) {
			mlist.remove(delIdx);
		}else {
			System.out.println("????? ???????");
		}
	}
	private void mod() {
		String id = keyData("?????",2);
		int modIdx = serchIdx(id);
		if(modIdx != -1) {
			Member m = mlist.get(modIdx);
			m.setPass(keyData("??��??",1));
		}else {
			System.out.println("????? ???????.");
		}
		
	}
	private int serchIdx(String id) {
		for(int i=0; i < mlist.size(); i++) {
			if(mlist.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
