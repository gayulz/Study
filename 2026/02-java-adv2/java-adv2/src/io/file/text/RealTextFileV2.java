package io.file.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : RealTextFileV1
 */
public class RealTextFileV2 {
    private static final String PATH = "temp/hello2.txt";

    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("== Write String ==");
        System.out.println(writeString);

        Path path = Path.of(PATH);

        Files.writeString(path, writeString, UTF_8);

        String readString = Files.readString(path, UTF_8);

        System.out.println("== Read String ==");

        List<String> lines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + " : " + lines.get(i));

        }
    }
}
