package org.spring.oauth2.email_validate_register.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.dto.EmailSendDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;


    @Override
    public boolean sendEmailTest(EmailSendDto emailSendDto) {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(emailSendDto.getToEmailAddress());
            helper.setSubject(emailSendDto.getEmailTitle());
            helper.setText(emailSendDto.getContent());
            javaMailSender.send(message);
            return true;
        } catch (MessagingException messagingException) {
            log.error("messagingException = {]", messagingException);
            return false;
        }

    }

}
