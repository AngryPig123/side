package org.spring.oauth2.email_validate_register.service;

import org.spring.oauth2.email_validate_register.dto.UserDto;
import org.spring.oauth2.email_validate_register.entity.User;

public interface UserService {

    User findUserByUserEmail(String userEmail);

    boolean saveUser(UserDto userDto);

}
