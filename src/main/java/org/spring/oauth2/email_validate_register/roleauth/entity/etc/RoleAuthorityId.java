package org.spring.oauth2.email_validate_register.roleauth.entity.etc;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spring.oauth2.email_validate_register.roleauth.entity.RoleAuthority;

import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class RoleAuthorityId implements Serializable {

    private Long roleId;
    private Long authorityId;

}
