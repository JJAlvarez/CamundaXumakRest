package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.Task;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */
public interface TaskService {

    List<Task> getAllTasks() throws IOException;
    CamundaAPI getApi();
    void claim();
    void unclaim();
    void complete();
    void submitForm();
    void resolve();
    void setAssignee();
    void getFormVariables();
}
