package com.blogger.service;

import com.blogger.entity.UserRole;
import com.blogger.entity.UserRoleEntity;

/**
 * @author Nikolay Yashchenko
 */
public interface UserRoleService {
    UserRoleEntity read(UserRole userRole);
}
