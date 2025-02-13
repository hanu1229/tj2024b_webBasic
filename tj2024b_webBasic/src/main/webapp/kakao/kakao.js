
/* ================= 클릭한 위치에 마커 표기하기 ================= */
/*
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.490971865125374, 126.72073929759203), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
	
	console.log(message);
    
});
*/

/* ================= 마커에 클릭 이벤트 등록하기 ================= */
/*
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
  
// 마커를 표시할 위치입니다 
var position =  new kakao.maps.LatLng(33.450701, 126.570667);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
  position: position,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
});

// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
// marker.setClickable(true);

// 마커를 지도에 표시합니다.
marker.setMap(map);

// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      // infowindow.open(map, marker);
	  alert("마커를 클릭했군요.");
	  // 이쪽에 이벤트를 구현해야한다.
});
*/

/* ================= 여러개 마커 표시하기 ================= */
/*
var mapContainer = document.querySelector('#map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨 숫자가 높을수록 축소(0 ~ 14)
    };
// 설정된 지도 정보를 map 변수에 저장 1: 지도를 표시할 div, 2. 중심좌표/지도확대축소
var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
// 마커를 표시할 위치와 title 객체 배열입니다 , 활용 : fetch 이용하여 마커에 표시할 위도 경도
var positions = [
    {
        title: '카카오', 
        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
    },
    {
        title: '생태연못', 
        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
    },
    {
        title: '텃밭', 
        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
    },
    {
        title: '근린공원',
        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
    },
	{
		title: '컴퓨터학원',
		latlng: new kakao.maps.LatLng(37.490971865125374, 126.72073929759203)
	}
];

// 마커 이미지의 이미지 주소입니다
var imageSrc = "C://Users/tj-bu-702-12/Desktop/hanu1229/tj2024b_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TeamProject02/img/logo.png ";
// C://Users/tj-bu-702-12/Desktop/hanu1229/tj2024b_web/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TeamProject02/img/logo.png 
// https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png

for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
	// 마커에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      // infowindow.open(map, marker);
		  alert(`마커를 클릭했군요.`);
		  // 이쪽에 이벤트를 구현해야한다.
	});
*/

/* ================= 마커 클러스터러 사용하기 ================= */
// 카카오 최초 실행 시 중심좌표와 확대 레벨을 설정
// Geolocation API : 접속된 유저의 좌표(권한 설정 필요)
var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
	center : new kakao.maps.LatLng(36.2683, 127.6358), // 지도의 중심좌표 
	level : 14 // 지도의 확대 레벨 
});
   
// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
	map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
	averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
	minLevel: 10 // 클러스터 할 최소 지도 레벨 
});

// 데이터를 가져오기 위해 jQuery를 사용합니다
// 데이터를 가져와 마커를 생성하고 클러스터러 객체에 넘겨줍니다
// $.get(jquery문법) = $.get('http주소', function(data) => {}) VS fetch() VS axios() VS ajaxs()
// $.get("통신할 주소", function(data) {})
// fetch("통신할 주소", {}).then().then().catch()
// 통신할 주소 : 1. 서블릿 주소, 2.
let url = "https://api.odcloud.kr/api/15051492/v1/uddi:852bbc11-63ed-493e-ab09-caaaf54fd144?page=1&perPage=35&serviceKey=nwPZ%2F9Z3sVtcxGNXxOZfOXwnivybRXYmyoIDyvU%2BVDssxywHNMU2tA55Xa8zvHWK0bninVkiuZAA4550BDqIbQ%3D%3D";
/*
$.get(url, function(data) {
	
	console.log(data);
	// 데이터에서 좌표 값을 가지고 마커를 표시합니다
	// 마커 클러스터러로 관리할 마커 객체는 생성할 때 지도 객체를 설정하지 않습니다
	// $(리스트).map(function(인덱스, 반복변수명) {return})
	// 리스트명.forEach((인덱스, 반복변수명) => {})
	var markers = $(data.data).map(function(i, position) {
	    return new kakao.maps.Marker({
	        position : new kakao.maps.LatLng(position.위도, position.경도)
	    });
	});

	// 클러스터러에 마커들을 추가합니다
	clusterer.addMarkers(markers);
	
});
*/
// $.get()을 fetch()로 변경
const option = {method : "GET"};
fetch(url, option)
.then(response => response.json())
.then(data => {
	console.log(data);
	
	// map() 사용
	let markers = data.data.map(position => {
		// 1개의 마커를 생성 후 변수에 저장
		let marker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
		// 마커에 클릭 이벤트를 등록
		kakao.maps.event.addListener(marker, 'click', function() {
			document.querySelector(".약국명").innerHTML = position.약국명;
			document.querySelector(".전화번호").innerHTML = position.전화번호;
			document.querySelector(".주소").innerHTML = position.소재지도로명주소;
			document.querySelector(".사이드바").click();
			
		});
		// 마커 이벤트 등록 후 반환/리턴
		return marker;
	});
	
	/*
	// forEach() 사용
	data.data.forEach(position => {
		let maker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
		makerList.push(maker);
	});
	*/
	
	/*
	// for문 사용
	let makerList = [];
	for(let index = 0; index < data.data.length; index++) {
		let position = data.data[index];
		let maker = new kakao.maps.Marker({position : new kakao.maps.LatLng(position.위도, position.경도)});
		makerList.push(maker);
	}
	*/
	
	// map() 사용시
	clusterer.addMarkers(markers);
	// for문 forEach() 사용시
	//clusterer.addMarkers(makerList);
})
.catch(error => { console.log(error); });





