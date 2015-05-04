<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<br><br>
<div id="feedbackTemplate"><p>Your application
	is migrating to <span class="red"><b>${cloudname}</b></span>. Your confirmation number is
	<span class="red"><b>${confirmNum}</b></span>. You will receive an email after the migration.</p></div>

<h2>Appliction Migration Params</h2>
<table class="table" style="width: 75%">
	<tr>
		<td><label>Company: </label></td>
		<td>${buildparams.companyName}</td>
	</tr>
	<tr>
		<td><label>Application Name: </label></td>
		<td>${buildparams.appName}</td>
	</tr>
	<tr>
		<td><label>Email address </label></td>
		<td>${buildparams.userEmail}</td>
	</tr>
	<c:if test="${cloudname eq 'Amazon Web Services'}">
	<tr>
		<td><label>Application Infrastructure Stack Name </label></td>
		<td>${buildparams.stackName}</td>
	</tr>
	</c:if>
	<tr>
		<td><label>Environment</label></td>
		<td>${buildparams.environment}</td>
	</tr>
		<c:if test="${apptype eq 'dbapp'}">
			<tr>
				<td><label>Database Name </label></td>
				<td>${buildparams.dbname}</td>
			</tr>
			<tr>
				<td><label>Database username </label></td>
				<td>${buildparams.dbusername}</td>
			</tr>
		</c:if>
</table>