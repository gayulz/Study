package wordNote;

public class Words {
    int stage = 0;
    String krWord = null;
    String engWord = null;
    public void prt(){
        System.out.println("=======================");
        System.out.println(" LEVEL   >> [ Lv " + stage + " ]");
        System.out.println(" KOREA   >> " + krWord);
        System.out.println(" ENGLISH >> " + engWord);
    }
}
