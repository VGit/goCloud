<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="build-page">
	<div class="row">
		<label class="h2 col-md-4 control-label" for="cloudSelect">Please
			select the cloud to migrate to:</label> <select id="cloudSelect"
			name="cloudSelect" class="h2 col-md-3">
			<option value="" selected>Select</option>
			<option value="aws">Amazon Web Services</option>
			<option value="cf">Cloud Foundry</option>
			<option value="ma">Microsoft Azure</option>
		</select>
		<div class="row" style="text-align: center; display: none;">
			<img alt="AWS" src="${contextPath}/resources/images/aws.png">
		</div>
		<div class="row" style="text-align: center; display: none;">
			<img alt="Cloud Foundry"
				src="${contextPath}/resources/images/cloudfoundry.jpg">
		</div>
		<div class="row" style="text-align: center; display: none;">
			<img alt="IBM Bluemix"
				src="${contextPath}/resources/images/microsoftazure.jpg">
		</div>
	</div>
	<br>
	<div class="row awsapptype apptype awsdiv inithidediv">
		<label class="col-md-4 control-label" for="yesNoRadio">Choose
			the type of application to deploy:</label><input type="radio"
			id="awswebappradio" name="awsradio" value="webapp" /> <label
			for="yesRadio">Web Application</label> &nbsp;&nbsp;&nbsp;&nbsp;<input
			type="radio" id="awsdbradio" name="awsradio" value="database" /> <label
			for="noRadio">Database</label>
	</div>
	<div class="row cfapptype apptype cfdiv inithidediv">
		<label class="col-md-4 control-label" for="yesNoRadio">Choose
			the type of application to deploy:</label><input type="radio" id="yesRadio"
			name="cfRadio" value="webapp" checked /> <label for="yesRadio">Web
			Application</label> &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" id="noRadio"
			name="cfRadio" value="database" disabled="disabled" /> <label
			for="noRadio">Database</label>
	</div>
	<div id="appParamDiv" class="appParamDiv inithidediv">
		<h2>Appliction Migration Params</h2>
		<div class="paramdiv awswebappdiv">
			<form tabindex="1"
				action="${contextPath}/cloudSelect/migrateWebAppAWS" method="post"
				id="migrateWebAppAWSForm" name="buildParamsForm">
				<table class="table" style="width: 75%">
					<tr>
						<td><label>Company: </label></td>
						<td><input id="companyName" type="text" name="companyName" />
						</td>
					<tr>
						<td><label>Application Name: </label></td>
						<td><input id="appName" type="text" name="appName" required /></td>
					<tr>
						<td><label>GIT URL: </label></td>
						<td><input id="gitURL" type="text" name="gitURL"
							required="required" /></td>
					<tr>
						<td><label>Email address </label></td>
						<td><input id="userEmail" name="userEmail" type="email" /></td>
					</tr>
					<tr>
						<td><label>Application Infrastructure Stack Name </label></td>
						<td><input id="stackName" name="stackName" type="text" /></td>
					</tr>
					<tr>
						<td><label>Environment</label></td>
						<td><select id="environment" name="environment"
							style="width: 150px;" required>
								<option value="" selected>Select</option>
								<option value="DEV">DEV</option>
								<option value="SIT">SIT</option>
								<option value="CAT">CAT</option>
								<option value="PROD">PROD</option>
						</select></td>
					<tr>

						<td colspan="2"><input type="submit" value="Migrate"
							class="pull-right btn btn-primary" id="migrateBtn"></td>

					</tr>
				</table>
			</form>
		</div>
		<div class="paramdiv awsdbdiv inithidediv">
			<form tabindex="1" action="${contextPath}/cloudSelect/migrateDBAWS"
				method="post" id="migrateDBAWSForm" name="buildParamsForm">
				<table class="table" style="width: 75%">
					<tr>
						<td><label>Company: </label></td>
						<td><input id="companyName" type="text" name="companyName" />
						</td>
					</tr>
					<tr>
						<td><label>Application Name: </label></td>
						<td><input id="appName" type="text" name="appName" /></td>
					</tr>
					<tr>
						<td><label>Email address </label></td>
						<td><input id="userEmail" name="userEmail" type="email" /></td>
					</tr>
					<tr>
						<td><label>Application Infrastructure Stack Name </label></td>
						<td><input id="stackName" name="stackName" type="text" /></td>
					</tr>
					<tr>
						<td><label>Environment</label></td>
						<td><select id="environment" name="environment"
							style="width: 150px;" required>
								<option value="" selected>Select</option>
								<option value="DEV">DEV</option>
								<option value="SIT">SIT</option>
								<option value="CAT">CAT</option>
								<option value="PROD">PROD</option>
						</select></td>
					<tr>
					<tr>
						<td><label>Database Name </label></td>
						<td><input id="dbname" name="dbname" type="text"
							required="required" pattern=".{5,}" required
							title="5 characters minimum" /></td>
					</tr>
					<tr>
						<td><label>Database username </label></td>
						<td><input id="dbusername" name="dbusername" type="text"
							pattern=".{5,}" required title="5 characters minimum" /></td>
					</tr>
					<tr>
						<td><label>Database Password </label></td>
						<td><input id="dbpassword" name="dbpassword" type="password"
							pattern=".{8,}" required title="8 characters minimum" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="Migrate"
							class="pull-right btn btn-primary" id="migrateBtn"></td>

					</tr>
				</table>
			</form>
		</div>
		<div class="paramdiv cfwebappdiv inithidediv">
			<form tabindex="1"
				action="${contextPath}/cloudSelect/migrateWebAppCF" method="post"
				id="migrateWebAppCFForm" name="buildParamsForm">
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
						<td><input id="gitURL" type="text" name="gitURL"
							required="required" /></td>
					<tr>
						<td><label>Email address </label></td>
						<td><input id="userEmail" name="userEmail" type="email" /></td>
					</tr>
					<tr>
						<td><label>Environment</label></td>
						<td><select id="environment" name="environment"
							style="width: 150px;" required>
								<option value="" selected>Select</option>
								<option value="DEV">DEV</option>
								<option value="SIT">SIT</option>
								<option value="CAT">CAT</option>
								<option value="PROD">PROD</option>
						</select></td>
					<tr>
						<td colspan="2"><input type="submit" value="Migrate"
							class="pull-right btn btn-primary" id="migrateBtn"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>
<script src="${contextPath}/resources/js/innov2015/migrate.js"></script>