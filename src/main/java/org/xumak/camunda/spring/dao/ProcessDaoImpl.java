package org.xumak.camunda.spring.dao;

import org.springframework.stereotype.Repository;
import org.xumak.camunda.spring.bean.Process;
import org.xumak.camunda.spring.constants.Constants;

import java.util.List;

/**
 * Created by xumak on 16/09/16.
 */

@Repository("processDao")
public class ProcessDaoImpl extends AbstractDao<Integer, Process> implements ProcessDao {

    @SuppressWarnings("unchecked")
    public List<Process> getAllProcess() {
        List<Process> processes = getEntityManager()
                .createQuery(Constants.ALL_PROCESSES_QUERY)
                .getResultList();
        return processes;
    }

    public void createProcess(Process process) {
        persist(process);
    }

    public Process findById(int id) {
        return getByKey(id);
    }
}
