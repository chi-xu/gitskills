package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Login;
import com.util.Conn;

public class LoginDao {

    /**
     * 登录时，判断数据库里是否有此用户
     * @param login
     * @return
     */
    public boolean login(Login login){
        boolean flag = false;
        Connection conn = Conn.getConn();
        String sql = "select count(*) num from login where username=? and password=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, login.getUsername());
            pst.setString(2, login.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                flag = rs.getInt("num")>0?true:false;
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
        return flag;
    }
    
    
    
}
