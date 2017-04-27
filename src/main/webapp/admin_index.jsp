<%--
    Document   : admin_index
    Created on : 2017-4-10, 16:32:54
    Author     : 张明晓
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/modules/layer/default/layer.css" />-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/modules/skin/default/layer.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/myjs/jquery-1.11.0.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/layui/css/modules/layer.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/myjs/newjavascript.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>

        <script language="javascript" type="text/javascript">
            $(function () {
                $('#newComment').on('click', function () {
                    layer.open({
                        type: 2,
                        title: '消息发布',
                        maxmin: true,
                        shadeClose: true, //点击遮罩关闭层
                        area: ['400px', '320px'],
                        content: ['${pageContext.request.contextPath}/newhtml.jsp', 'no']
                    });
                });
            });

            function asdf() {
                var param = new Object();
                param.addNewsId = $(this).parents("td").find("#newsId").val();
                param.addCText = $(this).textbox('getText');
//                 alert(addId);
                $.ajax({
                    url: '${pageContext.request.contextPath}/adopt/toMessage/addMessageComment',
                    type: "post",
                    data: param,
                    dataType: 'json',
                    success: function (res) {
                        if (res.judge == 1) {
                            alert("评论成功！");
                            window.location.reload();
                        } else if (res.judge == 2) {
                            alert("您已经评论过了！");
                        } else {
                            alert("评论失败！");
                        }
                    }
                });
            }
        </script>
        <title>消息展示</title>

    </head>
    <body class="body1">
        <div  align="center">
            <div class="easyui-panel" title="投票墙" style="width:604px;overflow:hidden;">

                <c:forEach var="message" items="${sessionScope.messageList }">
                    <table width = "600" align="center" >
                        <tr>
                            <td height="150" colspan="2" background="${message.images }" style="background-size:100%">
                                <h4 height="20%" align="center">${message.titleName }</h4>
                                <table width="100%" height="70%">
                                    <tr>
                                        <td valign="top">
                                            <c:out value="${message.bodyText }" />
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" valign="middle" width = "300" style="white-space:nowrap">
                                <a>${message.nname }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                <a href="#" class="easyui-linkbutton" id="qwer" data-options="iconCls:'icon-good'" style="width:60px">${message.top }</a>
                                <div class="layui-progress layui-progress-big" lay-showPercent="yes" style="width:200px;display:inline-block">
                                    <div class="layui-progress-bar layui-bg-red" lay-percent="50%"></div>
                                </div>
                                <a href="#" class="easyui-linkbutton" id="asdf" data-options="iconCls:'icon-best'" style="width:60px">${message.tread }</a>
                            </td>
                        </tr>
                        <tr>
                            <td align="left" valign="middle" width = "300">
                                <div id="accordionId" class="easyui-accordion" data-options="singleSelect:true,collapsible:true,selected:-1">
                                    <div align="right"  title="评论" style="width:590px;height:150px;">
                                        <table style="width: 100%">
                                            <c:forEach var="comment" items="${message.comments }">
                                                <tr>
                                                    <td >
                                                        <div class="easyui-panel" style="width: 100%">
                                                            <h4>${comment.cText }</h4>
                                                            <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论时间：${comment.time }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论人：${comment.cname }</a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>

                                    </div>
                                </div>
                                <!--带按钮文本框，用easyui样式，按钮点击事件为asdf()-->
                                <input id="sofutext" type="text" style="width: 100%"  class="easyui-textbox" data-options="buttonText:'发送',prompt:'输入评论语',onClickButton:asdf"/>
                                <!--隐藏域，存储当前条信息的ID-->
                                <input type="hidden" id="newsId" name="newsId" value="${message.newsId}"/>
                            </td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </div>
        <div id="u1">
            <img width="50" src="${sessionScope.selectAccount.images }" style=" vertical-align: bottom;">
            <a name="userName2" class="mnav"  href ="${pageContext.request.contextPath}/adopt/toMessage/toCenter">${sessionScope.selectAccount.name }</a>
        </div>
        <div id="u2">
            <a type="" class="easyui-linkbutton" id="newComment" onclick="addComment();">发送信息</a>
        </div>
    </body>
</html>
