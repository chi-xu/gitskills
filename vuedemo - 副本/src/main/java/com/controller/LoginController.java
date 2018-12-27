package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.LoginDao;

import com.model.Login;
@Controller
@RequestMapping(value="log")
public class LoginController {
    
    private LoginDao loginDao = new LoginDao();
    
    @ResponseBody
    @RequestMapping(value="login")
    public Map<String,Object> login(Login login,HttpSession session){
        Map<String,Object> hm = new HashMap<String,Object>();
        
        if(loginDao.login(login)){//成功
            hm.put("flag","0");
            //把用户对象放入session
            session.setAttribute("user", login);
        }else{//失败
            hm.put("flag","1");
        }           
        return hm;
    }

}
