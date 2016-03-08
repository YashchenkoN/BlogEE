package com.blogger.service;

import com.blogger.entity.Post;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
public interface PostService {
    Post create(Post post);
    Post read(Long id);
    Post update(Post post);
    void delete(Post post);
    List<Post> getByParameters(int offset, int stepSize, String sort, Long userId);
}
