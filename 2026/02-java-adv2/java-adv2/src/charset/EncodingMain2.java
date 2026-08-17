package charset;

import java.util.Arrays;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.*;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : EncodingMain2
 */
public class EncodingMain2 {

    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("================== 영문 ASCII 인코딩 ==================");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1); // ASCII 확장 (LATIN-1)
        test("A", US_ASCII, EUC_KR); // ASCII 포함
        test("A", US_ASCII, MS_949); // ASCII 포함
        test("A", US_ASCII, UTF_8); // ASCII 포함
        test("A", US_ASCII, UTF_16BE); // UTF_16 디코딩 실패

        System.out.println("================== 한글 인코딩 by 기본 ==================");
        test("가", US_ASCII, US_ASCII); // 디코딩 실패
        test("가", ISO_8859_1, ISO_8859_1); // 디코딩 실패
        test("가", EUC_KR, EUC_KR); // 디코딩 성공
        test("가", MS_949, MS_949); // 디코딩 성공
        test("가", UTF_8, UTF_8); // 디코딩 성공
        test("가", UTF_16, UTF_16); // 디코딩 성공

        System.out.println("================== 한글 인코딩 by 복잡한 문자 ==================");
        test("뷁", US_ASCII, US_ASCII); // 디코딩 실패
        test("뷁", ISO_8859_1, ISO_8859_1); // 디코딩 실패
        test("뷁", EUC_KR, EUC_KR); // 디코딩 실패
        test("뷁", MS_949, MS_949); // 디코딩 성공
        test("뷁", UTF_8, UTF_8); // 디코딩 성공
        test("뷁", UTF_16BE, UTF_16BE); // 디코딩 성공

        System.out.println("================== 한글 인코딩 by 디코딩이 다른 경우 ==================");
        test("가", EUC_KR, MS_949);
        test("뷁", MS_949, EUC_KR); // 디코딩 실패
        test("가", EUC_KR, UTF_8); // 디코딩 실패
        test("가", MS_949, UTF_8); // 디코딩 실패
        test("가", UTF_8, MS_949); // 디코딩 실패

        System.out.println("================== 영문 인코딩 by 디코딩이 다른 경우 ==================");
        test("A", EUC_KR, UTF_8);
        test("A", MS_949, UTF_8);
        test("A", UTF_8, MS_949);
        test("A", UTF_8, UTF_16BE); // 디코딩 불가

    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        System.out.printf("%s\t->\t[%s] 인코딩\t->\t%s\t%sbyte\t->\t[%s] 디코딩\t->\t%s\n",
                text,
                encodingCharset,
                Arrays.toString(decoded.getBytes()),
                encoded.length,
                decodingCharset,
                decoded
                );

    }
}
