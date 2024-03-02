package org.spring.oauth2.email_validate_register.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.dto.UserDto;
import org.spring.oauth2.email_validate_register.entity.User;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUserByUserEmail(String userEmail) {
        return userRepository.findUserByUserEmail(userEmail).orElse(null);
    }

    @Override
    public boolean saveUser(UserDto userDto) {
        try {
            User save = userRepository.save(userDto.toEntity());
            log.info("save = {}", save);
            return true;
        } catch (Exception e) {
            log.error("error = ", e);
            return false;
        }
    }

}
