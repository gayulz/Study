package TeatCode.menu;
import TeatCode.Controller;
import TeatCode.Functions;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MemoWrite {

    /*
    메모 생성 시나리오
    사용자가 메모를 새로 생성한다
    List를 사용하여 정상 메모 생성 시 memoList에 추가해준다
    예외가 발생 된 경우 List에 추가되지 않도록 한다
    */

    public MemoWrite() {
        Functions fn = new Functions();
        String fileName = fn.inputKey("새로 만들 폴더명");
        File file = new File(fileName + ".txt");
        FileWriter fileWriter = null;
        String filename = file.getName();
        try {
            fileWriter = new FileWriter(file);
            while (true) {
                String writerLine = fn.inputKey("[exit - 종료] 글");
                if (writerLine.toLowerCase().equals("exit")) break;
                fileWriter.append(writerLine);
                fileWriter.append("\n");
            }
            Controller.setMemoList(filename,1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
