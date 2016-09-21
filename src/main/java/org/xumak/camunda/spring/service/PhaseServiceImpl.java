package org.xumak.camunda.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xumak.camunda.spring.bean.Phase;
import org.xumak.camunda.spring.dao.PhaseDao;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Service("phaseService")
@Transactional
public class PhaseServiceImpl implements PhaseService {

    @Autowired
    private PhaseDao dao;

    public void createPhase(Phase phase) {
        dao.createPhase(phase);
    }

    public List<Phase> getAllPhases() {
        return dao.getAlPhases();
    }

    public Phase findById(int id) {
        return dao.findById(id);
    }
}
