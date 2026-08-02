package io.buffered;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : ReadFileV1
 */
public class ReadFileV1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;

        while((data = fis.read()) != -1){
            fileSize++;

        }

        fis.close();
        long endTime = System.currentTimeMillis();

        System.out.println("FILE NAME = " + FILE_NAME);
        System.out.println("FILE SIZE = " + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time Taken = " + (endTime-startTime) + "ms");
    }
}
