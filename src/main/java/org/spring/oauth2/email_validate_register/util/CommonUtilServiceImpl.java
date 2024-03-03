package org.spring.oauth2.email_validate_register.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.roleauth.dto.AuthorityDto;
import org.spring.oauth2.email_validate_register.user.dto.UserDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.spring.oauth2.email_validate_register.gateway.RandomUserGateway;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;
import org.spring.oauth2.email_validate_register.repository.AuthorityRepository;
import org.spring.oauth2.email_validate_register.repository.RolesRepository;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class CommonUtilServiceImpl implements CommonUtilService {

    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;
    private final AuthorityRepository authorityRepository;
    private final RandomUserGateway randomUserGateway;

    @Override
    public RandomUserMe getRandomUser() {
        RandomUserMe randomUserMe = randomUserGateway.makeRandomUser(10);
        log.info("randomUserMe = {}", randomUserMe);
        log.info("random user me size = {}", randomUserMe.getResults().size());
        return randomUserMe;
    }

    @Override
    public List<User> insertRandomUser(int size) {
        List<RandomUserMe.Result> randomUserList = randomUserGateway.makeRandomUser(size).getResults();
        List<User> userList = randomUserList.stream()
                .map(RandomUserMe.Result::toUserDto)
                .map(UserDto::toEntity)
                .collect(Collectors.toList());
        userRepository.saveAll(userList);
        return userList;
    }

    @Override
    public List<Roles> insertRole(List<String> str) {
        for (String roleName : str) {
            rolesRepository.save(new Roles(roleName));
        }

        List<Roles> roleList = rolesRepository.findAll();
        log.info("roleList = {}", roleList);
        return roleList;
    }

    @Override
    public List<Authority> insertAuthority(List<AuthorityDto> authorityDtoList) {
        List<Authority> authorities = authorityDtoList.stream().map(AuthorityDto::toEntity).collect(Collectors.toList());
        log.info("authorities = {}", authorities);
        return authorityRepository.saveAll(authorities);
    }

}
