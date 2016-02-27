package com.blogger.service;

import com.blogger.dao.UserDao;
import com.blogger.entity.User;
import com.blogger.entity.UserRole;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private PasswordService passwordService;

    @Inject
    private UserRoleService userRoleService;

    @Override
    public User create(User user) {
        user.setPassword(passwordService.encode(user.getPassword()));
        user.setRole(userRoleService.read(UserRole.UNACTIVE));
        return userDao.create(user);
    }

    @Override
    public User read(Long id) {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getUsers(int offset, int stepSize) {
        return userDao.getUsers(offset, stepSize);
    }
}
