package io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 4.
 * @fileName : PrintStreamEtcMain
 */
public class PrintStreamEtcMain {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream printStream = new PrintStream(fos);

        printStream.println("hello java");
        printStream.println(10);
        printStream.print(true);
        printStream.printf("hello %s", "world");
        printStream.close();
    }
}
