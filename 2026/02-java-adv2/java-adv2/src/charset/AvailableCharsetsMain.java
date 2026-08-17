package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : AvailableCharsetsMain
 */
public class AvailableCharsetsMain {
    public static void main(String[] args) {

        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }


        System.out.println("=============");

        // 문자로 조회(대소문자 구분 X), MS949 , ms 0959, x-windows-949
        Charset ms949 = Charset.forName("MS949");

        Set<String> aliases = ms949.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        // UTF-8 문자로 조회
        Charset charset2 = Charset.forName("UTF-8");
        System.out.println("charset2 = " + charset2);
        Set<String> alias2 = charset2.aliases();
        for (String alias : alias2) {
            System.out.println("charset2.aliases() = " + alias);
        }

        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8 = " + utf8);

        System.out.println("Charset.defaultCharset() : " + Charset.defaultCharset());

    }
}
