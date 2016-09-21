package org.xumak.camunda.spring.dao;

import org.xumak.camunda.spring.bean.User;

import java.util.List;

/**
 * Created by xumak on 14/09/16.
 */
public interface UserDao {

    User findById(String id);
    void save(User user);
    void delete(User user);
    List<User> findAllUsers();

}
