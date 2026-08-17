package test;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 9.
 * @fileName : test
 */
public class test {
    public static void main(String[] args) {
        String message = "/message | 안녕하세요";
        System.out.println("message.indexOf(\"|\") = " + message.indexOf("\\|"));
        String[] menu = message.split("\\|");
        String trimToMenu = menu[0].trim();
        for(String m : menu){
            System.out.println("m :" + m);
        }
        System.out.println(trimToMenu.replaceAll(" ", ""));
        System.out.println(trimToMenu.length());

    }
}
