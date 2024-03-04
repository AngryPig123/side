package org.spring.oauth2.email_validate_register.user;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "유저 권한 컨트롤러", description = "유저와 권한에 대한 요청을 처리하는 컨트롤러")
public class UserController {

    private final UserService userService;


    @Operation(summary = "유저 역할 부여", description = "유저에게 역할을 부여하는 컨트롤러")
    @ApiResponse(responseCode = "200", description = "success")
    @PostMapping(path = "/give-permission")
    public ResponseEntity<UserDto> givePermissionToAUser(@RequestBody UserDto.GivePermission givePermission) {
        UserDto userDto = userService.givePermissionToAUser(givePermission);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
