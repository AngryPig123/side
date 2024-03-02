package org.spring.oauth2.email_validate_register.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmailSendDto {

    private String toEmailAddress;
    private String emailTitle;
    private String content;
    private LocalDateTime sendDate;

    @Builder
    public EmailSendDto(String toEmailAddress, String emailTitle, String content, LocalDateTime sendDate) {
        this.toEmailAddress = toEmailAddress;
        this.emailTitle = emailTitle;
        this.content = content;
        this.sendDate = sendDate;
    }

}
