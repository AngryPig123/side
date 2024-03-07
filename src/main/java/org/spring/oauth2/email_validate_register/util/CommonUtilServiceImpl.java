package org.spring.oauth2.email_validate_register.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.gateway.RandomUserGateway;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;
import org.spring.oauth2.email_validate_register.repository.AuthorityRepository;
import org.spring.oauth2.email_validate_register.repository.RolesRepository;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.spring.oauth2.email_validate_register.roleauth.dto.AuthorityDto;
import org.spring.oauth2.email_validate_register.roleauth.dto.RolesDto;
import org.spring.oauth2.email_validate_register.roleauth.entity.Authority;
import org.spring.oauth2.email_validate_register.roleauth.entity.Roles;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
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
        List<Roles> roles = rolesRepository.findAll();
        List<User> userList = randomUserList.stream()
                .map(RandomUserMe.Result::toUserDto)
                .map(o -> {
                    Random random = new Random();
                    return o.toEntity(roles.get(random.nextInt(roles.size())));
                })
                .collect(Collectors.toList());
        userRepository.saveAll(userList);
        return userList;
    }

    @Override
    public List<RolesDto> insertRole(List<String> str) {
        for (String roleName : str) {
            rolesRepository.save(new Roles(roleName));
        }

        List<Roles> roleList = rolesRepository.findAll();
        List<RolesDto> result = roleList.stream().map(Roles::toDto).toList();
        log.info("roleList = {}", result);
        return result;
    }

    @Override
    public List<AuthorityDto> insertAuthority(List<AuthorityDto> authorityDtoList) {
        List<Authority> authorities = authorityDtoList.stream().map(AuthorityDto::toEntity).collect(Collectors.toList());
        log.info("authorities = {}", authorities);
        authorityRepository.saveAll(authorities);
        return authorityDtoList;
    }

}
