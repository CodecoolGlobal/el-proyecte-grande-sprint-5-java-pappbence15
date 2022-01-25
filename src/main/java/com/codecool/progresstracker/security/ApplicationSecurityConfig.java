package com.codecool.progresstracker.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import static com.codecool.progresstracker.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**" , "/css/**", "/js/**", "logo.svg", "logo-for-progress-tracker.png", "/static/**").permitAll()
//                .antMatchers("/admin/**", "/owner/**", "/init").hasRole(ADMIN.name())
//                .antMatchers("/owner/**").hasRole(OWNER.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser =  User.builder()
                .username("admin")
                .password(passwordEncoder.encode("Adminpassword"))
                .roles(passwordEncoder.encode(ADMIN.name()))
                .build();

        UserDetails ownerUser =  User.builder()
                .username("owner")
                .password(passwordEncoder.encode("Ownerpassword"))
                .roles(OWNER.name())
                .build();

        return new InMemoryUserDetailsManager(adminUser, ownerUser);
    }

}
