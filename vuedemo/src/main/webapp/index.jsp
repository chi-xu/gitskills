<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%


String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css">
	
  </head>
  
  <body>
	
<div class="login">
   <form action="" method="post">
		<input type="text"  id="username" name="username" placeholder="用户名"><br>
		<input type="text"  id="password" name="password" placeholder="密码"><br>
		<button type="button" class="btn btn-default" id="btn">登录</button>
	</form>
</div>
  </body>
<script src="bootstrap-3.3.7/js/jquery-1.11.1.min.js"></script>
<script src="bootstrap-3.3.7/js/bootstrap.js"></script>
<script>
	$(function(){
		$('#btn').click(function(){
			var username = $('#username').val();
			var password = $('#password').val();
			
			 $.getJSON('log/login',{'username':username,'password':password},function(data){
				if(data.flag === '0'){ //成功
					location.href= 'success.jsp';
				}else{//失败
					//$('#error').html('用户名或密码错误')
					alert("用户名或密码错误");
				}
			})			
		})			
	}) 
</script>
</html>
