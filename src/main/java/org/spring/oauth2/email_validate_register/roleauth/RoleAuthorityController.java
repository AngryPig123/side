package org.spring.oauth2.email_validate_register.roleauth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.roleauth.dto.req.RoleAuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.service.RoleAuthorityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/role-authority")
public class RoleAuthorityController {

    private final RoleAuthorityService roleAuthorityService;

    @PostMapping(path = "/establish")
    public ResponseEntity<List<RoleAuthorityDto>> givePermissionToAUser(
            @RequestBody List<RoleAuthorityDto> roleAuthorityDtoList
    ) {
        List<RoleAuthorityDto> roleAuthorityDtos = roleAuthorityService.insertRoleAuthority(roleAuthorityDtoList);
        log.info("roleAuthorityDtos = {}", roleAuthorityDtos);
        return new ResponseEntity<>(roleAuthorityDtos, HttpStatus.OK);
    }

}
