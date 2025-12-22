package com.EMBAD.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailVO {

    /*
     name = 이메일 수령받는 사람 이름
     email = 이메일 받는 사람의 이메일 주소
     randomNumber = 이메일에 발송되는 인증번호
     */
    private String toAddr;
    private String name;
    private String email;
    private String randomNumber;
}
