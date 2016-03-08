package com.blogger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nikolay Yashchenko
 */
public class UserDTO {

    @NotNull(message = "cannot be empty")
    @Size(min = 4, max = 15, message = "length incorrect")
    private String email;

    @NotNull(message = "cannot be empty")
    @Size(min = 5, max = 20, message = "length incorrect")
    private String password;

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
