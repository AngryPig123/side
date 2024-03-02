package org.spring.oauth2.email_validate_register.service.email;

import org.spring.oauth2.email_validate_register.dto.EmailSendDto;

public interface EmailSenderService {

    boolean sendEmailTest(EmailSendDto emailSendDto);
}
