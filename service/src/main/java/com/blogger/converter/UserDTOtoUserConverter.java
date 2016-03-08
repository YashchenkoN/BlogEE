package com.blogger.converter;

import com.blogger.dto.UserDTO;
import com.blogger.entity.User;

import javax.ejb.Stateless;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserDTOtoUserConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(UserDTO object) {
        User user = new User();
        user.setEmail(object.getEmail());
        user.setPassword(object.getPassword());
        return user;
    }
}
