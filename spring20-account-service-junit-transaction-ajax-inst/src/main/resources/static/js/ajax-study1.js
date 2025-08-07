/**
 *   ajax basic study1 을 위한 자바 스크립트 
 */
//alert("hello ajax");
function startAjax(){
	let xhr = new XMLHttpRequest();//비동기 자바스트립트 통신 객체 
	//console.log(xhr);
	// readystate (요청부터 응답완료까지의 상태) 가 변화가 있을 때 움직이는 
	// 객체임.  여기에 우리가 만든 콜백 함수를 등록 
	// 콜백 함수는 응답 완료되면 동작되는 함수를 지칭
	// callback  의 사전적 의미는 작업 다 되면 나중에 불러줄께  
	xhr.onreadystatechange=function(){// readystate 즉 상태 변화되면 실행됨
		// readyState 는 응답 완료   ,  status 가 200 대이면 정상 수행  
		if(xhr.readyState === 4 && xhr.status>=200 && xhr.status < 300){
			// responseText : 서버로부터 응답받은 정보 
			alert("call back 서버로부터 받은 응답 :"+xhr.responseText);
		}//if
	}//callback
	let userId = document.getElementById("userId").value;
	if(userId === ""){
		alert("아이디를 입력하세요");
		return; // 함수 실행 중단 , 즉 ajax 통신을 하지 않는다 
	}
	xhr.open("get","/test-ajax1?userId="+userId);  // 서버에 비동기 요청을 위한 함수
	xhr.send(); // 요청을 보낸다  
}










