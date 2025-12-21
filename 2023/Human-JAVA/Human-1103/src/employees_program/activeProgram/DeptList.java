package employees_program.activeProgram;

import java.util.HashMap;

import static employees_program.activeProgram.AcitveEmplyoeeProgram.getEmployessList;

public class DeptList {
    private HashMap<Integer, Employees> employeesList = getEmployessList();
    private Employees em = null;
    private String[] deptName = null;
    private Functions fn = new Functions();

    DeptList() {deptListSearch();}

    private void deptListSearch() {
        deptName = AcitveEmplyoeeProgram.getDeptName();
        System.out.println("부서별 근무 사원 정보 메뉴입니다");
        // 부서목록 출력 메서드
        fn.prtDeptAndJobTitle("부서");
        String deptNames = fn.returnText("조회 부서 명");
        // 일치한 부서의 사원 정보를 출력해주는 메서드
        if (fn.compareDept(deptNames)) isDept(deptNames);
    }

    private String isDept(String deptNames) {
        for (Integer key : employeesList.keySet()) {
            this.em = getEmployessList().get(key);
            if (em.getEmDept().equals(deptNames)) {
                fn.prtEmployees(em);
            }
        }
        return null;
    }
}
