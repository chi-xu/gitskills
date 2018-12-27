package com.bocloud.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bocloud.trainning.mapper.PostMapper;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;
    
    public List<com.bocloud.trainning.model.Post> postList() {
       
        return this.postMapper.postList();
    }

}
