package com.blogger.service;

import com.blogger.dao.UserRoleDao;
import com.blogger.entity.UserRole;
import com.blogger.entity.UserRoleEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserRoleServiceImpl implements UserRoleService {

    @Inject
    private UserRoleDao userRoleDao;

    @Override
    public UserRoleEntity read(UserRole userRole) {
        return userRoleDao.read(userRole);
    }
}
