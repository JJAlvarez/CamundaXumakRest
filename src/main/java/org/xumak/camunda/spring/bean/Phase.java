package org.xumak.camunda.spring.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by xumak on 16/09/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Phase")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer phaseId;

    @NotNull
    @ManyToOne
    private Process process;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "process_id", nullable = false, insertable = false, updatable = false)
    private Integer processId;

    public Phase() {
    }

    public Phase(Integer id, Process process, String name, Integer processId) {
        this.phaseId = id;
        this.process = process;
        this.name = name;
        this.processId = processId;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }
}
