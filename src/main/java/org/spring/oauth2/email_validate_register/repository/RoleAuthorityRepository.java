package org.spring.oauth2.email_validate_register.repository;

import org.spring.oauth2.email_validate_register.roleauth.entity.RoleAuthority;
import org.spring.oauth2.email_validate_register.roleauth.entity.etc.RoleAuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleAuthorityRepository extends JpaRepository<RoleAuthority, RoleAuthorityId> {
}
