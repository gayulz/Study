package wordNote;
import java.util.Scanner;

public class Functions {
    Scanner in = new Scanner(System.in);
    // 원하는 단어를 찾아서 출력해주는 메서드
    public void loopFnc(Words[] str) {
        System.out.println(" 1 : Level , 2 : 한글 단어, 3 : 영어 단어 ");
        System.out.print(" 메뉴 번호 입력 >> ");
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                System.out.println("원하는 Level을 입력하세요");
                System.out.print(" 레벨 입력 >> ");
                int level = in.nextInt();
                in.nextLine();
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != null) {
                        if (str[i].stage == level) str[i].prt();
                    }
                }
                break;
            case 2:
                System.out.println("원하는 한글 단어를 입력하세요");
                System.out.print(" 한글 단어 입력 >> ");
                // 입력시 여백 발생이 있다면 여백 삭제
                String korTmp = in.nextLine().replaceAll("\\s", "");
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != null) {
                        // 입력시 여백 발생이 있다면 여백 삭제
                        if (str[i].krWord.replaceAll("\\s", "").equals(korTmp)) str[i].prt();
                    }
                }
                break;
            case 3:
                System.out.println("원하 영어 단어를 입력하세요");
                System.out.print(" 영어 단어 입력 >> ");
                // 입력시 여백 발생이 있다면 여백 삭제
                String eng = in.nextLine().toLowerCase().replaceAll("\\s", "");
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != null) {
                        // 입력시 여백 발생이 있다면 여백 삭제
                        if (str[i].engWord.toLowerCase().replaceAll("\\s","").equals(eng)) str[i].prt();
                    }
                }
                break;
            default:
                System.out.println("해당 번호의 메뉴가 없습니다");
        }
    }
    // 원하는 단어를 찾기위해 WordsNote 배열을 매개변수로 입력받아
    // 원하는 단어를 찾아 해당 배열의 주소값을 리턴해줌
    public Words pickFun(Words[] str){
        System.out.println(" 1 : 한글 단어, 2 : 영어 단어 ");
        System.out.print(" 메뉴 번호 입력 >> ");
        int choice = in.nextInt();
        in.nextLine();
        switch (choice) {
            case 1:
                System.out.println("한글 단어를 입력하세요");
                System.out.print(" 단어 입력 >> ");
                // 입력시 여백 발생이 있다면 여백 삭제
                String kor = in.nextLine().replaceAll("\\s", "");
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != null) {
                        // 입력시 여백 발생이 있다면 여백 삭제
                        if (str[i].krWord.replaceAll("\\s", "").equals(kor)) return str[i];
                    }
                }
                break;
            case 2:
                System.out.println("원하는 영어 단어를 입력하세요");
                System.out.print(" 단어 입력 >> ");
                // 입력시 여백 발생이 있다면 여백 삭제
                String eng = in.nextLine().toLowerCase().replaceAll("\\s", "");
                System.out.println(eng);
                for (int i = 0; i < str.length; i++) {
                    if (str[i] != null) {
                        // 입력시 여백 발생이 있다면 여백 삭제
                        if (str[i].engWord.toLowerCase().replaceAll("\\s", "").equals(eng)) {
                            System.out.println(str[i]);
                            return str[i];
                        }
                    }
                }
                break;
            default:
                System.out.println("해당 번호의 메뉴가 없습니다");
                return null;
        }
        return null;
    }
    // 중복 단어 체크 기능
    // 중복 단어가 있는지 여부 확인 후 boolean값 반환
    public boolean duplicateString (Words[] words , String wordsEng){
        String engTmp = null;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i] != null) {
                    // 입력시 여백 발생이 있다면 여백 삭제
                    engTmp = wordsEng.toLowerCase().replaceAll("\\s", "");
                    String eqsTmp = words[i].engWord;
                    if (engTmp.equals(eqsTmp.toLowerCase().replaceAll("\\s", ""))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
