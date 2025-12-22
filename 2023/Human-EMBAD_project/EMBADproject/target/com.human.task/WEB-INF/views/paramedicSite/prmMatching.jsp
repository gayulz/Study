<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page session="false" %>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${KAKAO_MAP_KEY}&libraries=LIBRARY"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        var contextPath = "<%= request.getContextPath() %>";
        var imagePath = contextPath + "/resources/image/";
    </script>
    <style>
        section {
            width: 100%;
            height: 900px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }


        .overlay {
            position: absolute;
            top: 50%; /* 상단에서 50% 위치 */
            left: 20%; /* 왼쪽에서 65% 위치 (지도의 오른쪽 35% 영역에 오버레이 표시) */
            transform: translate(-50%, -50%);
            width: 35%; /* 너비 35% */
            height: 750px; /* 높이 750px */
            display: flex;
            justify-content: center;
            align-items: center;
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
    <div style="width: 100%; height: 800px">
        <div id="map" style="filter: blur(0px);" class="blurred-map"></div>
        <div class="overlay">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded" style="width: 100%; height: 750px; ">
                <p class="fs-1"> 🏥 병원 목록 🏥 </p>
                <div class="text-success">
                    <hr>
                </div>
                <div class="overflow-scroll" style="height: 600px; overflow-y: auto;">
                    <c:forEach items="${list}" var="list">
                        <form action="/chartReception" method="post">
                            <p class="h3" id="dutyname"> ◼︎ 병원 이름 : ${list.dutyname} </p>
                            <p class="lead"> ${list.dutyAddr} </p>
                            <p class="h5">대표 전화번호 : ${list.dutytel1}</p>
                            <p class="h5">응급실 전화번호 : ${list.dutytel3}</p>
                            <input type="hidden" name="hpid" value="${list.hpid}">
                            <p style="display: none;" name="wgs84Lon" value="${list.wgs84Lon}"> ${list.wgs84Lon}</p>
                            <p style="display: none;" name="wgs84Lat" value="${list.wgs84Lat}"> ${list.wgs84Lat}</p>
                            </button>
                            <button type="submit" class="btn btn-secondary" style="width: 100%;">병원 접수</button>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script src="<%=request.getContextPath()%>/resources/javascript/kakaoMapApi.js"></script>
<script type="text/javascript">
    var hospitalData = [];
    hospitalData = [
        <c:forEach items="${list}" var="hospital" varStatus="status">
        {
            content: '<div style="font-size:17px;">${hospital.dutyname}</div>',
            latlng: new kakao.maps.LatLng(${hospital.wgs84Lat}, ${hospital.wgs84Lon})
        }<c:if test="${!status.last}">, </c:if>
        </c:forEach>
    ];
    addMarkerImage(hospitalData);
</script>
</body>
</html>
