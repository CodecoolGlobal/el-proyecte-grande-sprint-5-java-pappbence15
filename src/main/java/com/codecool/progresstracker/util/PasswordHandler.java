package com.codecool.progresstracker.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHandler {
    public String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
