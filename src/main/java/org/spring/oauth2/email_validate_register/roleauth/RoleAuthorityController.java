package org.spring.oauth2.email_validate_register.roleauth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "역할(롤)과 권한 컨트롤러", description = "역할(롤)과 권한에 대한 요청을 처리한다.")
public class RoleAuthorityController {

    private final RoleAuthorityService roleAuthorityService;


    @Operation(summary = "역할(롤)에 권한을 매핑", description = "역할(롤)에 권한을 집어넣는 api")
    @ApiResponse(responseCode = "200", description = "success")
    @PostMapping(path = "/establish")
    public ResponseEntity<List<RoleAuthorityDto.ConvertName>> givePermissionToAUser(
            @RequestBody List<RoleAuthorityDto> roleAuthorityDtoList
    ) {
        List<RoleAuthorityDto.ConvertName> result = roleAuthorityService.insertRoleAuthority(roleAuthorityDtoList);
        log.info("roleAuthorityDtos = {}", result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
