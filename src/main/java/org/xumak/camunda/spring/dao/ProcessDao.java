package org.xumak.camunda.spring.dao;

import org.xumak.camunda.spring.bean.Process;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface ProcessDao {

    List<Process> getAllProcess();
    void createProcess(Process process);
    Process findById(int id);
}
