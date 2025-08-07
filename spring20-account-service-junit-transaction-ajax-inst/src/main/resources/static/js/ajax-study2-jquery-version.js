/**
 *  jQuery :  대표적인 자바 스크립트 라이브러리 
 * jquery 의 document ready 란  자바스크립트 dom 객체가 로드되면 실행되는 함수 
 * ready 에 명시하는 익명 함수로  현 document 즉 웹페이지의 이벤트 핸들러를 일괄 바인딩(등록)
 */
$(document).ready(function(){
		//alert("hello jquery ajax");
		// id 에 해당하는 버튼에 클릭 이벤트가 발생했을 때 동작할 익명 함수를 등록 
		$("#jQueryAjaxBtn").click(function(){
			//alert("hello jquery select btn");
			// 텍스트 필드에 저장한 사용자 아이디를 가져온다 
			let userId = $("#userId").val();
			if(userId === ""){
				alert("아이디를 입력하세요");
				return;
			}
			// 사용자가 버튼을 누르는 즉시 서버 요청에 대한 응답이 오기 전까지 아래 이미지를
			// result div 에 보여준다 
			$("#result").html("<img src='/images/working.gif'>");
			
			$.ajax({
				type:"GET",
				url:"/test-ajax2",
				data: {userId:userId},
				success:function(response){ // callback 함수의 매개변수로 응답 정보가 들어온다
					$("#result").text("ajax 응답 정보:"+response);
				}	
			});// ajax
		});// click 
});// document ready






