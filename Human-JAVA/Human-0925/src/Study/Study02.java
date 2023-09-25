package Study;

public class Study02 {
    public static void main(String[] args) {
        String test = "aaamvvccm";
        // 쌤의 풀이
        // 악성문자 몇개 어디에있는지, 악성문자의 이름은 ?
        // 악성문자 정의
        char badChar = 'm';
        // 카운팅 저장 변수
        int cnt = 0;
        // 바꿀 값 변수 선언
        String temptest = " ";
        for (int i = 0; i < 9; i++) {
            char nowChar = test.charAt(i);
            if(nowChar == badChar) {
                cnt++;                                                             // 카운팅 누적
                System.out.println("인덱스 [" + i + "] 위치에 악성문자가 있습니다.");      //  악성문자 위치
                temptest +=  "*";
            } else {
                temptest = temptest + nowChar;
            }
        }
        System.out.println("악성 문자는 : " + cnt + "개 있습니다.");
        test = temptest;
        System.out.println(test.replace('a', 'A'));
    }
}
