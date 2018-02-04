package com.boge.springdatajpa.demo.service;

import com.boge.springdatajpa.demo.model.dao.UserDao;
import com.boge.springdatajpa.demo.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserDao userDao;

    public User getUser(Integer id) {
        return userDao.findOne(id);
    }

    /**
     * 无条件按页获取数据
     *
     * @param page
     * @param size
     * @return
     */
    public Page<User> getUsersForPage(Integer page, Integer size) {
        Pageable pageable = new PageRequest(page - 1, size, Sort.Direction.ASC, "id");
        Page<User> userPage = userDao.findAll(pageable);
        return userPage;
    }

    /**
     * 根据条件按页获取数据
     *
     * @param page
     * @param size
     * @param user
     * @return
     */
    public Page<User> getUsersForPageByConditions(Integer page, Integer size, User user) {
        Pageable pageable = new PageRequest(page - 1, size, Sort.Direction.ASC, "id");
        Page<User> userPage = userDao.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (null != user.getName()) {
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), user.getName()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageable);
        return userPage;
    }

    public List<User> getUsersByName(String name) {
        return  userDao.findByNameLike(name + "%");
    }

    public User getUserByNameAndTel(String name, String tel) {
        return userDao.findByNameAndTel(name, tel);
    }

    public List<User> getUsersById(Integer id) {
        return  userDao.findById(id);
    }

    public List<User> getUsersByPassword(String password) {
        return  userDao.findByPassword(password + "%");
    }

    public List<User> getUsersByUserName(String username) {
        return  userDao.findByUserName(username);
    }

    public List<User> getUsersByPassword2(String password) {
        return  userDao.findUsersByPassword(password + "%");
    }

    public int updateUser(Integer id, String tel) {
        return userDao.updateUser(id, tel);
    }

}
