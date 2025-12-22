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
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
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

        #loginBox {
            width: 100%;
            display: flex;
            flex-direction: row;
            justify-content: left;
            align-items: center;
        }

        .form-check {
            display: flex;
            align-items: center;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<section>
    <div style="width: 100%; height: 800px">
        <div id="map" style="width: 100%; height: 800px; position: relative; filter: blur(5px);"
             class="blurred-map"></div>
        <div class="overlay">
            <div class="shadow p-3 mb-5 bg-body-tertiary rounded" style="width: 30%; height: 450px;">
                <form class="articleLogin" action="/prmLogins" method="post">
                    <p class="fs-2">Login</p>
                    <div id="loginBox">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="userType" value="1" id="flexRadioDefault1">
                            <label class="form-check-label" for="flexRadioDefault1">
                                응급구조사
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="userType" value="2" id="flexRadioDefault2"
                                   checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                                병원관계자
                            </label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Email</label>
                        <input type="email" class="form-control" id="exampleFormControlInput1"
                               placeholder="name@example.com" name="staffEmail">
                        <label for="inputPassword5" class="form-label">Password</label>
                        <input type="password" id="inputPassword5" class="form-control"
                               aria-describedby="passwordHelpBlock" name="staffPass">
                    </div>
                    <button type="submit" class="btn btn-outline-primary">로그인</button>
                </form>
                <a class="icon-link icon-link-hover" onclick="joinus()">
                    회원가입
                    <svg class="bi" aria-hidden="true">
                        <use xlink:href="#arrow-right"></use>
                    </svg>
                </a>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
<script type="text/javascript">
    var mapContainer = document.getElementById('map'),
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3 // 지도의 확대 레벨
        };
    var map = new kakao.maps.Map(mapContainer, mapOption);

    function joinus() {
        // 라디오 버튼들을 가져옵니다.
        var radioButtons = document.getElementsByName('userType'); // 'type'이 아닌 'userType'으로 수정
        var selectedType = '';
        // 선택된 라디오 버튼의 값을 찾습니다.
        for (var i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].checked) {
                selectedType = radioButtons[i].value;
                break;
            }
        }
        // URL 생성 부분 수정
        location.href = "<%=request.getContextPath()%>/signUp?userType=" + selectedType;
    }
</script>
</body>
</html>