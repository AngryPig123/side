package org.spring.oauth2.email_validate_register.email.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmailSendDto {

    private String toEmailAddress;
    private String emailTitle;
    private LocalDateTime sendDate;

    @Builder
    public EmailSendDto(String toEmailAddress, String emailTitle) {
        this.toEmailAddress = toEmailAddress;
        this.emailTitle = emailTitle;
        this.sendDate = LocalDateTime.now();
    }

}
