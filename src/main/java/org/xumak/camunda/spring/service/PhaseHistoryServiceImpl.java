package org.xumak.camunda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.bean.PhaseHistory;
import org.xumak.camunda.spring.dao.PhaseHistoryDao;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Service("phaseHistoryService")
@Transactional
public class PhaseHistoryServiceImpl implements PhaseHistoryService {

    @Autowired
    private PhaseHistoryDao dao;

    public void createPhaseHistory(PhaseHistory phaseHistory) {
        dao.createPhaseHistory(phaseHistory);
    }

    public List<PhaseHistory> getAllPhaseHistories() {
        return dao.getAllPhaseHistories();
    }

    public PhaseHistory findById(int id) {
        return dao.findById(id);
    }

    public void updatePhaseHistory(PhaseHistory phaseHistory) {
        dao.updatePhaseHistory(phaseHistory);
    }
}
