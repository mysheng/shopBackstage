package com.mysheng.office.model;

import java.util.List;

public class Classify {

    private Integer value;
    private String label;
    private Integer parentId;
    private List<Classify> children;


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Classify> getChildren() {
        return children;
    }

    public void setChildren(List<Classify> children) {
        this.children = children;
    }
}
