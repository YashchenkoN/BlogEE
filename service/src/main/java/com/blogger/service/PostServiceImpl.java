package com.blogger.service;

import com.blogger.dao.PostDao;
import com.blogger.entity.Post;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class PostServiceImpl implements PostService {

    @Inject
    private PostDao postDao;

    @Override
    public Post create(Post post) {
        return postDao.create(post);
    }

    @Override
    public Post read(Long id) {
        return postDao.read(id);
    }

    @Override
    public Post update(Post post) {
        return postDao.update(post);
    }

    @Override
    public void delete(Post post) {
        postDao.delete(post);
    }
}
