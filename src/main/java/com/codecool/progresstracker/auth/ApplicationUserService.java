package com.codecool.progresstracker.auth;

import com.codecool.progresstracker.model.User;
import com.codecool.progresstracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public ApplicationUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
        UserDetails userDetails = new ApplicationUser(
                user.getUserType(),
                user.getPassword(),
                user.getUserName()
//                true,
//                true,
//                true,
//                true
        );//TODO save these in the db and get them from user so its not true all the time
        return userDetails;
    }
}
