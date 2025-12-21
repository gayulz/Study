package employees_program.activeProgram;

public class Employees {
    // 사원 번호
    private int emNum = 0;
    // 사원 이름
    private String emName= null;
    // 사원 나이
    private int emAge= 0;
    // 근무 부서
    private String emDept = null;
    // 직위
    private String emJobTitle = null;

    public int getEmNum() {
        return emNum;
    }

    public void setEmNum(int emNum) {
        this.emNum = emNum;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public int getEmAge() {
        return emAge;
    }

    public void setEmAge(int emAge) {
        this.emAge = emAge;
    }

    public String getEmDept() {
        return emDept;
    }

    public void setEmDept(String emDept) {
        this.emDept = emDept;
    }

    public String getEmJobTitle() {
        return emJobTitle;
    }

    public void setEmJobTitle(String emJobTitle) {
        this.emJobTitle = emJobTitle;
    }
}
