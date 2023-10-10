package Chapter_List;
public class chapter_7 {
    public static void main(String[] args) {
        String str = "sosSoSsos";
        String str1 = str.toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str1.charAt(i);
            for (int j = str.length()-1; j < str.length()/2; j--) {
                if (tmp == str1.charAt(j)){

                }
            }
        }



    }
}
