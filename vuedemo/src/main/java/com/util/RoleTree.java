package com.util;

import java.util.ArrayList;
import java.util.List;


import com.bocloud.trainning.model.Role;

public class RoleTree {

    public static List<Role> buildByRecursive(List<Role> Roles) {
        List<Role> trees = new ArrayList<Role>();
        Integer i=1;
        for (Role Role : Roles) {
            if (i.equals(Role.getId())) {
                trees.add(findChildren(Role,Roles));
            }
        }
        return trees;
    }

    
    public static Role findChildren(Role Role,List<Role> Roles) {
        Role.setChildren(new ArrayList<Role>());
        for (Role it : Roles) {
            if(Role.getId().equals(it.getPid())) {
                if (Role.getChildren() == null) {
                    Role.setChildren(new ArrayList<Role>());
                }
                Role.getChildren().add(findChildren(it,Roles));
            }
        }
        return Role;
    }
}
