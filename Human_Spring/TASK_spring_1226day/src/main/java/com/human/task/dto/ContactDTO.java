package com.human.task.dto;

import java.util.Date;

/*
    등록된 게시물을 모두 보여주며 .. 테이블의 컬럼은 글번호, 작성자, 제목, 등록일, 수정삭제 순이다.
    */
public class ContactDTO {
    private int contactNum;
    private String contactWriter;
    private String contactTitle;
    private String contactComment;
    private String contactDate;

    public String getContactComment() {
        return contactComment;
    }

    public void setContactComment(String contactComment) {
        this.contactComment = contactComment;
    }


    public int getContactNum() {
        return contactNum;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public String getContactWriter() {
        return contactWriter;
    }

    public void setContactWriter(String contactWriter) {
        this.contactWriter = contactWriter;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }
}
