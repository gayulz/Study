package study;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TodaySampleCode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("생성할 파일명을 입력하세요");
        String fname = in.nextLine();
        File file = new File(fname);
        FileWriter a = null;

        try {
            a = new FileWriter(file);
            while (true) {
                System.out.println("글을 입력하세요. exit는 종료입니다");
                String wLine = in.nextLine();
                if (wLine.equals("exit")) break;
                a.append(wLine);
                a.append("\n");
            }
        } catch (Exception e) {
        } finally {
            try {
                a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        FileReader fr = null;
        try {
            char[] readL = new char[100];
            fr = new FileReader("b.txt");
            if (fr.read(readL) != -1) {
                String k = new String(readL);
                System.out.println(k);
                String[] karry = k.split("\n");
                for (String kk : karry) {
		        System.out.println(kk);
                }
                System.out.println(karry.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
