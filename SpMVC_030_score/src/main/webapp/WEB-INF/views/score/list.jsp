<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>
/*
button.score.insert {
	background-color: rgba(0, 0, 200, 1);
	color: white;
}

button.score.student {
	background-color: orange;
	color: white;
}
*/
</style>
<h1>성적 list</h1>
<table class="score_list detail">
	<tr id="title">
		
		<th>학번</th>
		<th>이름</th>
		<th>과목코드</th>
		<th>과목</th>
		<th>점수</th>
	</tr>

	<c:choose>
		<c:when test="${empty scAllList}">
			<tr>
				<td colspan="6">데이터가 없음</td>
			</tr>
		</c:when>

		<c:otherwise>
			<c:forEach items="${scAllList}" var="SC">
				<tr data-stnum="${SC.sc_stnum}">
					
					<td>${SC.sc_stnum}</td>
					<td>${SC.sc_stname}</td>
					<td>${SC.sc_sbcode}</td>
					<td>${SC.sc_sbname}</td>
					<td class="number">${SC.sc_score}</td>
				<tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<div class="btn_box">
	<button class="score insert">성적등록</button>
	<button class="score student list">학생정보 바로가기</button>
</div>

<script>
	
</script>
