package com.bocloud.trainning.mapper;

import java.util.List;

import com.bocloud.trainning.model.Users;

public interface UsersMapper {


    public Users login(Users users);
    
    
    
    public Integer selCount(Users users);
    
    public List<Users> fuzzyQuery(Users users);
    
    public void del(String userId);
    

    
    public void add(Users users);
    
    public Users queryById(String userId);
    
    public List<Users> parentList(Users users);
    
    public void update(Users users);
    
    public void updRole(Users users);
    
    public Integer queryCount(String userId);
}
