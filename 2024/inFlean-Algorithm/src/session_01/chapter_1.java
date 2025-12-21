package session_01;
import java.util.Scanner;
class chapter_1 {
    public int solution(String input1, char input2) {

        int annwer = 0;
        input1 = input1.toUpperCase();
        input2 = Character.toUpperCase(input2);
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == input2) annwer++;
        }
        return annwer;
    }

    public static void main(String[] args) {
        chapter_1 T = new chapter_1();
        Scanner kb = new Scanner(System.in);

        String inputMessage1 = kb.next();
        char inputMessage2 = kb.next().charAt(0);
        System.out.println(T.solution(inputMessage1, inputMessage2));


    }
//    public int solution(String str, char t) {
//        int answer = 0;
//        str=str.toUpperCase();
//        t=Character.toUpperCase(t);
////        for (int i = 0; i < str.length(); i++) {
////            if(str.charAt(i) == t) answer++;
////        }
//
//
//        for (char x : str.toCharArray()) {
//            if (x == t) answer++;
//        }
//
//// Foreach 문법
//// 문자 한개한개 대응해서 진행하는것, foreach 에서는 배열이나 이터레이터 컬렉션 프레임워크(리스트, 어레이리스트)만 가능하다
//// str = String 을 문자배열로 바꿔줘야한다
//// toCharArray = str의 값을  기반해서 한개한개씩 문자를 분리해 문자 배열을 생성(새로운 문자배열 객체를 생성한다)
//        return answer;
//    }
//
//
//    public static void main(String[] args) {
//        chapter_1 T = new chapter_1();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        char c = kb.next().charAt(0);
//        System.out.println(T.solution(str, c));

}

