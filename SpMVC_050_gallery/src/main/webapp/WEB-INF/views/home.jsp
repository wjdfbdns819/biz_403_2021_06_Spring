<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	/*초기화*/
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

h1 {
	width: 70%;
	border: 1px solid black;
	text-align: center;
	font-weight: bold;
	margin: 0 auto;
	padding: 10px 0px;
}

div#image_link  {
	width: 10%;
	margin-left: 85%;
	padding: 10px 0px;
	border: 1px solid black;
	text-align: center;
}

</style>
</head>
<body>
	<h1>내 갤러리</h1>
	<c:choose>
		
		<c:when test="${BODY eq 'GA-INPUT'}">
			<%@ include file="/WEB-INF/views/gallery/input.jsp" %>
		</c:when>
		<c:when test="${BODY eq 'GA-LIST'}">
			<%@ include file="/WEB-INF/views/gallery/list.jsp" %>
			<div id="image_link" ><a href="${rootPath}/gallery/input">이미지등록</a></div>
		</c:when>
		
		<c:when test="${BODY eq 'GA-DETAIL'}">
			<%@ include file="/WEB-INF/views/gallery/detail.jsp" %>
			<a href="${rootPath}/gallery">리스트로</a>
		</c:when>
		
		<c:otherwise>
					<a href="${rootPath}/gallery/input">이미지등록</a>
			</c:otherwise>
			
	</c:choose>
	
	
	<c:forEach items="${FILES}" var="FILE">
		<a href="${rootPath}/files/${FILE}" target="_NEW">
			<img src="${rootPath}/files/${FILE}" width="100px" height="100px"/>
		</a>
	</c:forEach>
	
	

</body>
</html>