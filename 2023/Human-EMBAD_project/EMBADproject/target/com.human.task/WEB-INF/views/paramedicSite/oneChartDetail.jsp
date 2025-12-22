<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page session="false" %>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        section {
            margin: 10px 10px 10px 10px;
            width: 100%;
            height: 800px;
            display: flex;
            flex-direction: row;
            justify-content: center;
        }

        .article__chart {
            width: 35%;
            height: 100%;
            margin: 10px 10px 10px 10px;
            display: flex;
            flex-direction: column;
        }

        .mb-3{
            display: flex;
            flex-display: row;
        }

        .form-label{
            width: 30%;
        }

        .form-control{
            width: 69%;
        }
    </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
    <!-- 환자 차트 -->
    <form action="/deleteChart" method="post" class="article__chart">
        <c:set var="vo" value="${vo}" scope="request"/>
        <h3> 📋 환자 차트 📋</h3>
        <div style="height: 20px;"></div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">접수 날짜</label>
            <input type="text" class="form-control" placeholder="${vo.ptntDate}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">차트 번호</label>
            <input type="text" class="form-control" name="ptntNumber" value="${vo.ptntNumber}"
                   placeholder="${vo.ptntNumber}"
                   readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">환자 성별</label>
            <input type="text" class="form-control" placeholder="${vo.ptntGender}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">환자 추정 나이</label>
            <input type="text" class="form-control" placeholder="${vo.ptntAge}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">KTAS level</label>
            <input type="text" class="form-control" placeholder="${vo.KTASlevel}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">추정 원인</label>
            <input type="text" class="form-control" placeholder="${vo.ptntCause}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">응급 조치 내용</label>
            <input type="text" class="form-control" placeholder="${vo.ptntNote}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">응급 구조사 이름</label>
            <input type="text" class="form-control" placeholder="${vo.staffName}" readonly>
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">응급 구조사 연락처</label>
            <input type="text" class="form-control" placeholder="${vo.staffPhone}" readonly>
        </div>
        <button type="submit" class="btn btn-success" style="width: 100%;"> 처리 완료</button>
    </form>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
