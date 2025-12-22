<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ page session="false" %>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${KAKAO_MAP_KEY}&libraries=LIBRARY"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript">
        var contextPath = "<%= request.getContextPath() %>";
        var imagePath = contextPath + "/resources/image/";
    </script>
    <style>
        section{
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
        <div id="map" style="filter: blur(0px);"
             class="blurred-map"></div>
        <div class="overlay">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded" style="width: 100%; height: 750px; ">
                <p class="fs-1"> 🧑‍⚕️ 의료 서비스 🧑‍⚕️</p>
                <p class="fs-3"> 필요한 응급실을 찾아드립니다 </p>
                <div class="select__menu">
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected>입원 병상 선택 </option>
                        <option value="hv36">[응급전용] 입원실 </option>
                        <option value="hvec">[응급실] 일반병상 </option>
                        <option value="hvgc">[입원실] 일반 </option>
                        <option value="hv38">[입원실] 외상 전용</option>
                        <option value="hv4">[입원실] 정형외과 외과입원실 </option>
                        <option value="hv5">[입원실] 신경과 입원실 </option>
                        <option value="hv40">[입원실] 정신과 폐쇄병동 </option>
                    </select>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected> 중환자실 목록 </option>
                        <option value="hv31">[응급전용] 중환자실 </option>
                        <option value="hvicc">[중환자실] 일반 </option>
                        <option value="hvccc">[중환자실] 흉부외과 </option>
                        <option value="hvncc">[중환자실] 신생아 </option>
                        <option value="hvcc">[중환자실] 신경과 </option>
                        <option value="hv2">[중환자실] 내과 </option>
                        <option value="hv3">[중환자실] 외과 </option>
                        <option value="hv6">[중환자실] 신경외과 </option>
                        <option value="hv7">[중환자실] 약물 중환자 </option>
                        <option value="hv8">[중환자실] 화상 </option>
                        <option value="hv9">[중환자실] 외상 </option>
                        <option value="hv34">[중환자실] 심장내과 </option>
                    </select>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected>소아/유아 격리포함 </option>
                        <option value="hv10">VENTI(소아) </option>
                        <option value="hv11">인큐베이터(보육기) </option>
                        <option value="hv28">소아 </option>
                        <option value="hv32">[중환자실] 소아 </option>
                        <option value="hv33">[응급전용] 소아 중환자실 </option>
                        <option value="hv37">[응급전용] 소아 입원실 </option>
                        <option value="hv15">소아 - 일반 격리 </option>
                        <option value="hv16">소아 - 음압 격리 </option>
                        <option value="hv11">인큐베이터(보육기) </option>
                    </select>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected> 수술 및 기타 </option>
                        <option value="hvoc"> 수술실 </option>
                        <option value="hv39"> [외상전용] 수술실</option>
                        <option value="hv42"> 분만실 </option>
                        <option value="hv43"> 화상 전용 처치실 </option>
                    </select>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected> 필요 의료 장비 </option>
                        <option value="hvctayn"> CT </option>
                        <option value="hvmriayn"> MRI </option>
                        <option value="hvangioayn"> 혈관 촬영기 </option>
                        <option value="hvventiayn"> 인공 호흡기 </option>
                        <option value="hvventisoayn"> 조산아 인공 호흡기 </option>
                        <option value="hvincuayn"> 인큐베이터 </option>
                        <option value="hvcrrtayn"> CRRT </option>
                        <option value="hvecmoayn"> ECMO </option>
                        <option value="hvoxyayn"> 고압 산소 치료기 </option>
                        <option value="hvhypoayn"> 중심 체온 조절 유도기 </option>
                    </select>
                    <select class="form-select form-select-lg mb-3" aria-label="Large select example">
                        <option selected> 격리/감염병/코호트 </option>
                        <option value="hv14"> [일반격리] 격리진료구역/일반격리병상 </option>
                        <option value="hv21"> [응급전용] 입원실 일반 격리 </option>
                        <option value="hv30"> 응급실 일반 격리 병상 </option>
                        <option value="hv22"> [감염] 전담병상/중환자실 </option>
                        <option value="hv23"> [감염] 전담병상 중환자실 내 음압격리병상 </option>
                        <option value="hv24"> [감염] 중증 병상 </option>
                        <option value="hv25"> [감염] 준-중증 병상 </option>
                        <option value="hv26"> [감염] 중등증 병상 </option>
                        <option value="hv27"> [코호트] 격리 </option>
                        <option value="hv13"> 격리 진료 구역 음압 격리 병상 </option>
                        <option value="hv17"> [응급전용] 중환자실 음압 격리 </option>
                        <option value="hv18"> [응급전용] 중환자실 일반 격리 </option>
                        <option value="hv19"> [응급전용] 입원실 음압 격리 </option>
                    </select>
                </div>
                <hr class="border border-primary border-3 opacity-75">
                <div id="selectedOptions"></div>
                <form action="/getMatchHospitalData" method="post">
                    <!-- 실제 전송되는 데이터 구간 -->
                    <div id="inputFields"></div>
                    <button type="submit" class="btn btn-primary" style="width: 100%;" id="sendBtn">병원검색</button>
                </form>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script src="<%=request.getContextPath()%>/resources/javascript/kakaoMapApi.js"></script>
<script src="<%=request.getContextPath()%>/resources/javascript/prmPatientInfo.js"></script>
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