package com.wintech.wtoauth.services;

import com.wintech.wtoauth.domains.User;
import com.wintech.wtoauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findUser(String username){
        User user = userFeignClient.findByUsername(username).getBody();
        if(user == null){
            logger.error("Not found: " + username);
            throw new IllegalArgumentException("User " + username + " not found.");
        }
        logger.info("Found: " + username);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByUsername(username).getBody();
        if(user == null){
            logger.error("Not found: " + username);
            throw new IllegalArgumentException("User " + username + " not found.");
        }
        logger.info("Found: " + username);
        return user;
    }
}
