<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}

.top-buffer {
	margin-top: 60px;
}
</style>

<div class="clearfix">
	<div class="row">
		<div id="login-box">
			<div class="envelope">
				<div class="envelope-inner" style="height: 300">
					<br><a href="${contextPath}/guest/start"> <img
						src="${contextPath}/resources/images/cloudornot.png" height="33"
						width="204" />
					</a><br> <br><br><a href="${contextPath}/cloudSelect/main"> <img
						src="${contextPath}/resources/images/whichcloud.png" height="33"
						width="204" class="pull-right"/>
					</a> <br><br><br><a href="${contextPath}/cloudSelect/getMigrateParam"> <img
						src="${contextPath}/resources/images/deploytocloud.png"
						height="33" width="204" /><br><br>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<style>
a.clickbox {
	width: 400px;
	height: 455px;
	border: 1px solid #0074c2;
	background-color: offwhite;
}
</style>