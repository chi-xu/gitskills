package com.bocloud.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bocloud.trainning.mapper.CompanyMapper;
import com.bocloud.trainning.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    
    public List<Company> companyList() {
        
        return this.companyMapper.companyList();
    }

}
