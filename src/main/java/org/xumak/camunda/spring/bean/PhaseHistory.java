package org.xumak.camunda.spring.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by xumak on 16/09/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "PhaseHistory")
public class PhaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer phaseHistoryId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "phaseId", referencedColumnName = "id")
    private Phase phase;

    @NotNull
    @Column(name = "phaseId", nullable = false, insertable = false, updatable = false)
    private Integer phaseId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "assignedPerson", referencedColumnName = "userId")
    private User assignedPerson;

    @NotNull
    @Column(name = "assignedPerson", nullable = false, insertable = false, updatable = false)
    private String assignedPersonId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "timeOffHistoryId", referencedColumnName = "id")
    private TimeOffHistory timeOffHistory;

    @NotNull
    @Column(name = "timeOffHistoryId", nullable = false, insertable = false, updatable = false)
    private Integer timeOffHistoryId;

    @NotNull
    @Column(name = "startDate")
    private Date startDate;

    @NotNull
    @Column(name = "endDate")
    private Date endDate;

    public PhaseHistory() {
    }

    public PhaseHistory(Integer phaseHistoryId, Phase phase, Integer phaseId, User assignedPerson, String assignedPersonId, TimeOffHistory timeOffHistory,
                        Integer timeOffHistoryId, Date startDate, Date endDate) {
        this.phaseHistoryId = phaseHistoryId;
        this.phase = phase;
        this.phaseId = phaseId;
        this.assignedPerson = assignedPerson;
        this.assignedPersonId = assignedPersonId;
        this.timeOffHistory = timeOffHistory;
        this.timeOffHistoryId = timeOffHistoryId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getPhaseHistoryId() {
        return phaseHistoryId;
    }

    public void setId(Integer phaseHistoryId) {
        this.phaseHistoryId = phaseHistoryId;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public User getAssignedPerson() {
        return assignedPerson;
    }

    public void setAssignedPerson(User assignedPerson) {
        this.assignedPerson = assignedPerson;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TimeOffHistory getTimeOffHistory() {
        return timeOffHistory;
    }

    public void setTimeOffHistory(TimeOffHistory timeOffHistory) {
        this.timeOffHistory = timeOffHistory;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public String getAssignedPersonId() {
        return assignedPersonId;
    }

    public void setAssignedPersonId(String assignedPersonId) {
        this.assignedPersonId = assignedPersonId;
    }

    public Integer getTimeOffHistoryId() {
        return timeOffHistoryId;
    }

    public void setTimeOffHistoryId(Integer timeOffHistoryId) {
        this.timeOffHistoryId = timeOffHistoryId;
    }
}
