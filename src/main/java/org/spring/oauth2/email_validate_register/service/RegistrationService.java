package org.spring.oauth2.email_validate_register.service;

import org.spring.oauth2.email_validate_register.user.dto.UserDto;

public interface RegistrationService {

    public String register(UserDto userDto);

}
