package TeatCode;
import TeatCode.menu.*;
import java.util.ArrayList;

public class Controller {
    private static ArrayList<String> memoList = new ArrayList<>();
    // todo 단어장 만들기
    // 필요 기능
    // 1. 생성과 저장
    // 2. 전체보기
    // 3. 메모장 수정
    // 4. 메모 삭제
    // 전체적인 메뉴로 진입하고 memoList를 생성하는곳
    public Controller(){
        boolean flag = true;
        while (flag){
            Functions fn = new Functions();
            info();
            int userNum = Integer.parseInt(fn.inputKey("메뉴 번호"));
            switch ( userNum ){
                case 1 :  // 메모 저장
                    new MemoWrite();
                    break;
                case 2 : // 메모 전체보기
                    new MemoTOTview();
                    break;
                case 3 : // 메모 수정
                    new MemoUpdate();
                    break;
                case 4 : // 메모 삭제
                    new MemoDelete();
                    break;
                case 5 :
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                    break;
                default :
                    System.out.println("잘못된 번호 입력입니다. 다시 입력하세요");
            }
        }
    }

    public static ArrayList<String> getMemoList() {
        return memoList;
    }

    public static void setMemoList(String fileName, int num) {
        // 1번은 파일제목 list컬렉션에 추가 , 2번은 삭제
        if ( num == 1) memoList.add(fileName);
        if ( num == 2 ) memoList.remove(fileName);
    }

    private void info(){
        System.out.println("나만의 메모장 관리 입니다");
        System.out.println("1. 새로운 메모");
        System.out.println("2. 메모장 전체보기");
        System.out.println("3. 메모 수정");
        System.out.println("4. 메모 삭제");
        System.out.println("5. 종료");
    }
}
