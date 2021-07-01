<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<c:forEach items="${NEWS_LIST}" var="NEWS">
	<div class="content">
		<div>
			<p class="title">
				<a href="${NEWS.link}" target="_NEW"> ${NEWS.title} </a>
			</p>
			<p class="desc">${NEWS.description}</p>
			<p class="link">
				<a href="${NEWS.link}" target="_NEW">네이버바로가기</a>
			</p>
			<p class="origin">
				<a href="${NEWS.originallink}" target="_NEW">언론사바로가기</a>
			</p>
			<p class="pubdate">
				<strong>날짜 : </strong>${NEWS.pubDate}
			</p>
			
			
		</div>
	</div>
</c:forEach>
