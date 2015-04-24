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
				Do you want to be able to scale infrastructure up and down according
				to demand ?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control" 
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q1" />
					<br>
					<br>
					<br>
					<button type="submit" class="btn btn-primary pull-right"
						name="_eventId_next">
						Continue <i class="icon-arrow-right"></i>
					</button>
				</form:form>
			</div>
		</div>

		<div id="div_2" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Do you have workloads where the servers have to be running full
				power 24x7, or nearly so? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<br><br><br>
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
				Do you anticipate hardware investments and personnel costs in near
				term ? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<br><br><br>
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
				Do you prefer a pay-as-you-go model or prefer a long term commitment
				with a provider with an up front investment ? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<br><br><br>
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

		<div id="div_5" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Do you want to maintain/update/backup of hardware and software and
				maintain a high availability ?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q5" />
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
		<div id="div_6" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Do you want data/applications to be backed up across different data
				centers across the globe ?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q6" />
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
		<div id="div_7" class="clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Support speed to market and innovation and agility in infrastructure
				?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes"/>
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio"  value = "No"/>
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q7" />
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

	</div>
	<span class="loggedInPerson">${username} logged in</span> <a
		href="${contextPath}/auth/logout" class="pull-right logoutLink">log
		out</a>
</div>

<script>
	var divNum = '${divNum}';
</script>
<script src="${contextPath}/resources/js/sfsweb/qStart.js"></script>