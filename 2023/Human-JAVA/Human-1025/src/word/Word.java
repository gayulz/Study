package word;

public class Word {
	String title=null;
	String memo=null;
	int flag=1;  // 1부터 3까지 가능하다.. 3으로 갈 수록 중요도가 높다.
	boolean myChkFlag=false;

	// Word 객체 마다 모두 독립적으로 갖게 되는 메서드입니다..
	// 변수 3개를 prt라는 메서드 하나를 호출하여 정보를 출력합니다.
	public void prt() {
		System.out.print("1. 제목 : "+title);
		if(myChkFlag) {
			System.out.println("*");
		}else {
			System.out.println();
		}
		System.out.println("2. 내용 : "+memo);
		System.out.println("3. 중요도 : "+flag);

	}

}
