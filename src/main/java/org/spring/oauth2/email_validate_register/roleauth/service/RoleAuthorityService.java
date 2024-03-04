package org.spring.oauth2.email_validate_register.roleauth.service;

import org.spring.oauth2.email_validate_register.roleauth.dto.req.RoleAuthorityDto;

import java.util.List;

public interface RoleAuthorityService {
    List<RoleAuthorityDto.ConvertName> insertRoleAuthority(List<RoleAuthorityDto> roleAuthorityDtoList);
}
