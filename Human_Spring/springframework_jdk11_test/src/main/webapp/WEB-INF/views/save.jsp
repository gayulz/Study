<%--
  Created by IntelliJ IDEA.
  User: yuuri
  Date: 12/26/23
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 회원 가입 </title>
    <style>
        body{
            display: block;
            width: 100%;
        }

        form{
            display: block;
            width: 100%;
        }
        input{
            width: 50%;
        }
    </style>
</head>
<body>
    <form action="/member/save" method="post">
        <input type="text" name="memberEmail" placeholder="이메일">
        <hr>
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <hr>
        <input type="text" name="memberName" placeholder="이름">
        <hr>
        <input type="text" name="memberAge" placeholder="나이">
        <hr>
        <input type="text" name="memberMobile" placeholder="전화번호">
        <hr>
        <input type="submit" value="회원가입">
    </form>
</body>
</html>
