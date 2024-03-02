package org.spring.oauth2.email_validate_register.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;


@Entity
@Getter
@Table(name = "role_auth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoleAuthority {

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

}
