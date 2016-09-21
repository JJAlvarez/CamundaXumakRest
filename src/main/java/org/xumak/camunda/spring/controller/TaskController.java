package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xumak.camunda.spring.bean.Task;
import org.xumak.camunda.spring.service.TaskService;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/camunda/task/", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllTasks() throws IOException {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks == null) {
            return new ResponseEntity<List<Task>>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
        }
    }
}
