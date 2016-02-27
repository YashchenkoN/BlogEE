package com.blogger.service;

import com.blogger.entity.User;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
public interface UserService {
    User create(User user);
    User read(Long id);
    User update(User user);
    void delete(User user);
    List<User> getUsers(int offset, int stepSize);
}
