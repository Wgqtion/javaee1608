<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/modules/skin/default/layer.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/myjs/jquery-1.11.0.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
        <script type="text/javascript" language="javascript">
            layui.use('upload', function () {
                layui.upload({
                    url: '${pageContext.request.contextPath}/adopt/toMessage/addImge'
                    , elem: '#fileimg' //指定原始元素，默认直接查找class="layui-upload-file"
                    , method: 'post' //上传接口的http类型
                    , dataType: 'json'
                    , success: function (res) {
                        var imguil = '<img src="' + res.fileimg + '" style="width:90px"/>';
                        layer.tips(imguil, '#fileimg', {
                            tips: [3, '#ffffff']
                            , time: 0
                        });
                    }
                });
            });

        </script>
    </head>
    <body>
        <a class="layui-icon"  />
        <div style="width:300px;" >
            <div style="display:block; padding-bottom:10px;" align="center"  >
                <table border="0" >
                    <tr>
                        <td  colspan="2">
                            <input id="title" name="title" class="easyui-textbox" style="width: 300px" data-options="prompt:'请输入标题'"/>
                        </td>
                    </tr>
                    <tr>
                        <td  colspan="2">
                            <input id="textbody" name="textbody" class="easyui-textbox" data-options="multiline:true" data-options="prompt:'正文。。。。'" style="width:300px;height:100px"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="file" id="fileimg" name="fileimg" lay-ext="jpg|png|gif" class="layui-upload-file"/>
                        </td>
                        <td>
                            <a id="saveButton" name="saveButton" class="easyui-linkbutton">保存</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>

