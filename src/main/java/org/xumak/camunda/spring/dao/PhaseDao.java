package org.xumak.camunda.spring.dao;

import org.xumak.camunda.spring.bean.Phase;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface PhaseDao {

    List<Phase> getAlPhases();
    void createPhase(Phase phase);
    Phase findById(int id);
}
