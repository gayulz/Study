package TeatCode.menu;
import TeatCode.Controller;
import TeatCode.Functions;
import java.io.File;

/*
메모 삭제 시나리오
메모 삭제 시 리스트 번호와 제목을 전체 보여준다
사용자는 삭제 할 번호를 키보드에 입력한다
삭제가 완료되면 어떤 파일이 삭제 되었는지 삭제된 메모장 이름을 적어주고 종료된다
*/

public class MemoDelete {
    public MemoDelete() {
        System.out.println("메모 삭제 메뉴입니다.");
        Functions fn = new Functions();
        fn.prtMemoList();
        int selNum = fn.selectMemoIdx();
        try {
            String tmp = Controller.getMemoList().get(selNum);
            File file = new File(tmp);
            file.delete();
            System.out.println(tmp + " 파일 삭제 완료");
            Controller.setMemoList(tmp, 2);
        } catch (Exception e) {
            System.out.println("File not found");

        }
    }
}