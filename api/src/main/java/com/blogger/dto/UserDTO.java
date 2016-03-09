package com.blogger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nikolay Yashchenko
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO {

    private Long userId;

    @NotNull(message = "cannot be empty")
    @Size(min = 4, max = 15, message = "length incorrect")
    private String email;

    @NotNull(message = "cannot be empty")
    @Size(min = 5, max = 20, message = "length incorrect")
    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
