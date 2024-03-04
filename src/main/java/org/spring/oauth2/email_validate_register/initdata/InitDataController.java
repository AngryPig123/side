package org.spring.oauth2.email_validate_register.initdata;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.dto.RequestBodyContainer;
import org.spring.oauth2.email_validate_register.roleauth.dto.AuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.dto.RolesDto;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.spring.oauth2.email_validate_register.util.CommonUtilService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/init-data")
@Tag(name = "데이터 생성 컨트롤러", description = "유저, 역할, 역할_권한, 권한 생성 컨트롤러")
public class InitDataController {

    private final CommonUtilService commonUtilService;

    @Operation(summary = "유저 생성", description = "유저 생성 api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success")
    })
    @GetMapping(path = "/insert-users")
    public List<UserDto> insertUser(
            @Parameter(description = "생성할 유저 수") @RequestParam("size") int size
    ) {
        List<User> userList = commonUtilService.insertRandomUser(size);
        log.info("init-data controller user list = {}", userList);
        return userList.stream().map(User::toDto).collect(Collectors.toList());
    }

    @Operation(summary = "역할(롤) 생성", description = "역할(롤) api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success")
    })
    @PostMapping(path = "/insert-roles")
    public List<RolesDto> insertRoles(
            @RequestBody RequestBodyContainer<List<String>> roleNameList
    ) {
        List<RolesDto> roles = commonUtilService.insertRole(roleNameList.getData());
        log.info("init-data controller roles list = {}", roles);
        return roles;
    }


    @Operation(summary = "권한 생성", description = "권한 생성 api")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "success",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AuthorityDto.class)))
            )
    })
    @PostMapping(path = "/insert-authorities")
    public List<AuthorityDto> insertAuthority(
            @Parameter(description = "권한 리스트", array = @ArraySchema(schema = @Schema(implementation = AuthorityDto.class)))
            @RequestBody List<AuthorityDto> authorityList) {
        List<AuthorityDto> authorityDtoList = commonUtilService.insertAuthority(authorityList);
        log.info("init-data controller authorities = {}", authorityDtoList);
        return authorityDtoList;
    }


}
