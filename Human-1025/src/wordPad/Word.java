package wordPad;

public class Word {
    // 제목, 내용, 중요도 , 관심 단어 유무를 저장하는 클래스
    String title = ""; // 제목
    String memo = ""; // 메모
    int flag = 1; // 1 ~ 3까지 있다. 3이 중요도가 가장 높다
    boolean imflag = false;

    public void prt(){
        System.out.println(title);
        if (imflag == true){
            System.out.print(" * \n");
        } else System.out.println();

    }

}
