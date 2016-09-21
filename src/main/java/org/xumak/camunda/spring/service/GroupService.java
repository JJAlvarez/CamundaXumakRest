package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.api.CamundaAPI;
import org.xumak.camunda.spring.bean.Group;

import java.io.IOException;
import java.util.List;

/**
 * Created by xumak on 21/09/16.
 */
public interface GroupService {

    CamundaAPI getApi();
    List<Group> getAllGroups() throws IOException;
}
