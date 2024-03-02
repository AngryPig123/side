package org.spring.oauth2.email_validate_register.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.dto.UserDto;
import org.spring.oauth2.email_validate_register.entity.User;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.spring.oauth2.email_validate_register.util.CommonUtilService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomRunnable implements CommandLineRunner {

    private final CommonUtilService commonUtilService;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<RandomUserMe.Result> randomUserList = getRandomUserList();
        List<User> userList = randomUserList.stream()
                .map(RandomUserMe.Result::toUserDto)
                .map(UserDto::toEntity)
                .collect(Collectors.toList());
        userRepository.saveAll(userList);
    }

    private List<RandomUserMe.Result> getRandomUserList() {
        return commonUtilService.getRandomUser().getResults();
    }

}
