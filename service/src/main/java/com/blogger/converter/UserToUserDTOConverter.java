package com.blogger.converter;

import com.blogger.dto.UserDTO;
import com.blogger.entity.User;

import javax.ejb.Stateless;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserToUserDTOConverter implements Converter<User, UserDTO> {

    @Override
    public UserDTO convert(User object) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(object.getEmail());
        return userDTO;
    }
}
