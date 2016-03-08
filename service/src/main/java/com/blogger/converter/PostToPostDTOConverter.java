package com.blogger.converter;

import com.blogger.dto.PostDTO;
import com.blogger.entity.Post;

import javax.ejb.Stateless;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class PostToPostDTOConverter implements Converter<Post, PostDTO> {

    @Override
    public PostDTO convert(Post object) {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(object.getId());
        postDTO.setTitle(object.getTitle());
        postDTO.setBody(object.getBody());
        // todo add dates
        return postDTO;
    }
}
