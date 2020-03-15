package com.example.uploader;

import com.example.uploader.model.AppUser;
import com.example.uploader.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceSimple implements UserDetailsService
{
    @Autowired
    private  AppUserRepo appUserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(s);
    }
        @EventListener(ApplicationReadyEvent.class)
        public void get(){
            AppUser user = new AppUser("jan",passwordEncoder.encode("nowak"),"ROLE_USER");
            AppUser admin = new AppUser("admin",passwordEncoder.encode("admin"),"ROLE_ADMIN");
            appUserRepo.save(user);
            appUserRepo.save(admin);
        }


    }

