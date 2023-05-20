package com.khoa.examportal.Service.Impl;

import com.khoa.examportal.Repository.UserRepository;
import com.khoa.examportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
