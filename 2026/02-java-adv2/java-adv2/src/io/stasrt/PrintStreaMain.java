package io.stasrt;

import java.io.IOException;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : PrintStreaMain
 */
public class PrintStreaMain {
    public static void main(String[] args) throws IOException {

        PrintStream printStream = System.out;

        byte[] bytes = "Hello!\n".getBytes(UTF_8);
        printStream.write(bytes);
        printStream.println("Print");
    }
}
