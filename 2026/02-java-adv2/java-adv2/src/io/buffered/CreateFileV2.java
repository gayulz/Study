package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;
import static java.nio.file.Files.write;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : CreateFileV1
 */
public class CreateFileV2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[bufferIndex++]=1;

            // 버퍼가 가득 차면 쓰고, 버퍼를 비운다.
            if(bufferIndex == BUFFER_SIZE){
                fos.write(buffer);
                bufferIndex = 0;
            }
        }

        // 끝 부분에 오면 버퍼가 가득차지 않고, 남아 있을 수 있다. 버퍼에 남은 부분 쓰기
        if(bufferIndex >0){
            fos.write(buffer, 0, bufferIndex);

        }

        fos.close();
        long endTime = System.currentTimeMillis();

        System.out.println("FILE_NAME = " + FILE_NAME);
        System.out.println("FILE_SIZE = " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time Taken = " + (endTime-startTime) + "ms");
    }
}
