package com.bocloud.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocloud.trainning.mapper.DepartmentMapper;
import com.bocloud.trainning.model.Department;
import com.util.TreeUtil;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    
    public List<Department> departmentList() {
       
        return TreeUtil.buildByRecursive(this.departmentMapper.departmentList());
    }

}
