<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/demo.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" language="javascript"
                src="${pageContext.request.contextPath}/js/jquery-1.4.2.js">
        </script>
        <title>选举登录</title>
        <script language="javascript" type="text/javascript">
            var bTel = /^(0|86|17951)?(13[0-9]|15[012356789]|18[0-9]|14[57])[0-9]{8}$/;
            var bQq = /^[1-9][0-9]{4,9}$/;
            $.extend($.fn.validatebox.defaults.rules, {
            phoneRex: {
            validator: function (value) {
            if (bTel.test(value)) {
            return true;
            } else {
             return false;
            }
            }
            ,
                    message: '请输入正确的手机号码格式'
            },
                    );
        </script>
    </head>
    <body>
        <dir align="center">
            <form id="loginForm" action="adopt/login/userLogin" method="post">
                <table align="center">
                    <tr>
                        <th width="35%" align="right" valign="middle">
                            账&nbsp;&nbsp;号：
                        </th>
                        <td align="left" valign="middle">
                            <input class="easyui-textbox" type="text" name="tel" id="txtTel" value="${account.tel}" data-options="prompt:'请输入手机号',required:true,missingMessage:'手机号不能为空',validType:'phoneRex'"/>
                        </td>
                    </tr>
                    <tr>
                        <th align="right" valign="middle">
                            密&nbsp;&nbsp;码：
                        </th>
                        <td align="left" valign="middle">
                            <input class="easyui-textbox" type="password" name="password" id="txtPwd" value="${account.tel}" data-options="prompt:'请输入密码!',required:true,missingMessage:'密码不能为空'"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            &nbsp;
                        </td>
                        <td align="left">
                            <input type="submit" id="btnLogin" value="登录" style="width:80px;height:50px"/>
                            <input type="button" id="btnCancel" value="取消" style="width:80px;height:50px"/>
                            <span id="msgResult" style="color: #FF0000; font-size: 12px"></span>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                </table>
            </form>
        </dir>
    </body>
</html>