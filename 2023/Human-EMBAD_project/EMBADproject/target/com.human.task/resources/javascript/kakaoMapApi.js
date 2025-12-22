/** 현재 위치 가져오기 */
if (navigator.geolocation) {
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.watchPosition(function(position) {
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        var locPosition = new kakao.maps.LatLng(lat, lon),
            message = '<div style="padding:5px;">현재 위치</div>'; // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);
    });
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
        message = 'geolocation을 사용할수 없어요..'
    displayMarker(locPosition, message);
}


var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 7 // 지도의 확대 레벨
    };
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {
    let myMarkerSrc = imagePath + 'marker2.png';
    let imageSize = new kakao.maps.Size(50, 50);
    let myMarkerImage  = new kakao.maps.MarkerImage(myMarkerSrc, imageSize);
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: locPosition,
        image : myMarkerImage
    });

    var iwContent = message, // 인포윈도우에 표시할 내용
        iwRemoveable = true;
    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        removable : iwRemoveable
    });
    // 인포윈도우를 마커위에 표시합니다
    infowindow.open(map, marker);
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);
}


function addMarkerImage(hospitalData){
    var positions = hospitalData;
    for (var i = 0; i < positions.length; i ++) {
        let imageSrc = imagePath + 'marker1.png';
        var imageSize = new kakao.maps.Size(50, 50);
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
        var marker = new kakao.maps.Marker({
            map: map,
            position: positions[i].latlng,
            image : markerImage
        });

        //인포 윈도우 생성
        var infowindow = new kakao.maps.InfoWindow({
            content : positions[i].content
        });

        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
    }
}


// 인포윈도우를 표시하는 클로저를 만드는 함수입니다
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

// 인포윈도우를 닫는 클로저를 만드는 함수입니다
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}
