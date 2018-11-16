<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户信息查询</title>

<script type="text/javascript" src="jquery-1.8.3.js"></script>
<link type="text/css" rel="styleSheet"  href="css/loginStyles.css" />

</head>
<body>

<form action="checkLogin" class="form" id="form" method="post">
<div class="top"><p id="notrue"><%=request.getAttribute("NOTRUEMSG")==null?"":request.getAttribute("NOTRUEMSG") %></p></div>
  <ul class="fieldset"> 
      <li class="field"> 
          <label for="userName" class="field-tit">用户名</label> 
          <div class="field-bd"> 
              <input class="txt" type="text" name="userName" id="userName" placeholder="" value="" autoComplete="off"> 
              <span class="form-info"></span>
          </div> 
          <p class="form-error"></p> 
      </li>
      <li class="field"> 
          <label for="passWord" class="field-tit">密码</label> 
          <div class="field-bd"> 
              <input class="txt" type="password" name="userPass" id="userPass" placeholder="" value=""> 
              <span class="form-info"></span>
          </div> 
          <div class="pwd-status">
              <span class="active">弱</span>
              <span class="js-stat-m">中</span>
              <span class="js-stat-s">强</span>
          </div>    
      </li>
      <li class="field"> 
          <label for="passWord" class="field-tit">确认密码</label> 
          <div class="field-bd"> 
              <input class="txt" type="password" name="repassWord" id="repassWord" disabled placeholder=""  value="">
              <span class="form-info">请再输入一次</span> 
          </div> 
      </li>

      <li class="field"> 
            <div class="field-bd"> 
                    <button type="submit" class="submit" disabled>点击提交</button>
            </div> 
        </li>
   </ul>

</form>

<script src="js/formCheck.js"></script>
</body>
</html>
