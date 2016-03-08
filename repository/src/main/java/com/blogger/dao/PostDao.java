package com.blogger.dao;

import com.blogger.entity.Post;

/**
 * @author Nikolay Yashchenko
 */
public interface PostDao {
    Post create(Post post);
    Post read(Long id);
    Post update(Post post);
    void delete(Post post);
}
