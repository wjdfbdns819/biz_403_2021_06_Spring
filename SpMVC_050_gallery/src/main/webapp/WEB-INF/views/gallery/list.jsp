<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<style>

div.main_box {
	margin: 20px 0px;
	display: flex;
	flex-wrap: wrap;
	align-items: center;
	justify-content: center;

	
}

div.ga_box {
	width: 30%;
	align-items: center;
	justify-content: center;
	border: 1px solid black; 
	margin: 5px 5px;
	text-align: center;
	

}

div#images {
	border: 1px solid black;
	margin: 0 auto;
	width: 20vw;
	height: 20vh;
	padding: 40px 0px;
}

div#con_box {
	border: 1px solid black;
	margin: 0 auto;
	width: 50%;
}

</style>

<div class="main_box">
<c:forEach items="${GALLERYS}" var="GALLERY">
	<div class="ga_box">
		<div id="images">
			<img src="${rootPath}/files/${GALLERY.g_image}" width="100px" height="100px">
		</div>
		
		<div id="con_box">
			<h3>
				<a href="${rootPath}/gallery/detail/${GALLERY.g_seq}">
					${GALLERY.g_subject}
				</a>
			</h3>
			<p>${GALLERY.g_content}</p>
		</div>
	</div>
</c:forEach>
</div>