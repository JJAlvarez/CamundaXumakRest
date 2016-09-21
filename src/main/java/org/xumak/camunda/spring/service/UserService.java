package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.CamundaUser;
import org.xumak.camunda.spring.bean.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 14/09/16.
 */
public interface UserService {

    User findById(String id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(String id);
    List<User> getAllUsers();
    boolean isUserExist(String id);
    CamundaAPI getApi();
    List<CamundaUser> getAllCamundaUsers() throws IOException;

}
