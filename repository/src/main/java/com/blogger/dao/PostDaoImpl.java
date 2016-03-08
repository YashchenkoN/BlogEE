package com.blogger.dao;

import com.blogger.MainDao;
import com.blogger.entity.Post;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class PostDaoImpl implements PostDao {

    @Inject
    private MainDao mainDao;

    @Override
    public Post create(Post post) {
        mainDao.create(post);
        return post;
    }

    @Override
    public Post read(Long id) {
        return mainDao.read(Post.class, id);
    }

    @Override
    public Post update(Post post) {
        return mainDao.update(post);
    }

    @Override
    public void delete(Post post) {
        mainDao.delete(post);
    }
}
