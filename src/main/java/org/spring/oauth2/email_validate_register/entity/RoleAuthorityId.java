package org.spring.oauth2.email_validate_register.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuthorityId implements Serializable {

    private Long roleId;
    private Long authorityId;

}
