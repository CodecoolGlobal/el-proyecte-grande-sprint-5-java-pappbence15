package com.codecool.progresstracker.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHandler {
    public String encodePassword(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean doPasswordsMatch(String userPassword, String checkedPassword){
        return userPassword.equals(checkedPassword);
    }
}
