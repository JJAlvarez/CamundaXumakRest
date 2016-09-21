package org.xumak.camunda.spring.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by xumak on 16/09/16.
 */

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Process")
public class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer processId;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "description", nullable = false)
    private String description;

    public Process() {
    }

    public Process(Integer id, String name, String description) {
        this.processId = id;
        this.name = name;
        this.description = description;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Process))
            return false;
        Process other = (Process) obj;
        if (processId.equals(null)) {
            if (!processId.equals(null))
                return false;
        } else if (!processId.equals(other.processId))
            return false;
        return true;
    }
}
