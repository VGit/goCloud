<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="row" style="text-align:center; width: 480px;">
	<img alt="AWS" src="${contextPath}/resources/images/aws.png"
		height="84" width="84">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="AWS"
		src="${contextPath}/resources/images/cloudfoundry.jpg" height="84"
		width="84">
</div>
<br>
<div class="row">
	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a
			data-target="#service-level" data-toggle="tab">Service-level</a></li>
		<li role="presentation"><a data-target="#network"
			data-toggle="tab">Network</a></li>
		<li role="presentation"><a data-target="#resilience"
			data-toggle="tab">Resilience and Recovery</a></li>
		<li role="presentation"><a data-target="#it-skills"
			data-toggle="tab">IT skills</a></li>
		<li role="presentation"><a data-target="#flexibility"
			data-toggle="tab">Flexibility</a></li>
		<li role="presentation"><a data-target="#security"
			data-toggle="tab">Security</a></li>
		<li role="presentation"><a data-target="#regulations"
			data-toggle="tab">Regulations</a></li>
		<li role="presentation"><a data-target="#compatibility"
			data-toggle="tab">Compatibility</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="service-level">
			<br> <br>
			<ul>
				<li>Do you want to be able to scale infrastructure up and down
					according to demand ? <input type="radio" id="yesRadio"
					name="yesNoRadio" value="Yes" /> <label for="yesRadio">Yes</label>
					<input type="radio" id="noRadio" name="yesNoRadio" value="No" /> <label
					for="noRadio">No</label>
				</li>
			</ul>
		</div>
		<div class="tab-pane" id="network">2</div>
		<div class="tab-pane" id="resilience">3</div>
		<div class="tab-pane" id="it-skills">4</div>
		<div class="tab-pane" id="fliexibility">5</div>
		<div class="tab-pane" id="security">6</div>
		<div class="tab-pane" id="regulations">7</div>
		<div class="tab-pane" id="compatibility">8</div>
	</div>
</div>