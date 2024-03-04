package org.spring.oauth2.email_validate_register.email;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "이메일 발송 컨트롤러", description = "사용자에게 이메일을 발송하는 컨트롤러")
public class EmailController {

    private final EmailSenderService emailSenderService;


    @Operation(summary = "이메일 발송 테스트", description = "유저에게 이메일을 발송한다")
    @ApiResponse(responseCode = "200", description = "success")
    @PostMapping(path = "/test")
    public ResponseEntity<Boolean> emailSendTest(
            @RequestBody EmailSendDto emailSendDto
    ) {
        boolean b = emailSenderService.sendEmailTest(emailSendDto);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }
}
