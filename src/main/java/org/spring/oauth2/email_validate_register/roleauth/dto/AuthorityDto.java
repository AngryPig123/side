package org.spring.oauth2.email_validate_register.roleauth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthorityDto {
    private String authorityName;
    private String endPoint;

    public Authority toEntity() {
        return Authority.builder()
                .authorityName(authorityName)
                .endPoint(endPoint)
                .build();
    }

}
