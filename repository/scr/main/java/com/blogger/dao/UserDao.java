package com.blogger.dao;

import com.blogger.entity.User;

/**
 * Created by kolyan on 31.01.16.
 */
public interface UserDao {
    User create(User user);
    User read(Long id);
    User update(User user);
    void delete(User user);
}
