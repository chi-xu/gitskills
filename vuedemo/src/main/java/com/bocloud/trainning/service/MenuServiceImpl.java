package com.bocloud.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocloud.trainning.mapper.MenuMapper;
import com.bocloud.trainning.model.Menu;
import com.util.MenuTree;
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    
    public List<Menu> menuList(){
        return MenuTree.buildByRecursive(this.menuMapper.menuList());
    }
}
