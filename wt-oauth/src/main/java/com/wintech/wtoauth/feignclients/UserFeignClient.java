package com.wintech.wtoauth.feignclients;

import com.wintech.wtoauth.domains.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "wt-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/{username}")
    ResponseEntity<User> findByUsername(@RequestParam String username);
}
