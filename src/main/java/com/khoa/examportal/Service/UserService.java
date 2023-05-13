package com.khoa.examportal.Service;

import com.khoa.examportal.model.User;
import com.khoa.examportal.model.UserRole;

import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
