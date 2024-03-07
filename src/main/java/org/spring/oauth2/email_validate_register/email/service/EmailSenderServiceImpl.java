package org.spring.oauth2.email_validate_register.email.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.email.dto.EmailSendDto;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Override
    public boolean sendEmailTest(EmailSendDto emailSendDto) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, false);
            helper.setTo(emailSendDto.getToEmailAddress());
            helper.setSubject(emailSendDto.getEmailTitle());
            Context context = new Context();
            context.setVariable("title", emailSendDto.getEmailTitle());
            context.setVariable("email", emailSendDto.getToEmailAddress());
            String htmlContent = templateEngine.process("/email/greeting", context);
            helper.setText(htmlContent, true);
            javaMailSender.send(message);
            return true;
        } catch (MessagingException messagingException) {
            return false;
        }
    }

}
