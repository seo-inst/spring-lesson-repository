/**
 Fetch API : 자바스크립트의 표준 비동기 통신 API

 비동기 웹 개발의 두 가지 핵심 개념
 fetch와 async/await

 fetch: 네트워크 요청을 보내는 기능
 async/await: 그 요청의 응답을 다루는 방법


 fetch 의 역할 
 fetch는 Promise를 반환합니다.
 fetch('URL') 함수를 호출하면, 네트워크 요청이 즉시 시작됩니다. 
 이 함수는 요청이 완료될 때까지 기다리지 않고, 
 대신 Promise라는 특별한 객체를 즉시 반환합니다. 
 이 Promise는 "나중에 응답이 도착하면 성공 또는 실패 정보를 알려줄게"라고 
 약속하는 역할을 합니다.

 async 의 역할 
 async 함수는 Promise를 기다릴 수 있습니다.
 async 키워드가 붙은 함수 안에서만 await를 사용할 수 있습니다. 
 이 async 함수는 Promise가 완료될 때까지 자신의 실행을 일시 중지하는 능력을 갖게 됩니다.

 await 의 역할 
 await가 fetch의 Promise를 기다립니다.
 const response = await fetch('URL'); 코드를 보면, 
 await는 fetch가 반환한 Promise가 완료될 때까지 기다립니다. 
 하지만 이때, JavaScript의 메인 스레드는 멈추지 않습니다. 
 asyn 함수 외의 다른 코드들이 계속 실행될 수 있게 해주어 비동기 작업이 가능하게 됩니다 
 서버로부터 응답이 도착하면, fetch가 반환했던 Promise가 '완료' 상태가 됩니다. 
 그러면 await는 const response에 응답 결과를 할당한 뒤 
 async 함수의 다음 코드 라인을 실행하게 됩니다.
 */
async function startAjax(){
	//alert("fetch study");
	let userId = document.getElementById("userId").value;
	let resultDiv = document.getElementById("result");
	
	if(!userId){ // falsy  유효하지 않은 값 , null or 공란 or undefined 등일때 false 	
		alert("사용자 아이디를 입력하세요");
		return;	
	}
	// Ajax 요청 시작 전에 로딩 이미지 표시 
	resultDiv.innerHTML = "<img src=/images/working.gif>";
	// fetch 로 비동기 요청하고 서버가 응답할 때까지 대기 (await) 하다가 응답 완료되면(readyState 4) 실행 재개됨 
	try{
	//  Http Response 의 header 까지 분석되면 실행이 됨 	
	const response = await fetch(`/test-ajax3?userId=${userId}`);
	if(!response.ok){ // Http Response status code 가 200~299 (정상수행) 까지가 아니면 
		throw new Error(`HTTP error status: ${response.status} `);
	}
	// Http Response 의 body(응답 데이터) 를 입력받음
	const data = await response.text();
	resultDiv.innerHTML = `ajax fetch 응답정보 : ${data} `;
	 
	}catch(error){
		console.error("Fetch Error:", error);
		resultDiv.innerHTML = `문제 발생`;
	}
}

console.log("다른 작업 진행...");
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 