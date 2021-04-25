var getReqKey = "GET";
var postReqKey = "POST";
var jsonDataTypeKey = "JSON";
var jsonContentTypeKey = "application/json";
var successKey = "isSuccess";
var codeKey = "code";
var msgKey = "msg";
var dataKey = "data";


/*通用ajax请求*/
function ajax_Req(sync,type,url,dataType,contentType,data,success_fallback,fail_fallback) {
    $.ajax({
        async:sync,
        type:type,
        url:url,
        datatype:dataType,
        contentType:contentType,
        data:data,
        success: success_fallback,
        error: fail_fallback,
    });
}

/*提示弹窗*/
function tipsWindow(text,type) {
    mini.showTips({
        content: text,
        state: type,
        x: 'center',
        y: 'center',
        timeout: 2000
    })
}


