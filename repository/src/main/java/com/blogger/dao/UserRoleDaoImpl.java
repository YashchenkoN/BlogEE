package com.blogger.dao;

import com.blogger.MainDao;
import com.blogger.entity.UserRole;
import com.blogger.entity.UserRoleEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserRoleDaoImpl implements UserRoleDao {

    @Inject
    private MainDao mainDao;

    @Override
    public UserRoleEntity read(UserRole userRole) {
        return mainDao.read(UserRoleEntity.class, userRole);
    }
}
