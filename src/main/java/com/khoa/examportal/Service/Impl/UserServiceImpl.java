package com.khoa.examportal.Service.Impl;

import com.khoa.examportal.Repository.RoleRepository;
import com.khoa.examportal.Repository.UserRepository;
import com.khoa.examportal.Service.UserService;
import com.khoa.examportal.model.User;
import com.khoa.examportal.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User are already!");
            throw new Exception("User already present!");
        } else {
            //user create
            for(UserRole ur: userRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
