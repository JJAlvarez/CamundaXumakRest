package org.xumak.camunda.spring.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by xumak on 21/09/16.
 */
public class Task {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("assignee")
    private String assignee;

    @SerializedName("created")
    private Date created;

    @SerializedName("executionId")
    private String executionId;

    @SerializedName("priority")
    private int priority;

    @SerializedName("processDefinitionId")
    private String processDefinitionId;

    @SerializedName("processInstanceId")
    private String processInstanceId;

    @SerializedName("taskDefinitionKey")
    private String taskDefinitionKey;

    @SerializedName("supended")
    private Boolean suspended;

    @SerializedName("formKey")
    private String formKey;

    public Task() {
    }

    public Task(String id, String name, String assignee, Date created,
                String executionId, int priority, String processDefinitionId, String processInstanceId, String taskDefinitionKey, Boolean suspended, String formKey) {
        this.id = id;
        this.name = name;
        this.assignee = assignee;
        this.created = created;
        this.executionId = executionId;
        this.priority = priority;
        this.processDefinitionId = processDefinitionId;
        this.processInstanceId = processInstanceId;
        this.taskDefinitionKey = taskDefinitionKey;
        this.suspended = suspended;
        this.formKey = formKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public Boolean getSuspended() {
        return suspended;
    }

    public void setSuspended(Boolean suspended) {
        this.suspended = suspended;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }
}
