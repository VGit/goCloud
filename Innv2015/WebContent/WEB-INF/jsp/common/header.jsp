<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<jsp:useBean id="systemProperties"
	class="com.crgt.innov2015.util.SystemProperties" scope="application" />
<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<button type="button" class="pull-right navbar-toggle"
			data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><i class="fa fa-question"></i> Help</a></li>
				<c:if test="${not empty username}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> ${username} <b class="caret"></b>
					</a>

						<ul class="dropdown-menu">
							<li><a href="${contextPath}/auth/logout">Log Out</a></li>
						</ul></li>
				</c:if>
				<c:if test="${empty username}">
					<li><a href="${contextPath}/auth/login"></i> Home</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<input type="hidden" id="contextPathForJS" value="${contextPath}" />



