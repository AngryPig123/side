package org.spring.oauth2.email_validate_register.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "random-user-gateway", url = "https://randomuser.me/api/")
public interface RandomUserGateway {

    @GetMapping
    RandomUserMe makeRandomUser();

    @GetMapping
    RandomUserMe makeRandomUser(@RequestParam("results") int result);

}
