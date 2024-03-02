package org.spring.oauth2.email_validate_register.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.spring.oauth2.email_validate_register.dto.UserDto;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserMe {
    private List<Result> results;

    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        private String gender;
        private String email;
        private Name name;
        private Login login;
        private Picture picture;

        public UserDto toUserDto() {
            return UserDto.builder()
                    .userEmail(email)
                    .password(login.password)
                    .build();
        }

        @Getter
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        static class Name {
            private String title;
            private String first;
            private String last;
        }

        @Getter
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        static class Login {
            private String uuid;
            private String username;
            private String password;
        }

        @Getter
        @ToString
        @NoArgsConstructor
        @AllArgsConstructor
        static class Picture {
            private String large;
            private String medium;
            private String thumbnail;
        }

    }
}

