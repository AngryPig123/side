package org.spring.oauth2.email_validate_register.config.security.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.oauth2.email_validate_register.user.entity.User;
import org.spring.oauth2.email_validate_register.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "%s user not found";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User notFoundUser = userRepository.findUserByUserEmail(userEmail).orElseThrow(() -> new UsernameNotFoundException(
                String.format(USER_NOT_FOUND, userEmail)
        ));

        log.info("custom user details service");
        log.info("notFoundUser = {}", notFoundUser);

        return notFoundUser;


    }

}
