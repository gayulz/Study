package employees_program.activeProgram;

import static employees_program.activeProgram.AcitveEmplyoeeProgram.*;

public class AddEmplyoees {
    // 사원 추가
    private Functions fn = new Functions();
    AddEmplyoees() {
        addEmplyoees();
    }

    private void addEmplyoees() {
        Employees em = new Employees();
        System.out.println("사원 등록 메뉴 입니다");
        try {
            int emNum = Integer.parseInt(fn.returnText("사원 번호"));
            // 동일 사번이 있는지 판단 후 리턴
            if (!(fn.compareEmNumber(emNum))) {
                em.setEmNum(emNum);
                em.setEmName(fn.returnText("이름"));
                em.setEmAge(Integer.parseInt(fn.returnText("사원 나이")));
                fn.prtDeptAndJobTitle("부서");
                em.setEmDept(fn.returnText("근무 부서"));
                // 입력된 부서가 내부 부서목록과 일치 판단 후 리턴
                if (fn.compareDept(em.getEmDept())) {
                    fn.prtDeptAndJobTitle("직위");
                    em.setEmJobTitle(fn.returnText("직위 등록"));
                    // 입력된 직위가 내부 직위목록과 일치 판단 후 리턴
                    if ( fn.compareJobTitle(em.getEmJobTitle()))
                        setEmployessList(em.getEmNum(), em);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to process");
        }
    }
}
