package DTO;

public class BookDTO {
    private String book = null;
    private String author = null;
    private int rec = 0;

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
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

    public void bookPrt() {
        System.out.println("책이름 : " + this.book + "\n저자 :" + this.author);
    }
}
