package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xumak.camunda.spring.bean.Phase;
import org.xumak.camunda.spring.bean.PhaseHistory;
import org.xumak.camunda.spring.bean.User;
import org.xumak.camunda.spring.service.PhaseHistoryService;
import org.xumak.camunda.spring.service.PhaseService;
import org.xumak.camunda.spring.service.TimeOffHistoryService;
import org.xumak.camunda.spring.service.UserService;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@RestController
public class PhaseHistoryController {

    @Autowired
    private PhaseHistoryService phaseHistoryService;
    @Autowired
    private PhaseService phaseService;
    @Autowired
    private UserService userService;
    @Autowired
    private TimeOffHistoryService timeOffHistoryService;

    @RequestMapping(value = "/phasehistory/", method = RequestMethod.GET)
    public ResponseEntity<List<PhaseHistory>> getAllPhaseHistories() {
        List<PhaseHistory> phaseHistories = phaseHistoryService.getAllPhaseHistories();
        if (phaseHistories == null) {
            return new ResponseEntity<List<PhaseHistory>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PhaseHistory>>(phaseHistories, HttpStatus.OK);
    }

    @RequestMapping(value = "/phasehistory", method = RequestMethod.POST)
    public ResponseEntity<PhaseHistory> createPhaseHistory(@RequestBody PhaseHistory phaseHistory) {
        phaseHistory.setAssignedPerson(userService.findById(phaseHistory.getAssignedPersonId()));
        phaseHistory.setPhase(phaseService.findById(phaseHistory.getPhaseId()));
        phaseHistory.setTimeOffHistory(timeOffHistoryService.findById(phaseHistory.getTimeOffHistoryId()));
        phaseHistoryService.createPhaseHistory(phaseHistory);
        return new ResponseEntity<PhaseHistory>(phaseHistory, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/phasehistory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PhaseHistory> updatePhaseHistory(@PathVariable("id") int id, @RequestBody PhaseHistory phaseHistory) {
        PhaseHistory update = phaseHistoryService.findById(id);
        if (update == null) {
            return new ResponseEntity<PhaseHistory>(HttpStatus.NOT_FOUND);
        }
        update.setEndDate(phaseHistory.getEndDate());
        phaseHistoryService.updatePhaseHistory(update);
        return new ResponseEntity<PhaseHistory>(update, HttpStatus.OK);
    }
}
