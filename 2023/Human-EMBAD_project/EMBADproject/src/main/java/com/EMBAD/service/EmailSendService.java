package com.EMBAD.service;

import com.EMBAD.dao.StaffDaoImpl;
import com.EMBAD.vo.EmailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

@PropertySource("classpath:application.properties")
@Service
public class EmailSendService {

    @Autowired
    private JavaMailSender mailSender;
    @Inject
    private StaffDaoImpl staffDao;
    @Value("${mail.username}")
    private String toAddr;

    /**
     * 이메일 발송 실 처리 로직
     *
     * @param : {@link EmailVO} 사용자 이름 , 이메일주소 , 랜덤 인증번호
     * @return : boolean 이메일 발송 성공 여부 리턴
     */
    public boolean sendEmailService(EmailVO emailVO) {
        try {
            //EMBAD이메일 대입
            emailVO.setToAddr(toAddr);
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail, true, "UTF-8");
            // 발송자 이메일(EMBAD이메일)
            mailHelper.setFrom(emailVO.getToAddr());
            // 수신자 이메일(사용자 이메일주소)
            mailHelper.setTo(emailVO.getEmail());
            // 메일 제목
            mailHelper.setSubject(emailVO.getName() + "님 EMBAD 인증번호 메일입니다 ");
            // 메일 내용 : true(html허용)
            mailHelper.setText("인증번호 : " + emailVO.getRandomNumber(), true);
            // 메일 전송
            mailSender.send(mail);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * DB사용 이메일 중복 체크 처리 로직
     *
     * @param : 사용자 입력받은 email
     * @return : boolean 이메일 중복 여부 리턴
     */
    public boolean checkEmailDuplication(String email) {
        if (staffDao.checkEmailDuplication(email) <= 1) return false;
        return true;
    }
}