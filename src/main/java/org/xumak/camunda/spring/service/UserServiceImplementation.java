package org.xumak.camunda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.CamundaUser;
import org.xumak.camunda.spring.bean.User;
import org.xumak.camunda.spring.constants.Constants;
import org.xumak.camunda.spring.dao.UserDao;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 14/09/16.
 */
@Service("userService")
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDao dao;
    private CamundaAPI api;

    public UserServiceImplementation() {
        this.api = Constants.api;
    }

    public User findById(String id) {
        return dao.findById(id);
    }

    public void saveUser(User user) {
        dao.save(user);
    }

    public void updateUser(User user) {
        User entity = dao.findById(user.getUserId());
        if (entity != null) {
            entity.setName(user.getName());
            entity.setMail(user.getMail());
            entity.setNumberOfFreeDays(user.getNumberOfFreeDays());
            entity.setStartDate(user.getStartDate());
        }
    }

    public void deleteUserById(String id) {
        User user = dao.findById(id);
        dao.delete(user);
    }

    public List<User> getAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUserExist(String id) {
        return findById(id) != null;
    }


    public CamundaAPI getApi() {
        return this.api;
    }

    public List<CamundaUser> getAllCamundaUsers() throws IOException {
        List<CamundaUser> users;
        Response<List<CamundaUser>> response = getApi().getAllCamundaUsers().execute();
        if (response.isSuccessful()) {
            users = response.body();
            return users;
        } else {
            return null;
        }
    }
}
