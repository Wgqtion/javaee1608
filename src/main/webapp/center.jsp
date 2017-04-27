<%--
    Document   : center
    Created on : 2017-4-12, 10:19:30
    Author     : 吴广庆
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>个人中心</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/default/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/modules/skin/default/layer.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/layui/css/modules/layer.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
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
                checkQq: {
                    validator: function (value) {
                        if (bQq.test(value)) {
                            return true;
                        } else {
                             return false;
                        }
                    }
                    ,
                    message: '请输入正确的QQ格式'
                }
            }
            );
            function change_photo() {
                PreviewImage($("input[name='imageInput']")[0], 'imagePreview', 'Imgdiv');
            }
            function PreviewImage(fileObj, imgPreviewId, divPreviewId) {
                var allowExtention = ".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
                var extention = fileObj.value.substring(fileObj.value.lastIndexOf(".") + 1).toLowerCase();
                var browserVersion = window.navigator.userAgent.toUpperCase();
                if (allowExtention.indexOf(extention) > -1) {
                    if (fileObj.files) {//HTML5实现预览，兼容chrome、火狐7+等
                        if (window.FileReader) {
                            var reader = new FileReader();
                            reader.onload = function (e) {
                                document.getElementById(imgPreviewId).setAttribute("src", e.target.result);
                            }
                            reader.readAsDataURL(fileObj.files[0]);
                        } else if (browserVersion.indexOf("SAFARI") > -1) {
                            alert("不支持Safari6.0以下浏览器的图片预览!");
                        }
                    } else if (browserVersion.indexOf("MSIE") > -1) {
                        if (browserVersion.indexOf("MSIE 6") > -1) {//ie6
                            document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
                        } else {//ie[7-9]
                            fileObj.select();
                            if (browserVersion.indexOf("MSIE 9") > -1)
                                fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                            var newPreview = document.getElementById(divPreviewId + "New");
                            if (newPreview == null) {
                                newPreview = document.createElement("div");
                                newPreview.setAttribute("id", divPreviewId + "New");
                                newPreview.style.width = document.getElementById(imgPreviewId).width + "px";
                                newPreview.style.height = document.getElementById(imgPreviewId).height + "px";
                                newPreview.style.border = "solid 1px #d2e2e2";
                            }
                            newPreview.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                            var tempDivPreview = document.getElementById(divPreviewId);
                            tempDivPreview.parentNode.insertBefore(newPreview, tempDivPreview);
                            tempDivPreview.style.display = "none";
                        }
                    } else if (browserVersion.indexOf("FIREFOX") > -1) {//firefox
                        var firefoxVersion = parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
                        if (firefoxVersion < 7) {//firefox7以下版本
                            document.getElementById(imgPreviewId).setAttribute("src", fileObj.files[0].getAsDataURL());
                        } else {//firefox7.0+
                            document.getElementById(imgPreviewId).setAttribute("src", window.URL.createObjectURL(fileObj.files[0]));
                        }
                    } else {
                        document.getElementById(imgPreviewId).setAttribute("src", fileObj.value);
                    }
                } else {
                    alert("仅支持" + allowExtention + "为后缀名的文件!");
                    fileObj.value = "";//清空选中文件
                    if (browserVersion.indexOf("MSIE") > -1) {
                        fileObj.select();
                        document.selection.clear();
                    }
                    fileObj.outerHTML = fileObj.outerHTML;
                }
            }



            layui.use('upload', function () {
                layui.upload({
                    url: '' //上传接口
                    , success: function (res) { //上传成功后的回调
                        console.log(res)
                    }
                });
                layui.upload({
                    url: '/test/upload.json'
                    , elem: '#test' //指定原始元素，默认直接查找class="layui-upload-file"
                    , method: 'post' //上传接口的http类型
                    , success: function (res) {
                        imagePreview.src = res.url;
                    }
                });
            });
        </script>
    </head>
    <body>
        <div align="center">
            <div class="easyui-panel" title="个人信息" style="width:500px">
                <form id="accountChenge" name="accountChenge" action="${pageContext.request.contextPath}/adopt/account/accountChenge" enctype="multipart/form-data" method="post">
                    <table cellpadding="5">
                        <tr>
                            <td rowspan="3">
                                <div id="Imgdiv">
                                    <img width="100" id="imagePreview" src="${account.images}"/>
                                </div>
                            </td>
                            <td>用户名：</td>
                            <td>
                                <input class="easyui-textbox" type="text" name="name" id="txtName" value="${account.name}" data-options="prompt:'请输入用户名',required:true,missingMessage:'用户名不能为空'"/>
                            </td>
                        </tr>
                        <tr>
                            <!--<td>2.1</td>-->
                            <td>Q&nbsp;&nbsp;Q：</td>
                            <td>
                                <input class="easyui-textbox" type="text" name="qq" id="txtQq" value="${account.qq}" data-options="itemCls:'请输入QQ号',required:true,missingMessage:'QQ不能为空',validType:'checkQq'"/>
                            </td>
                        </tr>
                        <tr>
                            <!--<td>3.1</td>-->
                            <td>手机号：</td>
                            <td>
                                <input class="easyui-textbox" type="text" name="tel" id="txtTel" value="${account.tel}" data-options="prompt:'请输入手机号',required:true,missingMessage:'手机号不能为空',validType:'phoneRex'"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input class="easyui-filebox" id="imageInput" name="imageInput" data-options="onChange:change_photo,prompt:'浏览...',buttonText:'选择图片'" style="width:100%"/>
                            </td>
                            <td>
                                <input type="submit" id="saveSubmit" value="保存"
                                       style="background-color: #1C5BA6; border: #FFFFFF 1px solid; color: #FFFFFF" />
                                <span id="msgResult" style="color: #FF0000; font-size: 12px"></span>
                            </td>
                            <td>
                                <input type="reset" id="btnSubmit2" value="取消"
                                       style="background-color: #1C5BA6; border: #FFFFFF 1px solid; color: #FFFFFF" />
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
