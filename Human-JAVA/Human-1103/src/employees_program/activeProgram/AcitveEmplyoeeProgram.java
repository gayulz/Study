package employees_program.activeProgram;
import java.util.HashMap;
public class AcitveEmplyoeeProgram {
    private Functions fn = new Functions();
    // 사원 생성 시 입력받아 저장하는 hashMap
    private static HashMap<Integer, Employees> employessList = new HashMap<>();
    private static String[] deptName = {"인사팀", "회계팀", "개발팀", "영업팀", "인프라팀", "경영팀"};
    private static String[] jobTitle = {"임원", "부장", "차장", "과장", "대리", "주임", "사원"};

    // 사원들을 각각 등록할 HashMap
    public AcitveEmplyoeeProgram(){
        boolean flag = true;
        while (flag){
            info();
            int selNum = Integer.parseInt(fn.returnText("메뉴 번호"));
            switch (selNum){
                case 1 : // 사원 추가
                    new AddEmplyoees();
                    break;
                case 2 : // 사원 수정
                    new ModEmplyoees();
                    break;
                case 3 : // 사원 전체보기
                    viewEmplyoees();
                    break;
                case 4 :  // 부서별 사원 정보 조회
                    new DeptList();
                    break;
                case 5 :  // 사원 삭제
                    new DelEmplyoees();
                    break;
                case 6 : // 부서별 사원 정보 txt파일로 추출
                    new FileManager();
                    break;
                case 7 :
                    System.out.println("프로그램 종료합니다");
                    flag = false;
                    break;
                default :
                    System.out.println("입력한 번호는 없습니다. 다시 입력하세요");
            }
        }
    }

    private void viewEmplyoees() {
        System.out.println("사원 전체 보기 메뉴 입니다");
        for (Integer key : employessList.keySet()) {
            fn.prtEmployees(employessList.get(key));
        }
    }

    public static HashMap<Integer, Employees> getEmployessList() {
        return employessList;
    }

    public static void setEmployessList(Integer num, Employees em) {
        employessList.put(num,em);
    }

    public static String[] getDeptName() {
        return deptName;
    }

    public static String[] getJobTitle() {
        return jobTitle;
    }
    private void info(){
        System.out.println("------------------------------------------");
        System.out.println("사원 관리 프로그램입니다");
        System.out.println("1. 사원 추가");
        System.out.println("2. 사원 수정");
        System.out.println("3. 사원 전체보기");
        System.out.println("4. 부서별 사원 정보 조회");
        System.out.println("5. 사원 삭제");
        System.out.println("6. 부서 별 사원 정보 추출");
        System.out.println("7. 프로그램 종료");
    }
}
