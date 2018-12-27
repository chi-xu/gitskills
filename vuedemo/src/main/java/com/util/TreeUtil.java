package com.util;

import com.bocloud.trainning.model.Department;
import java.util.ArrayList;
import java.util.List;


public class TreeUtil {
    

    /**
     * 使用递归方法建树
     * @param Departments
     * @return
     */
    public static List<Department> buildByRecursive(List<Department> Departments) {
        List<Department> trees = new ArrayList<Department>();
        Integer i=6;
        for (Department Department : Departments) {
            if (i.equals(Department.getId())) {
                trees.add(findChildren(Department,Departments));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param Departments
     * @return
     */
    public static Department findChildren(Department Department,List<Department> Departments) {
        Department.setChildren(new ArrayList<Department>());
        for (Department it : Departments) {
            if(Department.getId().equals(it.getPid())) {
                if (Department.getChildren() == null) {
                    Department.setChildren(new ArrayList<Department>());
                }
                Department.getChildren().add(findChildren(it,Departments));
            }
        }
        return Department;
    }
    
}
