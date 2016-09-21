package org.xumak.camunda.spring.dao;

import org.springframework.stereotype.Repository;
import org.xumak.camunda.spring.bean.PhaseHistory;
import org.xumak.camunda.spring.constants.Constants;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */
@Repository("phaseHistoryDao")
public class PhaseHistoryDaoImpl extends AbstractDao<Integer, PhaseHistory> implements PhaseHistoryDao {

    @SuppressWarnings("unchecked")
    public List<PhaseHistory> getAllPhaseHistories() {
        List<PhaseHistory> phaseHistories =
                getEntityManager()
                .createQuery(Constants.ALL_PHASE_HISTORIES_QUERY)
                .getResultList();
        return phaseHistories;
    }

    public void createPhaseHistory(PhaseHistory phaseHistory) {
        persist(phaseHistory);
    }

    public PhaseHistory findById(int id) {
        return getByKey(id);
    }

    public void updatePhaseHistory(PhaseHistory phaseHistory) {
        update(phaseHistory);
    }
}
