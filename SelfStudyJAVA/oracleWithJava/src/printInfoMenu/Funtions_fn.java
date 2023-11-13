package printInfoMenu;

import java.util.Scanner;

public class Funtions_fn {


    Scanner in = new Scanner(System.in);




    // in_out 메서드
    public String returnText(String text) {
        System.out.print("\t" + text + " 입력 >> ");
        return in.nextLine();
    }
}
