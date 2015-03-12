<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}
</style>

<div class="clearfix">
	<div class="row">
		Lets get Staarted. Text here
	</div>
	<div class="row" id="div1">
		1. Do you have a particular clound in mind ? <input id="q1YesRadio" type="radio"/><label for="q1YesRadio">Yes</</label>
		<input id="q1NoRadio" type="radio"/><label for="q1NoRadio">No</</label>
	</div>
	<br>
	<div class="row">
		2. Whats the size of your application ? <select id="qAppSizeSelect"><option>Under 1GB</option><option>1GB-5GB</option><option>5GB-10GB</option><option>Don't know</option></select>
	</div>
	<br>
	<div class="row">
		3. What database would you prefer ? <input id="q3OracleCheck" type="checkbox"/><label for="q3OracleCheck">Oracle</</label> 
		<input id="q3MySqlCheck" type="checkbox"/><label for="q3MySqlCheck">My Sql</</label> <input id="q3PostGresCheck" type="checkbox"/><label for="q3PostGresCheck">PostGres</</label> <input id="q3SybaseCheck" type="checkbox"/> <label for="q3AnyCheck">Any</</label>
	</div>
	<br>
	<div class="row">
		4. Whats the size of your database ? <select id="qDbSizeSelect"><option>Under 1GB</option><option>1GB-5GB</option><option>5GB-10GB</option><option>Don't know</option></select>
	</div>
</div>
<script src="${contextPath}/resources/js/sfsweb/qStart.js"></script>