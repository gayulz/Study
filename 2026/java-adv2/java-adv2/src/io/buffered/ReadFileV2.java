package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : ReadFileV1
 */
public class ReadFileV2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int fileSize = 0;
        int size;

        while((size = fis.read(buffer)) != -1){
            fileSize += size;
        }

        fis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("FILE NAME = " + FILE_NAME);
        System.out.println("FILE SIZE = " + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time Taken = " + (endTime-startTime) + "ms");
    }
}
