mini.parse();
var loginWindow = mini.get("loginWindow");
var checkRegisterFlag = false;
loginWindow.show();
/*登录请求*/
function loginReq(data) {
    var url = '/user/login';
    ajax_Req(true, postReqKey, url, jsonDataTypeKey, jsonContentTypeKey, data, login_success_fallBack, login_fail_fallBack)
}
// /*验证账号是否已经注册请求*/
// function checkRegisterReq(data) {
//     var url = '/user/login';
//     ajax_Req(true, postReqKey, url, jsonDataTypeKey, jsonContentTypeKey, data, isRegister_success_fallBack, isRegister_fail_fallBack)
// }
/*登录请求成功回调*/
function login_success_fallBack(res) {
    console.log(res);
    if (res[successKey] && res[codeKey] == 200) {
        loginWindow.hide();
        mini.loading("登录成功，马上转到系统...", "登录成功");
        setTimeout(function () {
            window.location.href = "/page/admin.html?uid="+res[dataKey];
            //window.location.href = "/static/assets/frame/frame1/index.html?uid="+res[dataKey];
        }, 1500);
    } else {
        mini.alert(res[msgKey],"Tips");
    }
}
/*登录请求失败回调*/
function login_fail_fallBack(res) {
    console.log(res);
    mini.alert("登录请求失败，请重试","警告");
}

// /*验证账号是否注册请求成功回调*/
// function isRegister_success_fallBack(res) {
//     console.log(res);
//     if (!res[successKey] && res[codeKey] == 4001) {
//         checkRegisterFlag = true;
//     }else {
//         checkRegisterFlag = false;
//     }
// }
// /*验证账号是否注册请求失败回调*/
// function isRegister_fail_fallBack(res) {
//     let text = "ajax request error!";
//     tipsWindow(text,"danger");
// }
/**/
/*登录按钮事件*/
function onLoginClick(e) {
    var form = new mini.Form("#loginWindow");
    form.validate();
    if (form.isValid() == false) {
        return;
    } else {
        /*获取表单数据*/
        var data = form.getData();
        var jsonData = mini.encode(data);

        loginReq(jsonData);
    }
}
/*重置*/
function onResetClick(e) {
    var form = new mini.Form("#loginWindow");
    form.clear();
}
/////////////////////////////////////
/*验证*/
function updateError(e) {
    var id = e.sender.name + "_error";
    var el = document.getElementById(id);
    if (el) {
        el.innerHTML = e.errorText;
    }
}
function onUserNameValidation(e) {
    updateError(e);
}
function onPwdValidation(e) {
    updateError(e);
}
// function checkState(e) {
//     //1.检验是否通过输入验证
//     let username = mini.get("username");
//     username.validate();
//     if (username.isValid()){
//         //2.如果通过输入验证，发送请求，检验账号是否已经注册
//         let json = {username:username.getValue()};
//         let jsonData = mini.encode(json);
//         checkRegisterReq(jsonData);
//         if (checkRegisterFlag){
//         }
//         //3.根据响应信息给用户提示
//     }
// }