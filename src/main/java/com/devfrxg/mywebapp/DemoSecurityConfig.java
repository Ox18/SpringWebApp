package com.devfrxg.mywebapp;

import com.devfrxg.mywebapp.account.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountInfoService accountInfoService;

    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(accountInfoService);
    }

    @Bean
    public PasswordEncoder getPassEncoded(){
        return NoOpPasswordEncoder.getInstance();
    }

    // Authorization Setting
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();

    }
}
