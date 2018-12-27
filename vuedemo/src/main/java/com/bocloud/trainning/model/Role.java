package com.bocloud.trainning.model;

import java.util.List;

public class Role {
    
    private Integer id;
    
    private String rname;
    
    private Integer pid;
    
    private List<Role> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Role> getChildren() {
        return children;
    }

    public void setChildren(List<Role> children) {
        this.children = children;
    }
    
    
    
    

    
}
