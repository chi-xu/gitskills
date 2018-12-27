package com.bocloud.trainning.service;

import com.bocloud.trainning.mapper.UsersMapper;
import com.bocloud.trainning.model.Users;

import com.util.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {
    
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 登录
     * return 0:成功  1:用户名错 2:密码错
     */
    public int login(Users users){
        int flag = 0;
        Users u = this.usersMapper.login(users);
        if(u==null){
            flag = 1;

        }else if (!u.getPassword().equals(users.getPassword())){
            flag = 2;
        }
        return flag;
    }
    
    
    
    /**
     * 模糊查询
     */
    public Page fuzzyQuery(Users users,Integer currPage,Integer pageSize){
        if(currPage == null) currPage=1;   
        if(pageSize == null) pageSize = 10;
        
        Page page = new Page();
        page.setCurrPage(currPage);
        page.setPageSize(pageSize);
        //查总记录数
        try {
            page.setTotalCount(this.usersMapper.selCount(users));
        } catch (Exception e) {
            e.printStackTrace();
        }     
        //计算总页数
        page.init();
        PageHelper.startPage(currPage, pageSize);
        try {
            page.setData(this.usersMapper.fuzzyQuery(users));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
    
    /**
     * 删除用户
     */
    public void del(String[] userIds) {
        for(String id:userIds) {
            this.usersMapper.del(id);
        }
        
    }



    public List<Users> query() {
        // TODO Auto-generated method stub
        return null;
    }


    
    
    public List<Users> parentList(Users users){
        
        return this.usersMapper.parentList(users);
    }
    
    /**
     * 新增用户
     */
    @Transactional
    public void add(Users users) {
        if(this.usersMapper.queryCount(users.getUserId())<1) {
            this.usersMapper.add(users);
        }else {
            throw new RuntimeException("此工号已经存在！");
        }
        
    }
    /**
     * 返回用户个人信息
     */
    public Users queryById(String userId) {
        return this.usersMapper.queryById(userId);
    }
    
    /**
     * 更改用户信息
     */
    public void update(Users users) {
        this.usersMapper.update(users);
    }
    
    /**
     * 分配角色
     */
    public void updRole(Users users) {
        this.usersMapper.updRole(users);
    }
    
}
