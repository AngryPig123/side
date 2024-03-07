package org.spring.oauth2.email_validate_register.roleauth.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.spring.oauth2.email_validate_register.entity.BaseEntity;
import org.spring.oauth2.email_validate_register.roleauth.dto.req.RoleAuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.etc.RoleAuthorityId;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Getter
@Table(name = "role_auth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleAuthority extends BaseEntity {

    @EmbeddedId
    private RoleAuthorityId id;

    @MapsId("roleId")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "role_id")
    private Roles roleId;

    @MapsId("authorityId")
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "authority_id")
    private Authority authorityId;

    public RoleAuthority(RoleAuthorityId id, Roles roleId, Authority authorityId) {
        this.id = id;
        this.roleId = roleId;
        this.authorityId = authorityId;
    }

    public RoleAuthorityDto.ConvertName toDto() {
        return new RoleAuthorityDto.ConvertName(roleId.getRoleName(), authorityId.getAuthorityName());
    }

}
