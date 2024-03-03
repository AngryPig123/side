package org.spring.oauth2.email_validate_register.roleauth.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.spring.oauth2.email_validate_register.roleauth.entity.etc.RoleAuthorityId;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RoleAuthorityDto {

    private Long roleId;
    private Long authorityId;

    public RoleAuthorityDto(Long roleId, Long authorityId) {
        this.roleId = roleId;
        this.authorityId = authorityId;
    }

    public RoleAuthorityId toRoleAuthorityId() {
        return new RoleAuthorityId(roleId, authorityId);
    }

}
