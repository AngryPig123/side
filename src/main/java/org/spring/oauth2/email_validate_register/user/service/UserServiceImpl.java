package org.spring.oauth2.email_validate_register.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.repository.RolesRepository;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    @Override
    public UserDto givePermissionToAUser(UserDto.GivePermission givePermission) {

        String userEmail = givePermission.getUserEmail();
        String roleName = givePermission.getRoleName();

        Optional<User> findUser = userRepository.findUserByUserEmail(userEmail);
        Optional<Roles> findRoles = rolesRepository.findRolesByRoleName(roleName);

        if (findUser.isPresent() && findRoles.isPresent()) {
            User user = findUser.get();
            Roles role = findRoles.get();
            user.setRoles(role);
            User result = userRepository.save(user);
            log.info("result = {}", result);
            return result.toDto();
        } else {
            return null;    //  ToDO 예외 처리 부분을 구체화 한다.
        }

    }

}
