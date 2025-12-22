c<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 50%;
            height: 100%;
            margin: 10px 10px 10px 10px;
            border-radius: 30px;
            text-align: center;
            display: flex;
            flex-direction: column;
            padding: 20px;
        }

        .form-floating {
            margin: 10px;
        }

        #map {
            border-radius: 30px;
            border-style: solid;
            width: 99%;
            height: 800px;
            position: relative;
            margin: 0;
        }

    </style>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
    <!-- 환자 차트 -->
    <form action="/HospitalReception" method="post" class="article__chart">
        <h3> 📋 환자 차트 📋</h3>
        <!--성별-->
        <div class="form-floating">
            <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="ptntGender">
                <option selected>성별 선택</option>
                <option value="남성">남성</option>
                <option vlaue="여성">여성</option>
            </select>
        </div>
        <!--나이-->
        <div class="form-floating">
            <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="ptntAge">
                <option selected>나이선택</option>
                <option>신생아 (생후 1달 미만)</option>
                <option>영아 (생후 24개월 미만)</option>
                <option>어린이(만 12세 미만)</option>
                <option>청소년(만 19세 미만)</option>
                <option>성인(만 60세미만)</option>
                <option>고령자(만 60세초과)</option>
            </select>
        </div>
        <!--중증도 분류-->
        <div class="form-floating">
            <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="KTASlevel">
                <option selected>KTAS Level</option>
                <option>KTAS1 : 소생(심정지/중증외상 등)</option>
                <option>KTAS2 : 긴급(호흡곤란, 토혈 등)</option>
                <option>KTAS3 : 응급(경한, 호흡부전 등)</option>
                <option>KTAS4 : 준응급(착란, 요로감염 등)</option>
                <option>KTAS5 : 비응급(상처소독, 약처방 등)</option>
            </select>
        </div>
        <!--사고 원인 분류-->
        <div class="form-floating">
            <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="ptntCause">
                <option selected>추정 원인</option>
                <option>질병</option>
                <option>재해사고</option>
                <option>교통사고</option>
                <option>산업사고</option>
                <option>기타</option>
            </select>
        </div>
        <!--특이사항-->
        <div class="form-floating">
            <textarea class="form-control" id="floatingTextarea2" style="height: 100px" name="ptntNote"></textarea>
            <label for="floatingTextarea">특이사항</label>
        </div>
        <!--응급조치내용-->
        <div class="form-floating">
             <textarea class="form-control" id="floatingTextarea2" style="height: 100px;margin-top: 20px; margin-block-end: 20px;" name="ptntAid"></textarea>
            <label for="floatingTextarea">응급조치내용</label>
        </div>
        <input type="hidden" name="hpid" value="${hpid}"/>
        <button type="submit" class="btn btn-success" style="width: 100%;">병원 접수</button>
    </form>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>