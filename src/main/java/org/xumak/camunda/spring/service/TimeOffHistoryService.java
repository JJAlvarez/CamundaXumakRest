package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.bean.TimeOffHistory;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface TimeOffHistoryService {

    TimeOffHistory findById(int id);
    void saveTimeOffHistoryService(TimeOffHistory timeOffHistory);
    void updateTimeOffHistoryService(TimeOffHistory timeOffHistory);
    void deleteById(int id);
    List<TimeOffHistory> getAllHistories();
    boolean isHistoryExist(int id);
}
