package org.spring.oauth2.email_validate_register.entity.etc;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class RoleAuthorityId implements Serializable {

    private Long roleId;
    private Long authorityId;

}
