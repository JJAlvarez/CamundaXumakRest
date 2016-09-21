package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xumak.camunda.spring.bean.Phase;
import org.xumak.camunda.spring.bean.Process;
import org.xumak.camunda.spring.service.PhaseService;
import org.xumak.camunda.spring.service.ProcessService;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@RestController
public class PhaseController {

    @Autowired
    private PhaseService phaseService;
    @Autowired
    private ProcessService processService;

    @RequestMapping(value = "/phase/", method = RequestMethod.GET)
    public ResponseEntity<List<Phase>> getAllPhases() {
        List<Phase> phases = phaseService.getAllPhases();
        if (phases == null) {
            return new ResponseEntity<List<Phase>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Phase>>(phases, HttpStatus.OK);
    }

    @RequestMapping(value = "/phase/", method = RequestMethod.POST)
    public ResponseEntity<Phase> createPhase(@RequestBody Phase phase) {
        System.out.println("Creating phase " + phase.getName());
        Process process = processService.findById(phase.getProcessId());
        phase.setProcess(process);
        phaseService.createPhase(phase);
        return new ResponseEntity<Phase>(phase, HttpStatus.CREATED);
    }
}
