package com.blogger.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersResponse {
    private List<UserDTO> users;

    public UsersResponse() {}

    public UsersResponse(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
