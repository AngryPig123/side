package org.spring.oauth2.email_validate_register.email;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.email.dto.EmailSendDto;
import org.spring.oauth2.email_validate_register.email.service.EmailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/email")
public class EmailController {

    private final EmailSenderService emailSenderService;

    @PostMapping(path = "/test")
    public ResponseEntity<Boolean> emailSendTest(
            @RequestBody EmailSendDto emailSendDto
    ) {
        boolean b = emailSenderService.sendEmailTest(emailSendDto);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
