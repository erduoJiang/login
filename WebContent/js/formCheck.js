
$(function(){
    //判断汉字是双字符的方法
    var getLength = function(str){
        return str.replace(/[^\x00-xff]/g,'xx').length;
    };

    //重复字符方法
    var findStr = function(str,n){
        var tmp = 0;
        for(var i = 0;i<str.length;i++){
            if(str.charAt(i) == n){
                tmp++
            }
        }
        return tmp;
    }

    var userName = $('input[name=userName]');
    var pwd = $('input[name=userPass]');
    var rePwd = $('input[name=repassWord]');
    var pwdStatMiddle = $('.js-stat-m');
    var pwdStatStrong = $('.js-stat-s');
    var nameLength = 0;
    var userNameState = false,pwdState = false,repwdState = false;

    //用户名获取焦点时触发事件
    userName.on('focus',function(){
        var $this =  $(this).closest('li').find('.form-info');
        $this.text('5-25个字符，一个汉字为两个字符，推荐使用中文会员名。').show();
    })

    //用户名键盘弹起时触发事件
    userName.on('keyup',function(){
        //计算用户名长度，汉字为2个字符
        nameLength = getLength($(this).val());
        $(this).closest('li').find('.form-error').text(nameLength + '个字符').show();
        if(nameLength == '0'){
            $(this).closest('li').find('.form-error').hide();
        }
    })

    //用户名失去焦点时触发事件
    userName.on('blur',function(){
        var $this =  $(this).closest('li').find('.form-info');
        var reg = /[^\w\u4e00-\u9fa5]+/;    //正则\w数字字母 后面的是汉字

        if(reg.test($(this).val())){
            $this.text('含有非法字符').show();
            userNameState = false;
        }else if($(this).val() == ''){
            $this.text('不能为空').show();
            userNameState = false;
        }else if(nameLength > 25){
            $this.text('不能大于25个字符').show();
            userNameState = false;
        }else if(nameLength < 6){
            $this.text('不能少于6个字符').show();
            userNameState = false;
        }else{
            $this.text('OK').show();
            userNameState = true;
        }
    });

    //密码
    pwd.on('focus',function(){
        var $this =  $(this).closest('li').find('.form-info');
        $this.text('5-16个字符，请使用字母数字或符号组合的密码').show();
    })

    pwd.on('keyup',function(){
        //密码大于5之后 密码强度显示中 同时释放下面密码框禁输状态
        if($(this).val().length > 5 ){
            pwdStatMiddle.addClass('active');
            rePwd.removeAttr('disabled');
            rePwd.closest('li').find('.form-info').show();
        }else{
            pwdStatMiddle.removeClass('active');
            rePwd.attr('disabled','true');
            rePwd.closest('li').find('.form-info').hide();
        }

        if($(this).val().length > 10 ){
            pwdStatStrong.addClass('active');
        }else{
            pwdStatStrong.removeClass('active');
        }
        checkform()
    });

    pwd.on('blur',function(){
        var $this =  $(this).closest('li').find('.form-info');
        var m = findStr(pwd.val(),pwd.val()[0]);    //重复密码方法校验，传参把值传给m
        var regN = /[^\d]+/;    //非数字
        var regT = /[^a-zA-Z]+/;    //非字母

        //不能为空
        if($(this).val() == ''){
            $this.text('不能为空').show();
            pwdState = false;
        }
        //不能用相同字符
        else if(m == $(this).val().length){
            $this.text('不能用相同字符').show();
            pwdState = false;
        }
        //长度应为6-16个字符
        else if($(this).val().length < 6 || $(this).val().length > 16){
            $this.text('长度应为6-16个字符').show();
            pwdState = false;
        }
        //不能全为数字
        else if(!regN.test($(this).val())){
            $this.text('不能全为数字').show();
            pwdState = false;
        }
        //不能全为字母
        else if(!regT.test($(this).val())){
            $this.text('不能全为字母').show();
            pwdState = false;
        }
        //ok
        else{
            $this.text('OK').show();
            pwdState = true;
        }
        checkform()
    })

    //重复密码
    rePwd.on('blur',function(){
        var $this =  $(this).closest('li').find('.form-info');
         if($(this).val() !== pwd.val()){
            $this.text('两次输入的密码不一致').show();
            repwdState = false;
         }else{
            $this.text('OK').show();
            repwdState = true;
         }
         checkform()
     })

     function checkform() {
        if (userNameState &&  pwdState && repwdState) {
            $('.submit').removeAttr("disabled");
        } else {
            $('.submit').attr("disabled");      
        }
    }

});
