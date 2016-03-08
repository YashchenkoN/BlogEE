package com.blogger.service;

import com.blogger.entity.Post;

/**
 * @author Nikolay Yashchenko
 */
public interface PostService {
    Post create(Post post);
    Post read(Long id);
    Post update(Post post);
    void delete(Post post);
}
