package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 5.
 * @fileName : NewFilesMain
 */
public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path dir = Path.of("temp/exampleDir");

        System.out.println("File exists :" + Files.exists(file));

        try {
            Files.createFile(file);
            System.out.println("File created : " + file);
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " File already exists");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            Files.createDirectory(dir);
        } catch(FileAlreadyExistsException e) {
            System.out.println(dir + "Directory already existss");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Files.delete(file);
//        System.out.println("File deleted :" + file);

        System.out.println("Is regular file : " + Files.isRegularFile(file));
        System.out.println("Is directory : " + Files.isDirectory(dir));
        System.out.println("File name : " + file.getFileName());
        System.out.println("File size : " + Files.size(file) + " bytes");

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, REPLACE_EXISTING);
        System.out.println("File moved / renamed");

        System.out.println("Last modified : " + Files.getLastModifiedTime(newFile));
        BasicFileAttributes attrs = Files.readAttributes(newFile, BasicFileAttributes.class);

        // readAttributes(): 파일의 기본 속성들을 한 번에 읽기
        System.out.println("===== Attributes =====");
        System.out.println("Create time : " + attrs.creationTime());
        System.out.println("Is Directory : " + attrs.isDirectory());
        System.out.println("Is regular file : " + attrs.isRegularFile());
        System.out.println("Is symbolic link : " + attrs.isSymbolicLink());
        System.out.println("Size : " + attrs.size());
    }
}
