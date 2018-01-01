/**
 * Created by Administrator on 2018/1/1.
 */
//当用户名文本框获取焦点时，提示用户名不能修改
function c1() {
    namewarn = document.getElementById("namewarn");
    namewarn.innerHTML = "用户名不允许修改";
}
function c2() {
    namewarn = document.getElementById("namewarn");
    namewarn.innerHTML = "";
}


function checkPwd(){
    pwd=document.getElementById("pwd");
    pwdwarn=document.getElementById("pwdwarn");
    if(pwd.value==""){
        pwdwarn.innerHTML="请输入密码"
        return false;
    }else if(pwd.value.length<6){
        pwdwarn.innerHTML="密码长度小于6";
        return false;
    }else{
        pwdwarn.innerHTML="";
        return true;
    }
}
function checkrePwd(){
    pwd=document.getElementById("pwd");
    var repwd=document.getElementById("repwd");
    var repwdwarn=document.getElementById("repwdwarn");
    if(repwd.value==""){
        repwdwarn.innerHTML="请再次确认密码";
        return false;
    }else if(pwd.value!=repwd.value){
        repwdwarn.innerHTML="两次输入的密码不同";
        return false;
    } else{
        repwdwarn.innerHTML="";
        return true;
    }
}
function checkmail(){
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    var mail=document.getElementById("mail");
    var mailwarn=document.getElementById("mailwarn");
    if(myreg.test(mail.value)){
        mailwarn.innerHTML="";
        return true;
    }else{
        mailwarn.innerHTML="邮箱输入错误";
        return false;
    }
}

function checkphone(){
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    var phone=document.getElementById("phone");
    phonewarn=document.getElementById("phonewarn");
    if(phone.value.length==11&&myreg.test(phone.value)){
        phonewarn.innerHTML="";
        return true;
    }else{
        phonewarn.innerHTML="手机号码输入有误";
        return false;
    }
}

function check(){
    if(checkPwd()&&checkrePwd()&&checkmail()&&checkphone()){

        return true;
    }else if(!(checkPwd()&&checkrePwd())){
        alert("密码不符合要求");
        return false;
    }else if(!checkmail()){
        alert("邮箱输入有误");
        return false;
    }else if(!checkphone()){
        alert("手机号码输入有误");
        return false;
    } else{
        return false;
    }
}