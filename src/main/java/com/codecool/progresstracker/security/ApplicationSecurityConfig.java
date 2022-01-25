package com.codecool.progresstracker.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import static com.codecool.progresstracker.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "logo.svg", "logo-for-progress-tracker.png", "/static/**").permitAll()
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .antMatchers("/owner/**").hasRole(OWNER.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout();

    }

}
