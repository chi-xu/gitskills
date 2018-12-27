package com.bocloud.trainning.service;

import java.util.List;

import com.bocloud.trainning.model.Users;
import com.util.Page;

public interface UsersService {

    public int login(Users users);
    
  
    
    public Page fuzzyQuery(Users users,Integer currPage,Integer pageSize);
    
    public void del(String[] userIds);
    
    public List<Users> query();
    
//    public List<Users> queryAll();
    
    public void add(Users users);
    
    public Users queryById(String userId);
    
    public List<Users> parentList(String userId);
    
    public void update(Users users);
    
    public void updRole(Users users);

}
