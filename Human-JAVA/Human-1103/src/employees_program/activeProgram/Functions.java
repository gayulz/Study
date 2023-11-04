package employees_program.activeProgram;
import java.util.HashMap;
import java.util.Scanner;
import static employees_program.activeProgram.AcitveEmplyoeeProgram.getEmployessList;

public class Functions {

    private HashMap<Integer, Employees> employeesList = null;
    private Employees em = null;
    private Scanner in = new Scanner(System.in);
    private String[] deptName = AcitveEmplyoeeProgram.getDeptName();
    private String[] jobTitle = AcitveEmplyoeeProgram.getJobTitle();

    // 부서와 직위목록 출력해주는 메서드
    public void prtDeptAndJobTitle(String text) {
        if (text.equals("부서")) {
            System.out.print("선택 가능한 부서 목록 : ");
            for (String dept : this.deptName) System.out.print(dept + " ");
        } else {
            System.out.print("선택 가능한 직위 목록 : ");
            for (String job : this.jobTitle) System.out.print(job + " ");
        }
        System.out.println();
    }


    // 입력한 부서가 목록에 있는 부서인지 판단후 결과리턴
    public boolean compareDept(String isDeptName) {
        for (String tmp : this.deptName)
            if (isDeptName.equals(tmp)) return true;
        System.out.println("해당 부서는 찾을 수 없습니다");
        return false;
    }


    // 입력한 직위가 목록에 있는 직위인지 판단후 결과리턴
    public boolean compareJobTitle(String jobTitle) {
        for (String job : this.jobTitle)
            if (job.equals(jobTitle))  return true;
        System.out.println("해당 직위는 찾을 수 없습니다");
        return false;
    }

    // 사원번호 동일한 사람이 있는지 확인 후 결과 리턴
    public boolean compareEmNumber(int num){
        employeesList = getEmployessList();
        if (employeesList.containsKey(num)) return true;
        else System.out.println("동일한 사원 번호가 있습니다");
        return false;
    }


    // 사원 정보 출력
    public void prtEmployees (Employees em){
        this.em = em;
        System.out.println("------------------------------------------");
        System.out.println("직   위 : " + em.getEmJobTitle());
        System.out.println("사원번호 : " + em.getEmNum());
        System.out.println("근무부서 : " + em.getEmDept());
        System.out.println("이   름 : " + em.getEmName());
        System.out.println("나   이 : " + em.getEmAge());
    }

    // 입출력 리턴
    public String returnText(String text) {
        System.out.print("\t\t" + text + " 입력 >> ");
        String outPutText = in.nextLine();
        return outPutText;
    }
}
