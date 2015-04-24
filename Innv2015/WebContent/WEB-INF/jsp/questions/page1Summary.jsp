<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="summary-page">
	<h2> Summary of your Answers </h2>
	<ul>
		<c:forEach items="${questionAnswerMap}" var="entry">
			<li>${entry.value.left} : <span class="red bold"> ${entry.value.right}</span></li>
		</c:forEach>
	</ul>
	<br>
	<p>Based on your answers your application is Cloud compatible. Below are some of the cloud service providers you can choose from.</p>
	<a href="${contextPath}/cloudSelect/main" class="btn">Choose Cloud</a>
</div>