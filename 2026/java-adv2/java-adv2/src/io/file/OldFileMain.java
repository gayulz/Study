package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : OldFileMain
 */
public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        // exists : 파일이 있는지 확인 메서드
        System.out.println("File exists : " + file.exists());

        // 파일 생성
        boolean created = file.createNewFile();
        System.out.println("File created : " + created);

        // 디렉토리 생성
        boolean dirCreated = directory.mkdir();
        System.out.println("Dir created : " + dirCreated);

        // 파일 삭제
//        boolean deleted = file.delete();
//        System.out.println("File deleted : " + deleted);

        System.out.println("is file : " + file.isFile());
        System.out.println("is Directory : " + directory.isDirectory());
        System.out.println("File name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed: " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("Last modified: " + new Date(lastModified));

    }
}
