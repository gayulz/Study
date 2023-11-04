package TeatCode.menu;

import TeatCode.Functions;

import java.io.FileReader;
import java.util.ArrayList;

import static TeatCode.Controller.getMemoList;

/*
메모 전체 보기 시나리오
처음엔 List에 등록된 메모장 제목만 보여준다
전체 보기 하고 싶은 List번호를 사용자는 키보드로 입력한다
번호 입력이 정상적인 경우 해당 제목의 파일에 내용을 전체다 읽어온다
 */

public class MemoTOTview {
    ArrayList<String> memoList = null;

    public MemoTOTview() {
        // 메모 전체보기
        // 시나리오 : 해당 메뉴 진입시 등록된 모든 메모의 제목을 보여준다
        Functions fn = new Functions();
        FileReader fileReader = null;
        fn.prtMemoList();
        this.memoList = getMemoList();
        try {
            int userNum = fn.selectMemoIdx();
            char[] readText = new char[100];
            fileReader = new FileReader(memoList.get(userNum));
            if (fileReader.read(readText) != -1) {
                String k = new String(readText);
                String[] karry = k.split("\n");
                for (String tmp : karry) System.out.println(tmp);
            }
        } catch (Exception e) {
        } finally {
            try {
                fileReader.close();
            } catch (Exception e) {
                System.out.println("File not found");
            }
        }
    }
}
