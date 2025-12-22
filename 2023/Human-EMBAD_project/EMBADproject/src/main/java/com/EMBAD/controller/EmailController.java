package com.EMBAD.controller;
import com.EMBAD.service.EmailSendService;
import com.EMBAD.vo.EmailVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

// todo : 이메일 발송 컨트롤러
@Controller
public class EmailController {

    @Inject
    private EmailSendService emailService;

    /**
     * 이메일 발송 메서드
     * @param : {@link EmailVO} 사용자 이름 , 이메일주소 , 랜덤 인증번호
     * @return : boolean 발송 성공 여부 */
    @CrossOrigin
    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> sendEmail(@RequestBody EmailVO emailVO){
        try{
            // 이메일 발송 서비스단으로 전달
            emailService.sendEmailService(emailVO);
            return ResponseEntity.ok("true");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("false");
        }
    }

    /**
     * 등록된 이메일 중복여부 체크 메서드
     * @param : String 사용자가 입력한 email주소가 들어옴
     * @return : boolean 중복 여부 반환
     * */
    @GetMapping(value="/emailDuplication")
    public ResponseEntity<?> emailDuplications(@RequestParam String email){
        Boolean isDuplicated = emailService.checkEmailDuplication(email);
        return ResponseEntity.ok().body("{\"isDuplicated\":" + isDuplicated + "}");
    }
}
