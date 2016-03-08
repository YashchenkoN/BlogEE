package com.blogger.dao;

import com.blogger.entity.Comment;

/**
 * @author Nikolay Yashchenko
 */
public interface CommentDao {
    Comment create(Comment comment);
    Comment read(Long id);
    Comment update(Comment comment);
    void delete(Comment comment);
}
