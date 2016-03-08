package com.blogger.converter;

import com.blogger.dto.UserDTO;
import com.blogger.entity.User;
import com.blogger.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserDTOtoUserConverter implements Converter<UserDTO, User> {

    @Inject
    private UserService userService;

    @Override
    public User convert(UserDTO object) {
        User user = userService.read(object.getUserId());
        if(user == null) {
            user = new User();
            user.setRegistrationDate(LocalDate.now());
        }
        user.setEmail(object.getEmail());
        user.setPassword(object.getPassword());
        return user;
    }
}
