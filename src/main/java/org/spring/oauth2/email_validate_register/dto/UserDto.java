package org.spring.oauth2.email_validate_register.dto;

import lombok.*;
import org.spring.oauth2.email_validate_register.entity.User;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private String userEmail;
    private String password;

    @Builder
    public UserDto(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public User toEntity() {
        return new User(userEmail, password);
    }
}
