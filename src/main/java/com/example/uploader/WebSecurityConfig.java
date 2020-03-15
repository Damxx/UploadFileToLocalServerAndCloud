package com.example.uploader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceSimple userDetailsServiceSimple;

    //Zdeifniuje kto moze sie dostac do endpoinotow
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceSimple);

    }

    //zdefinuje endPointy
    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                .authorizeRequests()
                    .antMatchers("/", "/home", "/js/**", "/css/**").permitAll()
                    .antMatchers("/test1").hasRole("USER")
                    .antMatchers("/test2").hasRole("ADMIN")
                    .antMatchers("/uploadImage").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                 .and()
                 .csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
