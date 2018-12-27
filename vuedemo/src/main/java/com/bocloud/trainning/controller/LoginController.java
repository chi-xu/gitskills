package com.bocloud.trainning.controller;
import com.bocloud.trainning.model.Result;
import com.bocloud.trainning.model.Users;
import com.bocloud.trainning.service.CompanyService;
import com.bocloud.trainning.service.DepartmentService;
import com.bocloud.trainning.service.MenuService;
import com.bocloud.trainning.service.PostService;
import com.bocloud.trainning.service.RoleService;
import com.bocloud.trainning.service.UsersService;

import bsh.This;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/log")
public class LoginController {
    
    @Resource
    private UsersService usersService;
    @Resource
    private CompanyService companyService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService postService;
    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;

    /**
     * 登录
     * @param users
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login")
    public Result login(@RequestBody Users users) {
       
        int flag = this.usersService.login(users);
        if(flag == 1) {
            return new Result(false,"用户名不存在");
        }else if(flag == 2) {
            return new Result(false,"密码错误");
        }
        
        return new Result(true,"登陆成功");
    }
    
   /**
    * 查询
    * @param users
    * @param currPage
    * @param pageSize
    * @return
    */
    @ResponseBody
    @RequestMapping(value = "fuzzyQuery")
    public Result fuzzyQuery(Users users,Integer currPage,Integer pageSize) {
       
        
        return new Result(true,this.usersService.fuzzyQuery(users, currPage, pageSize),"模糊查询");
    }
    
    
    
    /**
     * 新增用户
     * @param users
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public Result add(Users users) {
        try {
           
            this.usersService.add(users);
            return new Result(true,"增加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"增加失败！");
        }
    }
    
    /**
     *返回修改界面用户个人信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryById")
    public Result queryById(String userId) {
        return new Result(true,this.usersService.queryById(userId),"用户个人信息查询成功");
    }
    
    /**
     * 删除用户
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "del")
    public Result del(String[] userIds) {
        try {
            this.usersService.del(userIds);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除失败");
        }
    }
    
    /**
     * 修改用户
     * @param users
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public Result update(Users users) {
        this.usersService.update(users);
        return new Result(true,"修改成功");
    }
    
    @ResponseBody
    @RequestMapping(value = "updRole")
    public Result updRole(Users users) {
        try {
            this.usersService.updRole(users);
            return new Result(true,"分配角色成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"分配角色失败！");
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "companyList")
    public Result companyList() {
        
        return new Result(true,this.companyService.companyList(),"公司列表");
    }
    
    
    @ResponseBody
    @RequestMapping(value = "departmentList")
    public Result departmentList() {
        return new Result(true,this.departmentService.departmentList(),"部门列表");
    }
    
    @ResponseBody
    @RequestMapping(value = "postList")
    public Result postList() {
        
        return new Result(true,this.postService.postList(),"岗位列表");
    }
    
    @ResponseBody
    @RequestMapping(value = "parentList")
    public Result parentList(Users users){
        return new Result(true,this.usersService.parentList(users),"直属上级列表");
    }
    
    @ResponseBody
    @RequestMapping(value = "roleList")
    public Result roleList() {
        return new Result(true,this.roleService.roleList(),"角色列表");
    }
    
    @ResponseBody
    @RequestMapping(value = "menuList")
    public Result menuList() {
        return new Result(true,this.menuService.menuList(),"菜单列表");
    }

}
