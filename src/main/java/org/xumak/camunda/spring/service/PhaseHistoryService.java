package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.bean.PhaseHistory;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface PhaseHistoryService {

    void createPhaseHistory(PhaseHistory phaseHistory);
    List<PhaseHistory> getAllPhaseHistories();
    PhaseHistory findById(int id);
    void updatePhaseHistory(PhaseHistory phaseHistory);
}
