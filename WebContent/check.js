
		function checkForm()
	    {
	        var flag=true;
	        var notrue = document.getElementById("notrue");
	        var usernameValue=document.getElementById("userName").value;    //��ȡ����
	        var passwordValue=document.getElementById("userPass").value;  //��ȡ��������� 
	        //alert(usernameValue+"----"+passwordValue);    //�˾�������������
	        if(usernameValue==null || usernameValue=="")
	        {
	        	notrue.innerHTML="<font color='red'>请登录</font>";
	            var useMes=document.getElementById("username_msg");
	            useMes.innerHTML="<font color='red'>请输入用户名</font>";
	            var passMes=document.getElementById("password_msg");
	            passMes.innerHTML="";
	            flag=false;
	            return flag;
	        }else{
	        	var useMes=document.getElementById("username_msg");
	        	useMes.innerHTML="";
	        		
	        }
	        if(passwordValue==null || passwordValue=="")
	        {
	        	notrue.innerHTML="<font color='red'>请登录</font>";
	            var passMes=document.getElementById("password_msg");
	            passMes.innerHTML="<font color='red'>请输入密码</font>";
	            flag=false;
	            return flag;
	        }else{
	        	var passMes=document.getElementById("password_msg");
	            passMes.innerHTML="";
	        }
	        
	    };

