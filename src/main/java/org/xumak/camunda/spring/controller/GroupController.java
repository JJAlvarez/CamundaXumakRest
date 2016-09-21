package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xumak.camunda.spring.bean.Group;
import org.xumak.camunda.spring.service.GroupService;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/camunda/group", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> getAllGroups() throws IOException {
        List<Group> groups = groupService.getAllGroups();
        if (groups == null) {
            return new ResponseEntity<List<Group>>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
        }
    }
}
