package org.xumak.camunda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xumak.camunda.spring.bean.TimeOffHistory;
import org.xumak.camunda.spring.service.TimeOffHistoryService;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@RestController
public class TimeOffHistoryController {

    @Autowired
    TimeOffHistoryService timeOffHistoryService;


    @RequestMapping(value = "/timeoffhistory/", method = RequestMethod.GET)
    public ResponseEntity<List<TimeOffHistory>> getAllHistories() {
        List<TimeOffHistory> timeOffHistories = timeOffHistoryService.getAllHistories();
        if (timeOffHistories == null) {
            return new ResponseEntity<List<TimeOffHistory>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<TimeOffHistory>>(timeOffHistories, HttpStatus.OK);
    }

    @RequestMapping(value = "/timeoffhistory/{id}", method = RequestMethod.GET)
    public ResponseEntity<TimeOffHistory> getById(@PathVariable("id") int id) {
        TimeOffHistory timeOffHistory = timeOffHistoryService.findById(id);
        if(timeOffHistory == null) {
            return new ResponseEntity<TimeOffHistory>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TimeOffHistory>(timeOffHistory, HttpStatus.OK);
    }

    @RequestMapping(value = "/timeoffhistory/", method = RequestMethod.POST)
    public ResponseEntity<TimeOffHistory> createTimeOffHistory(@RequestBody TimeOffHistory timeOffHistory) {
        if (timeOffHistoryService.isHistoryExist(timeOffHistory.getTimeOffHistoryId())) {
            System.out.println("This history already exist");
            return new ResponseEntity<TimeOffHistory>(HttpStatus.CONFLICT);
        }
        timeOffHistoryService.saveTimeOffHistoryService(timeOffHistory);
        return new ResponseEntity<TimeOffHistory>(timeOffHistory, HttpStatus.CREATED);
    }
}
