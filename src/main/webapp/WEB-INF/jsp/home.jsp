<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("title", "主页"); %>
<%@ include file="./modules/web-header.jsp" %>
<%@ include file="./modules/header.jsp" %>
<div class="container" style="margin-top: 60px;margin-bottom: 20px;">
    <h1>Bravo！</h1>


    <div region="center">
        <div class="easyui-tabs" fit="true" border="false" id="tabs">
                <div align="center" style="padding-top: 20px;"><a href="https://github.com/bilibiliAD/ssm-redis"
                                                                  target="_blank"
                                                                  style="font-size: 20px;">Gitub仓库地址</a></div>
                <div align="center" style="padding-top: 50px">
                    <font color="grey" size="10">ssm整合Redis demo</font>
                </div>
            </div>
    </div>


     <hr> &copy;2018 - NFC
</div>
<%@ include file="./modules/javascript.jsp" %>
<%@ include file="./modules/web-footer.jsp" %>