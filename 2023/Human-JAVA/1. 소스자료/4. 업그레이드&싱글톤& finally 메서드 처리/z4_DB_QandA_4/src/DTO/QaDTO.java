package DTO;

public class QaDTO {
	/*
	 * 
create table qanda(
title varchar2(10),
memo varchar2(30),
wr varchar2(10),
pass varchar2(4),
scret number(1) default 1,
wdate timestamp default sysdate);
desc qanda;
select * from qanda;
	 * 
	 * 
	 */
	
	// 맴버변수와 테이블의 속성의 이름은 일치해야 한다..<필수는 아니지만 이렇게 하는 것이 옳다>
	// 갯수는 일치 하지 않아도 됩니다만.. 매핑하기 위해서는 일치하는 것이 좋다.
	private String title=null;
	private String memo=null;
	private String wr=null;
	private String pass=null;
	private int scret=1;
	// table에는 wdate라는 속성이 있다.. 반드시 일치 하지 않아도 된다는 것을 공부하기 위해서 여기서는 생략
	// 만약 실제 십습시에는 넣는것이 좋겠다..
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getWr() {
		return wr;
	}
	public void setWr(String wr) {
		this.wr = wr;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getScret() {
		return scret;
	}
	public void setScret(int scret) {
		this.scret = scret;
	}
	
	public void prt() {
		System.out.println("------------<info>----------");
		if(scret!=1) {
			System.out.println("제목 : "+title.substring(0,2)+"***");
			System.out.println("비밀글입니다.");
		}else {
			System.out.println("제목 : "+title);
			System.out.println("내용 : "+memo);
			System.out.println("작성자 : "+wr);
			System.out.println("공개여부 : "+scret);
			System.out.println("비밀번호 : "+pass);
		}
	}
}
