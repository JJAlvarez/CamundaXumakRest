package org.xumak.camunda.spring.dao;

import org.springframework.stereotype.Repository;
import org.xumak.camunda.spring.bean.User;
import org.xumak.camunda.spring.constants.Constants;

import java.util.List;

/**
 * Created by xumak on 14/09/16.
 */

@Repository("userDao")
public class UserDaoImplementation extends AbstractDao<String, User> implements UserDao {

    public User findById(String id) {
        User user = getByKey(id);
        return user;
    }

    public void save(User user) {
        persist(user);
    }

    public void delete(User user) {
        delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery(Constants.ALL_USERS_QUERY)
                .getResultList();
        return users;
    }
}
