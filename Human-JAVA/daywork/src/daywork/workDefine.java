package daywork;

public class workDefine {
// 일정에 대한 정의
    // 날짜
    private String itDate = "";
    // 일정 내용
    private String workText = "";
    // 일정 등록자
    private String userName = "";

    public workDefine(){}

    public String getItDate() {
        return itDate;
    }

    public void setItDate(String itDate) {
        this.itDate = itDate;
    }

    public String getWorkText() {
        return workText;
    }

    public void setWorkText(String workText) {
        this.workText = workText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
