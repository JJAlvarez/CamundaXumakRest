package org.xumak.camunda.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.Task;
import org.xumak.camunda.spring.constants.Constants;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    private CamundaAPI api;

    public TaskServiceImpl(){
        this.api = Constants.api;
    }

    public List<Task> getAllTasks() throws IOException {
        List<Task> tasks;
        Response<List<Task>> response = api.getAllTasks().execute();
        if(response.isSuccessful()) {
            tasks = response.body();
            return tasks;
        } else {
            return null;
        }
    }

    public CamundaAPI getApi() {
        return this.api;
    }
}
