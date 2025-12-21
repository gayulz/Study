package TeatCode;
import java.util.ArrayList;
import java.util.Scanner;
import static TeatCode.Controller.getMemoList;

public class Functions {

    // 간편한 기능들의 메서드를 모아논 클래스

    ArrayList<String> memoList = null;
    Scanner in = new Scanner(System.in);

    // 기능 메서드
    // 1. 키보드 입력 반환 메서드
    public String inputKey (String text){
        System.out.print("\t" + text + " 입력 >>  ");
        String userKeyInput = in.nextLine();
        return userKeyInput;
    }

    // 기능 메서드
    // 2. 등록된 모든 메모의 제목들을 출력해줌
    public void prtMemoList(){
        this.memoList = getMemoList();
        int i = 1;
        System.out.println("등록된 모든 메모의 제목입니다");
        for ( String memo : memoList ){
            System.out.println("List no."+ i + "\t Title : " + memo);
            i++;
        }
    }

    // 기능 메서드
    // 3. 등록된 메모 목록에서 사용자가 수정,삭제 할 메모의 번호를 눌러주면 인덱스 번호를 반환해주는 메서드
    public int selectMemoIdx(){
        this.memoList = getMemoList();
        int selNum = (Integer.parseInt(inputKey("메모 번호"))-1);
        for (int i = 0; i < memoList.size(); i++) {
            if ( selNum == i ) return i;
        }
        return -1;
    }
}
