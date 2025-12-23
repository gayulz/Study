package DTO;

public class DTO {
    private String title = null;
    private String memo = null;
    private String wr = null;
    private String pass = null;
    private int scret = 1;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getWr() {
        return wr;
    }

    public void setWr(String wr) {
        this.wr = wr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getScret() {
        return scret;
    }

    public void setScret(int scret) {
        this.scret = scret;
    }

    public void prt() {
        System.out.println("------------<info>----------");
        if (scret != 1) {
            System.out.println("제목 : " + title.substring(0, 2) + "***");
            System.out.println("비밀글입니다.");
        } else {
            System.out.println("제목 : " + title);
            System.out.println("내용 : " + memo);
            System.out.println("작성자 : " + wr);
            System.out.println("공개여부 : " + scret);
            System.out.println("비밀번호 : " + pass);
        }
    }
}

