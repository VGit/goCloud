<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}
</style>
<div class="login-flow">
	<div class="panel panel-default">
		<div class="panel-heading">Is Application ready for Cloud</div>
		<div id="div_1" class="clearfix qDiv" style="display: none;">

			<div class="panel-body">
				1. Do you have a particular cloud in mind ?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<input id="q1YesRadio" name="radiogrp" type="radio" />
					<label for="q1YesRadio">Yes</label>
					<input id="q1NoRadio" name="radiogrp" type="radio" />
					<label for="q1NoRadio">No</label>
					<input type="hidden" value="q1" />
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q1" />
					<br>
					<br>
					<br>
					<button type="submit" class="btn btn-primary"
						name="_eventId_previous">
						<i class="icon-arrow-left"></i> Back
					</button>
					<button type="submit" class="btn btn-primary pull-right"
						name="_eventId_next">
						Continue <i class="icon-arrow-right"></i>
					</button>
				</form:form>
			</div>
		</div>

		<div id="div_2" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				2. What is the size of your application ? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<select id="qAppSizeSelect"><option>Under 1GB</option>
						<option>1GB-5GB</option>
						<option>5GB-10GB</option>
						<option>Don't know</option></select>
					<br>
					<button type="submit" class="btn btn-primary"
						name="_eventId_previous">
						<i class="icon-arrow-left"></i> Back
					</button>
					<button type="submit" class="btn btn-primary pull-right"
						name="_eventId_next">
						Continue <i class="icon-arrow-right"></i>
					</button>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q2" />
				</form:form>
			</div>
		</div>

		<div id="div_3" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				3. What database would you prefer ? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<input id="q3OracleCheck" type="checkbox" />
					<label for="q3OracleCheck">Oracle</label>
					<input id="q3MySqlCheck" type="checkbox" />
					<label for="q3MySqlCheck">My Sql</label>
					<input id="q3PostGresCheck" type="checkbox" />
					<label for="q3PostGresCheck">PostGres</label>
					<input id="q3SybaseCheck" type="checkbox" />
					<label for="q3AnyCheck">Any</label>
					<br>

					<button type="submit" class="btn btn-primary"
						name="_eventId_previous">
						<i class="icon-arrow-left"></i> Back
					</button>
					<button type="submit" class="btn btn-primary pull-right"
						name="_eventId_next">
						Continue <i class="icon-arrow-right"></i>
					</button>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q3" />
				</form:form>
			</div>
		</div>
		<div id="div_4" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				4. What's the size of your database ? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<select id="qDbSizeSelect"><option>Under 1GB</option>
						<option>1GB-5GB</option>
						<option>5GB-10GB</option>
						<option>Don't know</option></select>
					<br>
					<button type="submit" class="btn btn-primary"
						name="_eventId_previous">
						<i class="icon-arrow-left"></i> Back
					</button>
					<button type="submit" class="btn btn-primary pull-right"
						name="_eventId_next">
						Continue <i class="icon-arrow-right"></i>
					</button>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q4" />
				</form:form>
			</div>
		</div>

	</div>
	<span class="loggedInPerson">${username} logged in</span> <a
		href="${contextPath}/auth/logout" class="pull-right logoutLink">log
		out</a>
</div>

<script>
	var divNum = '${divNum}';
</script>
<script src="${contextPath}/resources/js/sfsweb/qStart.js"></script>