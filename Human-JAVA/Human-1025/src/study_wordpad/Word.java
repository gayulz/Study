package study_wordpad;

public class Word {
    // 제목, 내용, 중요도 , 관심 단어 유무를 저장하는 클래스
    String title = null; // 제목
    String memo = null; // 메모
    int flag = 1; // 1 ~ 3까지 있다. 3이 중요도가 가장 높다
    boolean myCheckFlag = false;

    public void prt() {
        System.out.println("1. 제목 : " + title);
        System.out.println("2. 내용 : " + memo);
        System.out.println("3. 중요도 : " + flag);
        if (myCheckFlag) {
            System.out.print(" * \n");
        } else System.out.println();

    }

}
