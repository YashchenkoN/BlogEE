package com.blogger.dao;

import com.blogger.entity.Post;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
public interface PostDao {
    Post create(Post post);
    Post read(Long id);
    Post update(Post post);
    void delete(Post post);
    List<Post> getByParameters(int offset, int stepSize, Order order, Long userId);
    List<Post> getByParameters(int offset, int stepSize, Order order);
}
