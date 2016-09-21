package org.xumak.camunda.spring.dao;

import org.springframework.stereotype.Repository;
import org.xumak.camunda.spring.bean.TimeOffHistory;
import org.xumak.camunda.spring.constants.Constants;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Repository("timeOffHistoryDao")
public class TimeOffHistoryDaoImplementation extends AbstractDao<Integer, TimeOffHistory> implements TimeOffHistoryDao {

    public TimeOffHistory findById(int id) {
        TimeOffHistory timeOffHistory = getByKey(id);
        return timeOffHistory;
    }

    public void save(TimeOffHistory timeOffHistory) {
        persist(timeOffHistory);
    }

    public void update(TimeOffHistory timeOffHistory) {
        update(timeOffHistory);
    }

    @SuppressWarnings("unchecked")
    public List<TimeOffHistory> selectAll() {
        List<TimeOffHistory> timeOffHistories = getEntityManager()
                        .createQuery(Constants.ALL_TIME_OFF_HISTORIES_QUERY)
                        .getResultList();
        return timeOffHistories;
    }

    public void delete(TimeOffHistory timeOffHistory) {
        delete(timeOffHistory);
    }
}
