package com.khoa.examportal.service;

import com.khoa.examportal.model.User;
import com.khoa.examportal.model.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    //get user by username
    public User getUser(String user);
    //delete user by id
    public void deleteUser(Long userId);
}
