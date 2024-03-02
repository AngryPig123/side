package org.spring.oauth2.email_validate_register;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.spring.oauth2.email_validate_register.util.CommonUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CommonUtilServiceTest {

    @Autowired
    private CommonUtilService commonUtilService;


    @Test
    void randomUser() {
        log.info("commonUtilService = {}", commonUtilService.getRandomUser());
    }

}
