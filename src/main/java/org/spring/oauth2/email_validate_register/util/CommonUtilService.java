package org.spring.oauth2.email_validate_register.util;

import org.spring.oauth2.email_validate_register.roleauth.dto.AuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.dto.RolesDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;

import java.util.List;

public interface CommonUtilService {
    RandomUserMe getRandomUser();

    List<User> insertRandomUser(int size);

    List<RolesDto> insertRole(List<String> str);

    List<AuthorityDto> insertAuthority(List<AuthorityDto> authorityDtoList);
}
