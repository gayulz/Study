package boardDTO;

import boardDAO.BoardDAO;

public class BoardDTO {
    // 게시 글의 정의
    // 제목
    private String titles = null;

    // 내용
    private String content = null;

    // 작성자
    private String author = null;

    //비밀번호
    private String password = null;

    // 비밀글 여부
    private int checkSecret = 0;

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public boolean setAuthor(String author) {
        if(BoardDAO.isAuthorCnt(author)) {
            this.author = author;
            return true;
        }
        else System.out.println("작성자 별 게시글 작성은 최대 2번까지 입니다");
        return false;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCheckSecret() {
        return checkSecret;
    }

    // 0 이면 전체보기 1 이면 비밀글
    public boolean setCheckSecret(int checkSecret) {
        if ( checkSecret == 1 || checkSecret == 0 ) {
            this.checkSecret = checkSecret;
            return true;
        }
        else System.out.println("번호 오류 처음부터 다시 입력합니다");
        return false;
    }
}
