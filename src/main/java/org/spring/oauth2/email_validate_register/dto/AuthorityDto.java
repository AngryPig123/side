package org.spring.oauth2.email_validate_register.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.spring.oauth2.email_validate_register.entity.Authority;

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
