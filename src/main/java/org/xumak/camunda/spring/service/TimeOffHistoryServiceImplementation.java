package org.xumak.camunda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.bean.TimeOffHistory;
import org.xumak.camunda.spring.dao.TimeOffHistoryDao;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Service("timeOffHistoryService")
@Transactional
public class TimeOffHistoryServiceImplementation implements TimeOffHistoryService {

    @Autowired
    private TimeOffHistoryDao dao;

    public TimeOffHistory findById(int id) {
        return dao.findById(id);
    }

    public void saveTimeOffHistoryService(TimeOffHistory timeOffHistory) {
        dao.save(timeOffHistory);
    }

    public void updateTimeOffHistoryService(TimeOffHistory timeOffHistory) {
        dao.update(timeOffHistory);
    }

    public void deleteById(int id) {
        TimeOffHistory timeOffHistory = dao.findById(id);
        dao.delete(timeOffHistory);
    }

    public List<TimeOffHistory> getAllHistories() {
        return dao.selectAll();
    }

    public boolean isHistoryExist(int id) {
        return dao.findById(id) != null;
    }
}
