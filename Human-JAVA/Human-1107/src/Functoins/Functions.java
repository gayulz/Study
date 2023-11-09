package Functoins;

import java.util.Scanner;

public class Functions {
    public String retrunText(String text) {
        Scanner in = new Scanner(System.in);
        System.out.print("\t" + text + " 입력 >> ");
        return in.nextLine();
    }
}
