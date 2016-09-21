package org.xumak.camunda.spring.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by xumak on 14/09/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TimeOffHistory")
public class TimeOffHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer timeOffHistoryId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bossId", referencedColumnName = "userId")
    private User bossId;

    @NotEmpty
    @Column(name = "requestType", nullable = false)
    private String requestType;

    @NotNull
    @Column(name = "startDate", nullable = false)
    private Date startDate;

    @NotNull
    @Column(name = "endDate", nullable = false)
    private Date endDate;

    @NotNull
    @Column(name = "days", nullable = false)
    private Integer days;

    @NotNull
    @Column(name = "hours", nullable = false)
    private Integer hours;

    @Column(name = "approved", nullable = false)
    private boolean approved;

    public Integer getTimeOffHistoryId() {
        return timeOffHistoryId;
    }

    public void setTimeOffHistoryId(Integer timeOffHistoryId) {
        this.timeOffHistoryId = timeOffHistoryId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public User getBossId() {
        return bossId;
    }

    public void setBossId(User bossId) {
        this.bossId = bossId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public TimeOffHistory() {
    }

    public TimeOffHistory(Integer id, User userId, User bossId, String requestType, Date startDate,
                          Date endDate, Integer days, Integer hours, boolean approved) {
        this.timeOffHistoryId = id;
        this.userId = userId;
        this.bossId = bossId;
        this.requestType = requestType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
        this.hours = hours;
        this.approved = approved;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((timeOffHistoryId == null) ? 0 : timeOffHistoryId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof TimeOffHistory))
            return false;
        TimeOffHistory other = (TimeOffHistory) obj;
        if (timeOffHistoryId == null) {
            if (other.timeOffHistoryId != null)
                return false;
        } else if (!timeOffHistoryId.equals(other.timeOffHistoryId))
            return false;
        return true;
    }
}
