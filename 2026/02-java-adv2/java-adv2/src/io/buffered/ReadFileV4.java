package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 2.
 * @fileName : ReadFileV1
 */
public class ReadFileV4 {
    public static void main(String[] args) throws IOException {
        /*
        * 한번에 모든 데이터 읽기
        * 조심해야할 것 : 파일 크기가 클 경우 메모리오버헤드 발생됨
        * 파일이 적을 경우 한번에 읽거나 쓰는게 편하지만 데이터가 클 경우 버퍼를 이용하는게 더 성능상 좋을 수 있다.
        * */
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] bytes = fis.readAllBytes();

        fis.close();
        long endTime = System.currentTimeMillis();
        System.out.println("FILE NAME = " + FILE_NAME);
        System.out.println("FILE SIZE = " + (FILE_SIZE / 1024 / 1024) + "MB");
        System.out.println("Time Taken = " + (endTime-startTime) + "ms");
    }
}
