package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 4.
 * @fileName : ReaderWriterMainV3
 */
public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;
    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println( "--------\tWrite String\t--------");
        System.out.println(writeString);

        // 파일에 쓰기 , 인코딩 셋을 명시하지 않을 경우 운영체제 및 기본값의 인코딩셋으로 진행함
        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw, BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;
        while((line = br.readLine()) != null){
            content.append(line).append("\n");
        }
        br.close();
        System.out.println( "--------\tRead String \t--------");
        System.out.println(content);
    }
}
