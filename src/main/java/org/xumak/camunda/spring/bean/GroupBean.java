package org.xumak.camunda.spring.bean;

/**
 * Created by xumak on 14/09/16.
 */
public class GroupBean {

    private String name;

    public GroupBean() {
    }

    public GroupBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
