package org.spring.oauth2.email_validate_register.roleauth.service;

import org.spring.oauth2.email_validate_register.roleauth.dto.req.RoleAuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.etc.RoleAuthorityId;

import java.util.List;

public interface RoleAuthorityService {
    List<RoleAuthorityDto> insertRoleAuthority(List<RoleAuthorityDto> roleAuthorityDtoList);
}
