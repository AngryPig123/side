package org.spring.oauth2.email_validate_register.service.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailSenderServiceImplTest {

    @Autowired
    private EmailSenderServiceImpl emailSenderService;


    @Test
    void emailTest() {
        boolean b = emailSenderService.sendEmailTest(null);
    }

}