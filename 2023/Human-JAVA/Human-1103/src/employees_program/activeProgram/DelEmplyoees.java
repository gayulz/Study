package employees_program.activeProgram;
import java.util.HashMap;
import static employees_program.activeProgram.AcitveEmplyoeeProgram.getEmployessList;

public class DelEmplyoees {
    // 사원 삭제
    Functions fn = new Functions();
    private HashMap<Integer,Employees> employeesList = getEmployessList();

    DelEmplyoees(){
        deleteEmplyoees();
    }

    private void deleteEmplyoees() {
        System.out.println("사원 삭제 메뉴 입니다");
        try {
            int delEmNumber = Integer.parseInt(fn.returnText("삭제할 사원 번호"));
            if (fn.compareEmNumber(delEmNumber)) {
                String result = fn.returnText("정말 삭제하겠습니까 ? Y / N ").toLowerCase();
                if (result.equals("y")) {
                    employeesList.remove(delEmNumber);
                    System.out.println("사번 : " + delEmNumber + " 삭제 완료");
                } else System.out.println("초기 메뉴로 돌아갑니다");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unable to process");
        }
    }
}
