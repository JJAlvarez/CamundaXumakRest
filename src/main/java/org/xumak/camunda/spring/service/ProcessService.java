package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.bean.Process;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface ProcessService {

    void createProcess(Process process);
    List<Process> getAllProcess();
    Process findById(int id);

}
