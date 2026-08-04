package io.text;

import java.io.*;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 4.
 * @fileName : ReaderWriterMainV1
 */
public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {

        /*
        * OutputStreamWriter: 스트림에 byte 대신에 문자를 저장할 수 있게 지원한다.
        * InputStreamReader: 스트림에 byte 대신에 문자를 읽을 수 있게 지원한다
        * */

        String writeString = "가나다";
        System.out.println("writeString = " + writeString);

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);

        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);

        osw.write(writeString);
        osw.close();


        // 파일에서 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;

        /* isr.read() : char 타입 1개씩 읽어옴 -> int로 반환됨으로 char 로 형변환 필요 */
        while((ch = isr.read()) != -1){
            content.append((char) ch);
        }

        isr.close();
        System.out.println("read String = " + content);
    }
}
