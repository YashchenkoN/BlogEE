package com.blogger.service;

import com.blogger.common.OrderHelper;
import com.blogger.dao.PostDao;
import com.blogger.entity.Post;
import org.hibernate.criterion.Order;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class PostServiceImpl implements PostService {

    @Inject
    private PostDao postDao;

    @Inject
    private OrderHelper orderHelper;

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

    @Override
    public List<Post> getByParameters(int offset, int stepSize, String sort, Long userId) {
        Order order = orderHelper.getOrder(sort);
        if(userId != null && userId > 0L) {
            return postDao.getByParameters(offset, stepSize, order, userId);
        }
        return postDao.getByParameters(offset, stepSize, order);
    }
}
