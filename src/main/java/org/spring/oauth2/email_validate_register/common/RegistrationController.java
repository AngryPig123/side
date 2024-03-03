package org.spring.oauth2.email_validate_register.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping(path ="/registration")
    public String register(@RequestBody UserDto userDto) {
        return registrationService.register(userDto);
    }

}
