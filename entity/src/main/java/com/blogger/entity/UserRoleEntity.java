package com.blogger.entity;

import javax.persistence.*;

/**
 * Created by kolyan on 31.01.16.
 */
@Entity
@Table(name = "user_role")
public class UserRoleEntity {

    @Id
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
