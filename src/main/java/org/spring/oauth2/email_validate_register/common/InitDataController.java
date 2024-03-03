package org.spring.oauth2.email_validate_register.common;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.roleauth.dto.AuthorityDto;
import org.spring.oauth2.email_validate_register.dto.RequestBodyContainer;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.spring.oauth2.email_validate_register.util.CommonUtilService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/init-data")
public class InitDataController {

    private final CommonUtilService commonUtilService;

    @GetMapping(path = "/insert-users")
    public List<UserDto> insertUser(@RequestParam("size") int size) {
        List<User> userList = commonUtilService.insertRandomUser(size);
        log.info("init-data controller user list = {}", userList);
        return userList.stream().map(User::toDto).collect(Collectors.toList());
    }

    @PostMapping(path = "/insert-roles")
    public List<Roles> insertRoles(@RequestBody RequestBodyContainer<List<String>> roleNameList) {
        List<Roles> roles = commonUtilService.insertRole(roleNameList.getData());
        log.info("init-data controller roles list = {}", roles);
        return roles;
    }

    @PostMapping(path = "/insert-authorities")
    public List<Authority> insertAuthority(@RequestBody List<AuthorityDto> authorityList) {
        List<Authority> authorities = commonUtilService.insertAuthority(authorityList);
        log.info("init-data controller authorities = {}", authorities);
        return authorities;
    }


}
