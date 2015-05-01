<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="build-page">
	<h2>Appliction Migration Params</h2>
	<form tabindex="1" action="${contextPath}/cloudSelect/migrateApp" method="post"
		id="buildParamsForm" name="buildParamsForm">
		<table class="table" style="width: 75%">
			<tr>
				<td><label>Company: </label></td>
				<td><input id="companyName" type="text" name="companyName" />
				</td>
			<tr>
				<td><label>Application Name: </label></td>
				<td><input id="appName" type="text" name="appName" /></td>
			<tr>
				<td><label>GIT URL: </label></td>
				<td><input id="gitURL" type="text" name="gitURL" /></td>
			<tr>
				<td><label>Email address </label></td>
				<td><input id="userEmail" name="userEmail" type="email" />
				</td></tr>
			<tr>
				<td><label>Application Infrastructure Stack Name </label></td>
				<td><input id="stackName" name="stackName" type="text" /></td></tr>
			<tr>
				<td><label>Environment</label></td>
				<td><select id="environment" name="environment" style="width:150px;">
							<option value="" selected>Select</option>
							<option value="dev">DEV</option>
							<option value="sit">SIT</option>
							<option value="sit">CAT</option>
							<option value="sit">PROD</option>
					</select>
					</td>
			<tr>
			
				<td colspan="2"><input type="submit" value="Migrate"
					class="pull-right btn btn-primary" id="migrateBtn"></td>

			</tr>
		</table>
	</form>
</div>
<div id="feedbackDiv" style="display: none;">
<p></p>
</div>
<div id="feedbackTemplate" style="display: none;">
Your application is migrating to ##CLOUD_NAME##. 
Your confirmation number is ##CONFIRMATION_NUMBER##. You will receive an email after the migration.
</div>

<script src="${contextPath}/resources/js/innov2015/migrate.js"></script>