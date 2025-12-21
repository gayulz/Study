package DTO;

public class BookJoinReviewDTO {
    private int rnum = 0;
    private String book = null;
    private String author = null;
    private String id = null;
    private String rText = null;

    public BookJoinReviewDTO(){}

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getrText() {
        return rText;
    }

    public void setrText(String rText) {
        this.rText = rText;
    }
}
