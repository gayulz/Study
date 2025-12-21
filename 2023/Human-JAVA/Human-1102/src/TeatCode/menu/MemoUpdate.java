package TeatCode.menu;

import TeatCode.*;

import java.io.*;

public class MemoUpdate {

    /*
    메모 수정 시나리오
    메뉴 진입시 리스트 번호와 제목을 보여준다
    수정할 리스트 번호를 선택 후 진행한다
    수정 로직은 새로운 파일을 하나 더 만든다 (기존파일명에 .temp)를 추가한 파일
    수정이 정상적으로 완료 되면 새로운 파일을 생성해서 기존 파일명으로 바꿔준다.
    수정시 리스트 번호도 갱신된다
    */

    public MemoUpdate() {
        System.out.println("메모 수정 메뉴 입니다");
        Functions fn = new Functions();
        fn.prtMemoList();
        int selNum = fn.selectMemoIdx();
        String fileTitle = Controller.getMemoList().get(selNum);
        File beforFile = new File(fileTitle);   // inputFile
        File afterFile = new File(fileTitle+".temp"); // outputFile
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        boolean result = false;

        try {
            fileInputStream = new FileInputStream(beforFile);
            fileOutputStream = new FileOutputStream(afterFile);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            while (true) {
                String writerLine = fn.inputKey("[exit - 종료] 글");
                if (writerLine.toLowerCase().equals("exit")) break;
                bufferedWriter.write(writerLine,0,writerLine.length());
                bufferedWriter.newLine();
            }
            result = true;

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File not found");
        } finally {
            // close할때는 하나씩 해조는게 좋다함
            try {
                bufferedReader.close();
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
            try {
                bufferedWriter.close();
            } catch (IOException ex2){
                ex2.printStackTrace();
            }
            if (result){
                beforFile.delete();
                afterFile.renameTo(new File(fileTitle));
                Controller.setMemoList(fileTitle, 2);
                Controller.setMemoList(fileTitle, 1);
            }
        }

    }
}
