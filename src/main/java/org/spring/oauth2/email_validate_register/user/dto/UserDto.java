package org.spring.oauth2.email_validate_register.user.dto;

import lombok.*;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.user.entity.User;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {

    private String userEmail;
    private String password;
    private String roleName;

    @Builder
    public UserDto(String userEmail, String password, String roleName) {
        this.userEmail = userEmail;
        this.password = password;
        this.roleName = roleName;
    }

    public User toEntity(Roles roles) {
        return new User(userEmail, password, roles);
    }

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class GivePermission {
        private String userEmail;
        private String roleName;
    }

}
