package org.spring.oauth2.email_validate_register.user;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/give-permission")
    public ResponseEntity<UserDto> givePermissionToAUser(@RequestBody UserDto.GivePermission givePermission) {
        UserDto userDto = userService.givePermissionToAUser(givePermission);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
