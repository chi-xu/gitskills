package com.bocloud.trainning.model;

import java.util.List;



public class Department {

    private Integer id;
    
    private String dname;
    
    private Integer pid;
    
    private List<Department> children;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
    
    

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    

    
   
    
    
    

   
}
