package minigame;

public class TrueAndFalse {
    // 오답노트 출력시 필요한 배열 선언
    static String[] wrongNote = {" 오답 노트 >> ", "", "", ""};
    public void inPutWrong(String str, int falseCnt) {
        wrongNote[falseCnt] = str;
    }
    public static void outWrongNote(){
        for (int i = 0; i < wrongNote.length; i++) {
        	if ( i == 0 ) System.out.print(wrongNote[i]);
        	else if ( i < 3 ) System.out.print(wrongNote[i] + ",\t");
        	else System.out.print(",\t"+wrongNote[i]);
        }
        System.out.println("\n✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
    }
    public static boolean trueIsFalse(String str1, String str2) {
        //str1 : 문제 , str2 : User입력문자
        Boolean result = str1.toLowerCase().equals(str2);
        if (result == true) {
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            System.out.println("\t\t\t\t정답입니다.");
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
        } else if (result == false) {
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
            System.out.println("\t\t\t\t오답 입니다");
            System.out.println("✎﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
        }
        return result;
    }
}
