package org.xumak.camunda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.bean.Process;
import org.xumak.camunda.spring.dao.ProcessDao;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Service("processService")
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessDao dao;

    public void createProcess(Process process) {
        dao.createProcess(process);
    }

    public List<Process> getAllProcess() {
        return dao.getAllProcess();
    }

    public Process findById(int id) {
        return dao.findById(id);
    }
}
