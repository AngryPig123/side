package org.spring.oauth2.email_validate_register.bootstrap;

import lombok.RequiredArgsConstructor;
import org.spring.oauth2.email_validate_register.gateway.RandomUserMe;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.spring.oauth2.email_validate_register.util.CommonUtilService;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

//@Slf4j
//@Component
@RequiredArgsConstructor
public class CustomRunnable implements CommandLineRunner {

    private final CommonUtilService commonUtilService;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

/*
        List<RandomUserMe.Result> randomUserList = getRandomUserList();
        List<User> userList = randomUserList.stream()
                .map(RandomUserMe.Result::toUserDto)
                .map(UserDto::toEntity)
                .collect(Collectors.toList());
        userRepository.saveAll(userList);
*/

    }

    private List<RandomUserMe.Result> getRandomUserList() {
        return commonUtilService.getRandomUser().getResults();
    }

}
