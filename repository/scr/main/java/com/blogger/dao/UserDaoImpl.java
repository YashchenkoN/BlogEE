package com.blogger.dao;

import com.blogger.MainDao;
import com.blogger.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by kolyan on 31.01.16.
 */
@Stateless
public class UserDaoImpl implements UserDao {

    @Inject
    private MainDao mainDao;

    @Override
    public User create(User user) {
        mainDao.create(user);
        return user;
    }

    @Override
    public User read(Long id) {
        return mainDao.read(User.class, id);
    }

    @Override
    public User update(User user) {
        return mainDao.update(user);
    }

    @Override
    public void delete(User user) {
        mainDao.delete(user);
    }
}
