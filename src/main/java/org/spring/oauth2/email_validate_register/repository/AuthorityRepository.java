package org.spring.oauth2.email_validate_register.repository;

import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
