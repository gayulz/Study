package TestCode;

public class Member {
    private String id = null;
    private String pass = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Member(){}

    public void prt(){
        System.out.println("ID : " + id);
        System.out.println("PASS : " + pass);
    }
}
