package com.blogger.dao;

import com.blogger.MainDao;
import com.blogger.entity.Comment;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class CommentDaoImpl implements CommentDao {

    @Inject
    private MainDao mainDao;

    @Override
    public Comment create(Comment comment) {
        mainDao.create(comment);
        return comment;
    }

    @Override
    public Comment read(Long id) {
        return mainDao.read(Comment.class, id);
    }

    @Override
    public Comment update(Comment comment) {
        return mainDao.update(comment);
    }

    @Override
    public void delete(Comment comment) {
        mainDao.delete(comment);
    }
}
