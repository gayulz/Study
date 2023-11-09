package daywork;

import java.util.Scanner;

public class Functions {

    Scanner in = new Scanner(System.in);
    public String retrunText(String str){
        System.out.print(str + " 입력 >> ");
        return in.nextLine();
    }
}
