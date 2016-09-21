package org.xumak.camunda.spring.dao;

import org.xumak.camunda.spring.bean.PhaseHistory;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface PhaseHistoryDao {

    List<PhaseHistory> getAllPhaseHistories();
    void createPhaseHistory(PhaseHistory phaseHistory);
    PhaseHistory findById(int id);
    void updatePhaseHistory(PhaseHistory phaseHistory);
}
