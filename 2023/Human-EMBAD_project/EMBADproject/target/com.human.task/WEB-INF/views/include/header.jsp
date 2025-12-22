<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8e177732d47319ec2f4aa804cab6979e"></script>
    <title>응급구조사와 응급실 연계 시스템</title>
    <style>
        *{
            margin:10px;
            padding:0px;
            box-sizing: border-box;
        }

        body{
            display: inline-block;
            display: block;
        }

        .header{
            width: 100%;
            height: 100px;
            display: flex;
            flex-direction: row;
            justify-items: space-between;
            align-items: center;
            text-align: center;
        }

        #header__left{
            display: flex;
            height: 100%;
            width: 30%;
        }

        #headerImg{
            background-image: url("<%=request.getContextPath()%>/resources/image/headers.png");
            width: 79px;
            height: 80%;
            background-size:contain;
        }

        #header__right{
            display: flex;
            width: 60%;
            font-size: 20px;
        }

        #title{
            display: flex;
            align-items: center;
            font-size: 30px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="header">
    <div id="header__left">
        <div id="headerImg"> </div>
        <div id="title"> EMBAD </div>
    </div>
    <div style="width: 40%;"></div>
    <div id="header__right">
        <div>
            <a class="nav-link" aria-current="page" href="/navMenu1Page"> 응급실 찾기 </a>
        </div>
        <div>
            <a class="nav-link" href="/navMenu2Page" >병원 접수 내역</a>
        </div>
        <div>
            <a class="nav-link " href="/navMenu3Page" aria-disabled="true">정보 변경</a>
        </div>
        <div>
            <a class="nav-link" href="/logout" aria-disabled="true">로그아웃</a>
        </div>
    </div>
</div>
<p class="placeholder-wave">
    <span class="placeholder col-12 bg-primary"></span>
</p>
</body>
