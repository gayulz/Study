package seetMain;

public class SeetDefine {
    public static String[] seetArrayDefine = new String[30];
    private static SeetDefine seetInstance;
    private SeetDefine(){}
    public static SeetDefine getSeetInstance(){
        if ( seetInstance == null ) seetInstance = new SeetDefine();
        return seetInstance;
    }
    public void seetArrayPrint(){
        System.out.println("현재 잔여 좌석입니다");
        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ [ S C R E E N ] ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
        for (int i = 0; i < seetArrayDefine.length+1; i++) {
            if (i == 5 || i == 10 || i == 15 || i == 20 || i == 20) System.out.println();
            String tmp = String.format("%10s", i + 1);
            if (i + 1 < seetArrayDefine.length+1 && seetArrayDefine[i + 1] != null) {
                String strTmp = tmp + "번 " + seetArrayDefine[i + 1];
                System.out.print(String.format("%10s", strTmp));
            } else if (seetArrayDefine[i] == null) System.out.print(tmp + "번 가능");
        }
        System.out.println();
    }
}
