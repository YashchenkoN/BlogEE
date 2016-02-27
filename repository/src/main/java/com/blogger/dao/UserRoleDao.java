package com.blogger.dao;

import com.blogger.entity.UserRole;
import com.blogger.entity.UserRoleEntity;

/**
 * @author Nikolay Yashchenko
 */
public interface UserRoleDao {
    UserRoleEntity read(UserRole userRole);
}
