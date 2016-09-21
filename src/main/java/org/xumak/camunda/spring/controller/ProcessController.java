package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xumak.camunda.spring.bean.Process;
import org.xumak.camunda.spring.service.ProcessService;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@RestController
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @RequestMapping(value = "/process/", method = RequestMethod.GET)
    public ResponseEntity<List<Process>> getAllProcesses() {
        List<Process> processes = processService.getAllProcess();
        if (processes.isEmpty()) {
            return new ResponseEntity<List<Process>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Process>>(processes, HttpStatus.OK);
    }

    @RequestMapping(value = "/process/", method = RequestMethod.POST)
    public ResponseEntity<Process> createProcess(@RequestBody Process process) {
        System.out.println("Creating Process " + process.getName());

        processService.createProcess(process);
        return new ResponseEntity<Process>(process, HttpStatus.CREATED);
    }
}
