<%--
  Created by IntelliJ IDEA.
  User: why19991031
  Date: 2020/12/20
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*,bean.Book" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>选择书本</title>
    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
</head>
<style>
    div.chooseBookPage{
        background-color: #E9EEF1;
    }
    div.topDiv{
        height: 60px;
        background-color: #3498DB;
        margin-top: 10px;
    }
    div.topDiv img{
        height: 60px;
    }
    div.topDiv img.ImageInfo{
        margin-left: -30px;
    }
    div.topDiv span.title{
        margin-top: 10px;
        margin-bottom: 15px;
        margin-left: 10px;
        font-size: 30px;
        font-family: 楷体;
        font-weight: bold;
        color: white;
    }
    div.topDiv a{
        margin-left: 25px;
        margin-top: 20px;
        margin-bottom: 20px;
        line-height: 20px;
        font-size: 18px;
        font-family: Arial;
        color: #CED1D2;
        text-decoration: none;
    }
    div.topDiv .floatleft{
        float: left;
    }
    div.topDiv span.rightfloat{
        float: right;
        margin-top: 15px;
        margin-right: 15px;
        font-size: 18px;
        font-family: Arial;
        color: #EBF1F3 ;
    }
    div.topDiv a:hover{
        color: #C40000;
    }
    div.actionMenuAndChooseBookDiv{
        height: 450px;
        margin-top: 9px;
    }
    div.actionMenu{
        width: 35%;
        float: left;
        padding-top: 40px;
        text-align: center;
    }
    div.actionMenu a{
        display: block;
        margin-top: 38px;
        text-decoration: none;
    }
    div.actionMenu a:hover{
        color: #C40000;
        text-decoration: none;
    }
    div.actionMenu span.action{
        font-size: 20px;
        font-weight: bold;
        font-family: Arial;
    }
    div.chooseUnitDiv{
        overflow: hidden;
        text-align: center;
    }
    div.chooseUnitDiv div.chooseBook{
        margin-top: 28px;
        font-weight: bold;
        font-size: 21px;
        font-family: 黑体;
    }
    div.chooseUnitDiv div.selectionWay{
        font-size: 13px;
        font-family: Arial;
        margin-top: 8px;
    }
    div.chooseUnitDiv select.chooseWay{
        width: 390px;
        height: 30px;
        margin-top:10px ;
    }
    div.chooseUnitDiv input{
        margin: 10px auto;
        width: 48%;

    }
    div.chooseUnitDiv div.choosedBookDiv div.choosedBookList{
        margin-top: 18px;
        font-size: 16px;
        font-weight: bold;
        font-family: Arial;
    }
    div.chooseUnitDiv div.choosedBookDiv{
        height: 210px;
        overflow-x: hidden;
        overflow-y: auto;
    }
    div.bookCategory div.category{
        width: 20%;
        float: left;
        background-color: #7E8688;
        text-align: center;
    }
    div.bookCategory div.category span.categoryname{
        font-size: 20px;
        font-weight: bold;
        display: block;
    }
    div.bookCategory div.category a{
        color: #333333;
        text-decoration: none;
        display: block;
    }
    div.bookCategory div.category a:hover{
        color: #C40000;
        text-decoration: none;
    }
    div.copyright{
        height: 30px;
        text-align: center;
    }
    div.copyright span{
        font-size: 20px;
        font-weight: bold;
        font-family: Arial;
        color: white;
        display: block;
        background-color: #0f0f0f;
    }
</style>
<%
    if(session.getAttribute("user")==null)
        response.sendRedirect("HomePage.html");
%>
<div class="chooseBookPage">
    <div class="topDiv">
    <span class="sudaImage floatleft">
        <img src="sudatarget.png" class="ImageTarget">
        <img src="suda.png" class="ImageInfo">
    </span>
        <span class="title floatleft">图书储存管理系统</span>
        <a href="#nowhere" class="floatleft"><span class="Menu">使用说明</span></a>
        <a href="#nowhere" class="floatleft"><span class="Menu">系统功能</span></a>
        <span class="rightfloat"><%=session.getAttribute("user")%></span>
        <span class="rightfloat">使用者：</span>
    </div>
    <div class="actionMenuAndChooseBookDiv">
        <div class="actionMenu">
            <a href="addBook.jsp"><span class="glyphicon glyphicon-list"></span><span class="action">添加书本</span></a>
            <a href="chooseBook.jsp"><span class="glyphicon glyphicon-list"></span><span class="action">查找书本</span></a>
            <a href="deleteBook.jsp"><span class="glyphicon glyphicon-list"></span><span class="action">删除书本</span></a>
            <a href="updateBook.jsp"><span class="glyphicon glyphicon-list"></span><span class="action">修改书本信息</span></a>
            <a href="listBook"><span class="glyphicon glyphicon-list"></span><span class="action">总览书本信息</span></a>
        </div>
        <div class="chooseUnitDiv">
            <div class="chooseBook">查询书本</div>
            <form action="chooseBook" method="post">
                <div class="selectionWay">查询方式</div>
                <select name="way" class="chooseWay">
                    <option>ID</option>
                    <option>名称</option>
                    <option>类别</option>
                    <option>具体入库时间</option>
                </select>
                <input type="text" name="info" class="form-control" placeholder="输入查询信息">
                <button type="submit" class="btn btn-primary">查找</button>
                <button type="reset" class="btn btn-primary">重置</button>
            </form>
            <div class="choosedBookDiv">
                <div class="choosedBookList">查询到的书本</div>
                <table class="table">
                    <tr>
                        <td>书本ID</td>
                        <td>书本名称</td>
                        <td>书本类别</td>
                        <td>入库时间</td>
                        <td>修改书本信息</td>
                        <td>删除</td>
                    </tr>
                    <c:if test="${!empty choosebooks}">
                        <c:forEach items="${choosebooks}" var="book" varStatus="st">
                            <tr>
                                <td>${book.id}</td>
                                <td>${book.name}</td>
                                <td>${book.kind}</td>
                                <td>${book.time}</td>
                                <td><a href="editBook?id=${book.id}">编辑</a></td>
                                <td><a href="deleteBook?id=${book.id}">删除</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
        </div>
    </div>
    <div class="bookCategory">
        <div class="category">
            <span class="categoryname">科研论文</span>
            <a href="#nowhere"><span class="show">中文期刊</span></a>
            <a href="#nowhere"><span class="show">国外期刊</span></a>
            <a href="#nowhere"><span class="show">顶级会议</span></a>
            <a href="#nowhere"><span class="show">学生论文</span></a>
        </div>
        <div class="category">
            <span class="categoryname">科普读物</span>
            <a href="#nowhere"><span class="show">社会科学</span></a>
            <a href="#nowhere"><span class="show">基础学科</span></a>
            <a href="#nowhere"><span class="show">传统工科</span></a>
            <a href="#nowhere"><span class="show">新兴科学</span></a>
        </div>
        <div class="category">
            <span class="categoryname">课外杂志</span>
            <a href="#nowhere"><span class="show">读者</span></a>
            <a href="#nowhere"><span class="show">译林</span></a>
            <a href="#nowhere"><span class="show">三联周刊</span></a>
            <a href="#nowhere"><span class="show">young刊物</span></a>
        </div>
        <div class="category">
            <span class="categoryname">各类小说</span>
            <a href="#nowhere"><span class="show">侦探小说</span></a>
            <a href="#nowhere"><span class="show">爱情小说</span></a>
            <a href="#nowhere"><span class="show">玄幻小说</span></a>
            <a href="#nowhere"><span class="show">历史小说</span></a>
        </div>
        <div class="category">
            <span class="categoryname">杂文散文</span>
            <a href="#nowhere"><span class="show">三毛散文</span></a>
            <a href="#nowhere"><span class="show">鲁迅杂文</span></a>
            <a href="#nowhere"><span class="show">吴航宇散文</span></a>
            <a href="#nowhere"><span class="show">龙应台散文</span></a>
        </div>
    </div>
    <div class="copyright">
        <span>版权所有：1827406023吴航宇</span>
    </div>
</div>
</html>
