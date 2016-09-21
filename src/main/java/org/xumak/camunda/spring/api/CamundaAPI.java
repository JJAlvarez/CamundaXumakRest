package org.xumak.camunda.spring.api;

import org.xumak.camunda.spring.bean.CamundaUser;
import org.xumak.camunda.spring.bean.Group;
import org.xumak.camunda.spring.bean.Task;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */
public interface CamundaAPI {

    String API = "http://localhost:8080";
    String CAMUNDA_REST_PUBLIC_API = "/engine-rest/";

    @GET(CAMUNDA_REST_PUBLIC_API + "user/")
    Call<List<CamundaUser>> getAllCamundaUsers();

    @GET(CAMUNDA_REST_PUBLIC_API + "task/")
    Call<List<Task>> getAllTasks();

    @GET(CAMUNDA_REST_PUBLIC_API + "group/")
    Call<List<Group>> getAllGroups();
}
