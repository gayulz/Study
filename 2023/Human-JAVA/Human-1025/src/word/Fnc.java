package word;
//클래스 정의 : 특수문자가 포함되었는지의 유효성 체크하는 객체
public class Fnc {

	String sign="!@#$%^&*";

	public int chkString(String word) {
		// word에 특수 문자가 몇개 포함되었는지 체크 한다.
		int cnt=0;
		for(int i=0; i < word.length(); i++) {
			for(int j=0; j < sign.length(); j++) {
				if(word.charAt(i)==sign.charAt(j)) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
