<%--
    Document   : admin_index
    Created on : 2017-4-10, 16:32:54
    Author     : 吴广庆
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
        <script language="javascript" type="text/javascript">

        </script>
        <title>消息展示</title>

    </head>
    <body class="body1">
        <div  align="center">
            <div class="easyui-panel" title="投票墙" style="width:604px;overflow:hidden;">
                <c:forEach var="message" items="${sessionScope.messageList }">
                    <table width = "600" align="center" >
                        <tr>
                            <td height="150" colspan="2" background="${message.images }">
                                <c:out value="${message.bodyText }" />
                            </td>
                        </tr>
                        <tr>
                            <td align="right" valign="middle" width = 300">
                                <a href="#" class="easyui-linkbutton" id="qwer" data-options="iconCls:'ico_good'">${message.top }</a>
                                <a href="#" class="easyui-linkbutton" id="asdf" data-options="iconCls:'ico_best'">${message.tread }</a>
                            </td>
                        </tr>
                        <tr>
                            <td align="left" valign="middle" width = "300">

                                <div class="easyui-accordion" data-options="singleSelect:true,collapsible:true,selected:-1">
                                    <div align="right"  title="评论" style="width:590px;height:150px;">
                                        <table>
                                            <c:forEach var="comment" items="${message.comments }">
                                                <tr>
                                                    <td align="right">
                                                        <h4>${comment.cText }</h4>
                                                        <a>评论时间：${comment.time }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;评论人：${comment.cname }</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                </div>


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


    </body>
</html>
