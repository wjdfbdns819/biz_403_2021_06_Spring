<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<style>
	div.msg {
		font-size: 10px;
		color: red;
	}	
</style>

<form method="POST">
	<div>
		<label>사용자 ID(Email)</label>
		<input name="m_userid" type="email">
		<div class="msg join id"></div>
	</div>
	
	<div>
		<label>비밀번호</label>
		<input name="m_password" type="password">
	</div>
	
	<div>
		<label>비밀번호 확인</label>
		<input name="re_password" type="password">
	</div>
	
	<div>
		<label>닉네임</label>
		<input name="m_nick">
	</div>
	
	<div>
		<label>전화번호</label>
		<input name="m_tel" type="tel">
	</div>
	
	<div>
		<button>가입신청</button>
	</div>
</form>

<script>
		// input tag에 id가 있을경우 아래와 같은 코드 사용
		//document.querySelector("input#user_id")
		
		//input tag에 id가 없을 경우 아래와 같은 코드 사용
	let user_id = document.querySelector("input[name='m_userid']")
	let msg_user_id = document.querySelector("div.join.id")
	
	if(user_id) {
		// lost focus
		// input tag에 입력하는 도중 다른 tag로 focus가 이동되는 경우
		// blur,focusout event 코드에서
		// alert을 사용하면 lost focus와 alert 사이에서 무한반복이 일어나는 현상이 발생한다
		// lost focus가 되었을때 메시지를 사용자에게 보이고 싶을때는
		// alert을 사용하지 않고 다른 방법을 강구해야 한다
		// 비어있는 div box를 하나 만들고,
		// 그곳에 메시지를 표시하는 방법을 사용한것
		user_id.addEventListener("blur", (e)=>{
			
			let m_userid = e.currentTarget.value
			
			msg_user_id.innerText = ""
			msg_user_id.style.padding = "0"
			
			// m_userid box에 사용자 ID를 입력한 상태로
			// tab키를 누르거나, 다른 값을 입력하기 위하여
			// focus를 이동하면 
			// m_userid box에 입력된 값으로 ID 중복검사 수행하기
			if(m_userid === "") {
				msg_user_id.innerText = " * 사용자 ID는 반드시 입력하세요"
				msg_user_id.style.padding = "5px";
				user_id.focus()
				return false;
			}
			
			fetch("${rootPath}/member/id_check?m_userid=" + m_userid)
			//.then((response)=>{
			//	return response.text()
			//})
			// 위 주석 코드를 줄여서 아래 코드처럼 사용함
			// response를 함수로 받아서 text로 return하라
			.then(response=>response.text())
			// 그 text를 result로 받음
			.then(result=>{
				if(result === "USE_ID") {
					msg_user_id.innerText = " * 이미 가입된 ID 입니다"
					user_id.focus()
					return false
				} else if(result === "NOT_USE_ID") {
					msg_user_id.innerText = " * 가입 가능한 ID 입니다"
					msg_user_id.style.color = "blue"
					
					document.querySelector("input[name='m_password']")
					.focus()
					
				} else {
					msg_user_id.innerText = " * 알수 없는 결과를 수신함"
				}
			})
		}) 
	}
	
</script>