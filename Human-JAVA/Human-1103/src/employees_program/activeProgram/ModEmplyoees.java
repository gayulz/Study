package employees_program.activeProgram;

import java.util.HashMap;

import static employees_program.activeProgram.AcitveEmplyoeeProgram.getEmployessList;

public class ModEmplyoees {
    // 사원 수정 메뉴
    Functions fn  = new Functions();
    private HashMap<Integer, Employees> employeesList = getEmployessList();
    ModEmplyoees(){
        modEmplyoees();
    }

    private void modEmplyoees(){
        Employees em = null;
        System.out.println("사원 정보 수정 입니다");
        try {
            int emNum = Integer.parseInt(fn.returnText("수정 할 사원 번호"));
            if (fn.compareEmNumber(emNum)) {
                em = employeesList.get(emNum);
                System.out.println("수정 가능 항목 : 직위 or 부서");
                String editStr = fn.returnText("수정 항목");
                if (editStr.equals("부서")) {
                    fn.prtDeptAndJobTitle("부서");
                    String afterStr = fn.returnText("부서");
                    if (fn.compareDept(afterStr)) {
                        System.out.println(" 변경 전 [ " + em.getEmDept() + " ] ");
                        em.setEmDept(afterStr);
                        System.out.println(" 변경 후 [ " + em.getEmDept() + " ] ");
                        System.out.println(" [ " + em.getEmName() + " ] 부서 변경 완료 ");
                    }
                } else if (editStr.equals("직위")) {
                    fn.prtDeptAndJobTitle("직위");
                    String afterStr = fn.returnText("직위");
                    if (fn.compareJobTitle(afterStr)) {
                        System.out.println(" 변경 전 [ " + em.getEmJobTitle() + " ] ");
                        em.setEmJobTitle(afterStr);
                        System.out.println(" 변경 후 [ " + em.getEmJobTitle() + " ] ");
                        System.out.println(" [ " + em.getEmName() + " ] 님 직위 변경 완료 ");
                    }
                } else {
                    System.out.println("Unable to process");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Unable to process");
        }
    }
}
