package org.spring.oauth2.email_validate_register.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.gateway.RandomUserGateway;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommonUtilServiceImpl implements CommonUtilService {

    private final RandomUserGateway randomUserGateway;

    @Override
    public RandomUserMe getRandomUser() {
        RandomUserMe randomUserMe = randomUserGateway.makeRandomUser(10);
        log.info("randomUserMe = {}", randomUserMe);
        log.info("random user me size = {}", randomUserMe.getResults().size());
        return randomUserMe;
    }

}
