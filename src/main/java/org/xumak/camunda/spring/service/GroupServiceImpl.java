package org.xumak.camunda.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.Group;
import org.xumak.camunda.spring.constants.Constants;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {

    private CamundaAPI api;

    public GroupServiceImpl() {
        this.api = Constants.api;
    }

    public CamundaAPI getApi() {
        return this.api;
    }

    public List<Group> getAllGroups() throws IOException {
        List<Group> groups;
        Response<List<Group>> response = getApi().getAllGroups().execute();
        if (response.isSuccessful()) {
            groups = response.body();
            return groups;
        } else {
            return null;
        }
    }
}
