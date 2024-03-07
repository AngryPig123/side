package org.spring.oauth2.email_validate_register.email.service;

import org.spring.oauth2.email_validate_register.email.dto.EmailSendDto;

public interface EmailSenderService {

    boolean sendEmailTest(EmailSendDto emailSendDto);
}
