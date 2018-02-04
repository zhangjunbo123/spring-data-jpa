package com.boge.springdatajpa.demo.model.dao;

import com.boge.springdatajpa.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor {

    // 接口规范方法名查询
    List<User> findByNameLike(String name);

    // 接口规范方法名查询
    User findByNameAndTel(String name, String tel);

    //使用JPA的NamedQueries
    List<User> findById(Integer id);

    //模糊查询：http://blog.csdn.net/zhouyingge1104/article/details/50596360g
    //nativeQuery = true,使用原生的sql语句
    @Query(value = "select * from User where password like ?1", nativeQuery = true)
    List<User> findByPassword(String pass);

    @Query(value = "select * from User where user_name like ?1", nativeQuery = true)
    List<User> findByUserName(String userName);

    /*@Query(value = "select u from User u where u.password like ?1")
    List<User> findByPassword(String pass);*/

    // 命名化参数
    @Query(value = "select u from User u where u.password like :pass")
    List<User> findUsersByPassword(@Param("pass") String pass);

    @Query(value = "update User u set u.tel = ?2 where u.id = ?1")
    @Modifying(clearAutomatically = true) // https://www.cnblogs.com/xjz1842/p/7217393.html
    @Transactional // 更新语句如果不加这个会报事务异常
    int updateUser(Integer id, String tel);

}
