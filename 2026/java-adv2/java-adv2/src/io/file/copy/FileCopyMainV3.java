package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : FileCopyMainV3
 */
public class FileCopyMainV3 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();


        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        // Files.copy() 는 자바에 파일 데이터를 불러오지 않고 , 운영 체제의 파일 복사 기능을 사용한다.
        // 따라서 중간 과정이 생략되며 가장 빠르다.

        Files.copy(source, target, REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken : " + (endTime - startTime) + "ms");

    }
}
