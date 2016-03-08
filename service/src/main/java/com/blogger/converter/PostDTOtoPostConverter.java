package com.blogger.converter;

import com.blogger.dto.PostDTO;
import com.blogger.entity.Post;
import com.blogger.service.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDate;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class PostDTOtoPostConverter implements Converter<PostDTO, Post> {

    @Inject
    private PostService postService;

    @Override
    public Post convert(PostDTO object) {
        Post post = postService.read(object.getPostId());
        if (post == null) {
            post = new Post();
            post.setCreationDate(LocalDate.now());
        } else {
            post.setUpdateDate(LocalDate.now());
        }
        post.setBody(object.getBody());
        post.setTitle(object.getTitle());
        // todo comments
        return post;
    }
}
