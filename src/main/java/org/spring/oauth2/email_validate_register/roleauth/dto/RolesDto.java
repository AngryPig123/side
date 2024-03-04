package org.spring.oauth2.email_validate_register.roleauth.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RolesDto {
    private String roleName;
    public RolesDto(String roleName) {
        this.roleName = roleName;
    }
}
