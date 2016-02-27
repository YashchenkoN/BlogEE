package com.blogger.dao;

import com.blogger.entity.User;

import java.util.List;

/**
 * @author kolyan
 * @since 1.0
 */
public interface UserDao {
    User create(User user);
    User read(Long id);
    User update(User user);
    void delete(User user);
    List<User> getUsers(int offset, int stepSize);
}
