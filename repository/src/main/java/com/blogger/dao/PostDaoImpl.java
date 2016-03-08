package com.blogger.dao;

import com.blogger.MainDao;
import com.blogger.entity.Post;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getByParameters(int offset, int stepSize, Order order, Long userId) {
        return getCriteriaForParameters(offset, stepSize, order)
                .createAlias("author", "a")
                .add(Restrictions.eq("a.id", userId))
                .addOrder(order)
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getByParameters(int offset, int stepSize, Order order) {
        return getCriteriaForParameters(offset, stepSize, order)
                .list();
    }

    private Criteria getCriteriaForParameters(int offset, int stepSize, Order order) {
        return mainDao.getSession().createCriteria(Post.class)
                .setFirstResult(offset * stepSize)
                .setFetchSize(stepSize);
    }
}
