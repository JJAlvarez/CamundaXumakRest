package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xumak.camunda.spring.bean.CamundaUser;
import org.xumak.camunda.spring.bean.GroupBean;
import org.xumak.camunda.spring.bean.User;
import org.xumak.camunda.spring.bean.UserBean;
import org.xumak.camunda.spring.ldap.Ldap;
import org.xumak.camunda.spring.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CamundaRestController {

    @Autowired
    private UserService userService;  //Service which will do all data retrieval/manipulation work

    /**
     * This method retrieve for all the users that exist in the database
     *
     * @return list of users in json format
     */
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * This method gets one user from the database by its id
     *
     * @param id of the user that is fetching in the database
     * @return a user in json format
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * This method retrieve for the free days that a user has available
     *
     * @param id of the user that is fetching in the database
     * @return iduser, free days, start date of the user in json
     */
    @RequestMapping(value = "/user/days/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserFreeDays(@PathVariable("id") String id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            user.setMail(null);
            user.setName(null);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * This method retrieve for the profile of an specific user in the database
     *
     * @param id of the user that is fetching in the database
     * @return user id, name, start date, mail of the user
     */
    @RequestMapping(value = "/user/profile/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserProfile(@PathVariable("id") String id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id);
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            user.setNumberOfFreeDays(0);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //-------------------Create a User--------------------------------------------------------

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        System.out.println("Creating User " + user.getName());
        if (userService.isUserExist(user.getUserId())) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser = userService.findById(id);

        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setMail(user.getMail());
        currentUser.setNumberOfFreeDays(user.getNumberOfFreeDays());
        currentUser.setStartDate(user.getStartDate());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/ldap/user/", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> getAllLdapUsers() {
        Ldap ldap = new Ldap();
        List<UserBean> users = ldap.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<UserBean>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/ldap/group/", method = RequestMethod.GET)
    public ResponseEntity<List<GroupBean>> getAllLdapGroupsNames() {
        Ldap ldap = new Ldap();
        List<GroupBean> groups = ldap.getGroupsNames();
        if (groups.isEmpty()) {
            return new ResponseEntity<List<GroupBean>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<GroupBean>>(groups, HttpStatus.OK);
    }

    @RequestMapping(value = "/ldap/user/group/{groupName}", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> getUsersOfGroup(@PathVariable("groupName") String groupName) {
        Ldap ldap = new Ldap();
        List<UserBean> users = ldap.getUsersOfGroup(groupName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<UserBean>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/ldap/user/group/no/{groupName}", method = RequestMethod.GET)
    public ResponseEntity<List<UserBean>> getUsersOfOtherGroup(@PathVariable("groupName") String groupName) {
        Ldap ldap = new Ldap();
        List<UserBean> users = ldap.getUsersOfOtherGroup(groupName);
        if (users.isEmpty()) {
            return new ResponseEntity<List<UserBean>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserBean>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/camunda/user/", method = RequestMethod.GET)
    public ResponseEntity<List<CamundaUser>> getAllCamundaUsers() throws IOException {
        List<CamundaUser> users = userService.getAllCamundaUsers();
        if (users == null) {
            return new ResponseEntity<List<CamundaUser>>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<List<CamundaUser>>(users, HttpStatus.OK);
        }
    }

}