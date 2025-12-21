package DTO;

public class ReviewDTO {
    private int rnum = 0;
    private String book = null;
    private String rtext = null;
    private int rec = 0;
    private String id = null;

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    public int getRec() {
        return rec;
    }

    public boolean setRec(int rec) {
        if ( rec == 0 || rec == 1 ) {
            this.rec = rec;
            return true;
        }
        else System.out.println("추천은 1, 비추천은 0만 입력해주세요");
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
