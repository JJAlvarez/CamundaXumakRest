package org.xumak.camunda.spring.dao;

import org.springframework.stereotype.Repository;
import org.xumak.camunda.spring.bean.Phase;
import org.xumak.camunda.spring.constants.Constants;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Repository("phaseDao")
public class PhaseDaoImpl extends AbstractDao<Integer, Phase> implements PhaseDao {

    @SuppressWarnings("unchecked")
    public List<Phase> getAlPhases() {
        List<Phase> phases =
                getEntityManager()
                    .createQuery(Constants.ALL_PHASES_QUERY)
                    .getResultList();
        return phases;
    }

    public void createPhase(Phase phase) {
        persist(phase);
    }

    public Phase findById(int id) {
        return getByKey(id);
    }
}
