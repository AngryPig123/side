package org.spring.oauth2.email_validate_register.user.service;

import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.user.entity.User;

public interface UserService {

    UserDto givePermissionToAUser(UserDto.GivePermission givePermission);

}
