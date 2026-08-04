package io.buffered;

import java.io.*;

import static io.buffered.BufferedConst.*;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : ReadFileV1
 */
public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        /*
         * BufferedXx 클래스는 모두 동기화 처리가 되어있어서 직접 Buffer를 핸들링 하지 않는다면 V2보다 V3가 더 오래걸림
         * 동기화 락이 없는 BufferedXxx 클래스는 없음.
         * 대용량 데이터를 다루거나 성능 최적화가 중요할 경우 직접 버퍼를 다루는 방법을 고려해야함.
         *
         * BUFFER_SIZE 없이 생성 시 Java 버전별 기본값으로 세팅됨 ex: 4KB , 8KB 등등
         * */
        BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = bis.read()) != -1) {
            fileSize++;
        }

        bis.close();

        long endTime = System.currentTimeMillis();

        System.out.println("FILE NAME = " + FILE_NAME);
        System.out.println("FILE SIZE = " + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time Taken = " + (endTime - startTime) + "ms");
    }


}
