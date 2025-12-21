package member;

// 멤버 인스턴스를 만들기 위한 정의
public class MemberDefine {
    private String id = null;
    private String pass = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public MemberDefine(){}

    public void prt(){
        System.out.println(" ID : " + id);
        System.out.println("PASS: " + pass);
    }
}
