package org.xumak.camunda.spring.dao;

import org.xumak.camunda.spring.bean.TimeOffHistory;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface TimeOffHistoryDao {

    TimeOffHistory findById(int id);
    void save(TimeOffHistory timeOffHistory);
    void update(TimeOffHistory timeOffHistory);
    List<TimeOffHistory> selectAll();
    void delete(TimeOffHistory timeOffHistory);
}
