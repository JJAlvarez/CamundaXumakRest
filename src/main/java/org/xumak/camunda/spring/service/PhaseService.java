package org.xumak.camunda.spring.service;

import org.xumak.camunda.spring.bean.Phase;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
public interface PhaseService {

    void createPhase(Phase phase);
    List<Phase> getAllPhases();
    Phase findById(int id);
}
