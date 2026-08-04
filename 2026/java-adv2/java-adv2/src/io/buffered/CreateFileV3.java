package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : CreateFileV1
 */
public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        // BUFFER_SIZE 없이 생성 시 Java 버전별 기본값으로 세팅됨 ex: 4KB , 8KB 등등
        BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            bos.write(1);
        }
        bos.close();

        long endTime = System.currentTimeMillis();

        System.out.println("FILE NAME = " + FILE_NAME);
        System.out.println("FILE SIZE = " + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time Taken = " + (endTime-startTime) + "ms");
    }
}
