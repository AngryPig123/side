package org.spring.oauth2.email_validate_register.repository;

import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findRolesByRoleName(String roleName);

}
