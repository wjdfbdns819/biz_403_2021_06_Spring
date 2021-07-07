<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<style>
form {
	width: 90%;
	margin: 0 auto;
	border: 1px solid black;
	align-items: center;
	justify-content: center;
	text-align: center;
}

form div { 
 	width: 60%;
 	margin: 0 auto;
}

div#file_save {
	border: 1px solid black;
	width: 80%;
	display: flex;
	margin-top: 15px; 
}

div#file_input {
	border: 1px solid black;
	margin-top: 15px;
}

div#file_input div {
	
	margin-top: 15px;
	display: inline-block;
	text-align: left;

}

label {
	
	
	
}

div.btn {
	display: inline-block;
	width: 60%;
	border: 1px solid black;
	text-align: right;
	 
}

</style>

<form method="POST" enctype="multipart/form-data">

	<div id="file_save">
		<div>
			<label>대표이미지</label> <input type="file" name="one_file">
		</div>

		<div>
			<label>갤러리</label> <input type="file" multiple="multiple"
				name="m_file">
		</div>
	</div>

	<div id="file_input">
		<div>
			<label>작성자</label> <input name="g_wirter" value="${CMD.g_wirter}">
		</div>
	
		<div>
			<label>작성일자</label> <input name="g_date" value="${CMD.g_date}">
		</div>
	
		<div>
			<label>작성시각</label> <input name="g_time" value="${CMD.g_time}">
		</div>
	
		<div>
			<label>제목</label> <input name="g_subject">
		</div>
	
		<div>
			<label></label>
			<textarea name="g_content"></textarea>
		</div>
	</div>

	<div class="btn"><button>전송</button></div>
</form>