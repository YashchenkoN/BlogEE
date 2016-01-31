package com.blogger.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by kolyan on 31.01.16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_seq",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    private Long id;

    @Column(name = "login", nullable = false)
    @Size(min = 4, max = 15)
    private String login;

    @Column(name = "password", nullable = false)
    @Size(min = 5, max = 20)
    private String password;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    private UserRoleEntity role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public void setRole(UserRoleEntity role) {
        this.role = role;
    }
}
