package com.bocloud.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocloud.trainning.mapper.RoleMapper;
import com.bocloud.trainning.model.Role;
import com.util.RoleTree;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    
    public List<Role> roleList() {
        
        return RoleTree.buildByRecursive(this.roleMapper.roleList());
    }

}
