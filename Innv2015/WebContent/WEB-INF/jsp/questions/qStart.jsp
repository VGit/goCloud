<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body {
	background-color: #f3f1f1;
}
</style>
<div class="login-flow">
	<div class="panel panel-default">
		<div class="panel-heading">Is Application ready for Cloud</div>

		<div id="div_1" class="div_1 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Can the required compliance/security levels be achieved externally?
				?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
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

		<div id="div_2" class="div_2 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Can acceptable Service Level Agreement (SLA) be found externally? <br>
				<br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
					<label for="noRadio">No</label>
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
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q2" />
				</form:form>
			</div>
		</div>

		<div id="div_3" class="div_3 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Is external hosting financially viable? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
					<label for="noRadio">No</label>
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
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q3" />
				</form:form>
			</div>
		</div>
		<div id="div_4" class="div_4 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Are there compatibility issues that prohibit externalization of the
				application? <br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
					<label for="noRadio">No</label>
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
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q4" />
				</form:form>
			</div>
		</div>

		<div id="div_5" class="div_5 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Must the organization strategically retain this application
				internally?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
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
		<div id="div_6" class="div_6 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Does the internal staff have the ability/resources to install,
				manage and support the application?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
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
		<div id="div_7" class="div_7 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Is the organization willing to invest in the resources to install,
				manage and support the application?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
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
		<div id="div_8" class="div_8 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Can the application run on standard hardware, software or
				virtualization?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q8" />
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
		<div id="div_9" class="div_9 clearfix qDiv" style="display: none;">
			<div class="panel-body">
				Does the organization need control over compute, storage and
				networking hardware?<br> <br>
				<form:form modelAttribute="answerForm" action="${flowExecutionUrl}">
					<form:radiobutton id="yesRadio" path="yesNoRadio" value="Yes" />
					<label for="yesRadio">Yes</label>
					<form:radiobutton id="noRadio" path="yesNoRadio" value="No" />
					<label for="noRadio">No</label>
					<form:input type="hidden" class="form-control"
						path="questionNumber" name="questionNumber" id="questionNumber"
						value="q9" />
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
</div>
<div class="div_1 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>If the business process's data is highly sensitive, and the
			required compliance and security levels can't be achieved externally,
			then the data should be kept inside the organization. For example,
			certain government military secret information may fall under policy
			that dictates the enterprise must provide both cybersecurity and
			physical security measures to protect the data. As such, the data
			must be contained and managed by an internal IT organization.</dd>
	</dl>
</div>
<div class="div_2 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>The next step is to determine whether acceptable SLAs can be
			found externally. For example, applications that require constant
			uptime may not find acceptable availability guarantees with external
			providers such as public IaaS providers that do not offer better than
			99.95% uptime SLA of an instance in a single DC. Conversely, some
			external MSPs may offer better SLAs for response time, resolution
			time or on-premises managed services. Assess the required SLAs for an
			application and move ahead with the decision to host the application
			internally, or address other concerns before choosing an external
			model.</dd>
		<br>
		<dt>Definition</dt>
		<dd>Typical SLA or service level requirements include such as
			application performance, uptime, recovery time objectives, and
			incident response and resolution times</dd>
	</dl>
</div>
<div class="div_3 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>Consider whether hosting the application externally makes
			sense from a financial perspective. Internal IT is always under
			pressure to reduce IT operations costs; however, that doesn't
			necessarily mean that external hosting will be less expensive. IT
			needs to evaluate the ROI and cost benefits of application hosting
			options before moving to an external sourcing model. Organizations
			may have different goals in terms of IT costs. Some organizations
			could be looking to reduce medium- or long-term total cost of
			ownership (TCO) and shift from capex to opex. Other organizations
			could be looking for solutions with lower overall TCO, and to achieve
			that, they may be ready to spend money upfront.</dd>
	</dl>
</div>

<div class="div_4 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>Moving an application to an external service provider
			requires compatibility between enterprise IT and the service
			provider. The compatibility constraints could be between the internal
			infrastructure hosting the application and the service provider's
			Infrastructure, or it could be vendor licensing that restricts
			business process movement. Another issue to consider with multitier
			applications, where some tiers will remain in the data center and
			some will be moved to an external hosting solution, is the problem of
			latency for communication between the tiers and its impact on
			performance. Conversely, compatibility with an external hosting model
			may encourage the decision to move out. For example, customers who
			have invested a lot in VMware or Microsoft technology, and are
			interested in close affinities with the VMware vCloud Suite may find
			better compatibility with public cloud services by VMware vCloud Air,
			while customers using Microsoft System Center and Hyper-V are more
			likely to favor Microsoft Azure.</dd>
	</dl>
</div>

<div class="div_5 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>An organization might still have to run an application
			internally for strategic reasons. There are several reasons for
			retaining an application or business process in- house. Examples
			include the business process being a core competency that an
			organization should not externalize, or that sophisticated
			industry-specific knowledge is required to run the business process.
			There are some applications that depend mostly on company-specific
			knowledge and are better run by internal IT. These may be
			applications with process knowledge not widely documented and some
			internally developed applications. For example, financial services
			organizations internally develop custom applications for market
			forecasting and trading. These applications represent extremely
			valuable intellectual property and yield competitive advantage in the
			market, which makes the organizations unwilling to host them
			externally.</dd>
	</dl>
</div>
<div class="div_6 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>The important aspect of this filter is to determine the
			staff's efficiency and system management skills. As technology
			evolves and business demands change, the required staff skills will
			also change, which necessitates retraining or attracting new talent.
			In situations where management of the application is to be
			outsourced, various options should be considered for application
			placement. If staff skills are determined to be inefficient or
			nonexistent, we move ahead to Next Question.</dd>
	</dl>
</div>
<div class="div_7 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>The objective here is to understand whether the organization
			really wants its internal staff to handle the business process. If
			yes, the organization should look to models such as colocation or
			public IaaS cloud. If not, then the organization should look at an
			MSP model to ascertain whether that is a viable option. It is
			typically more expensive to develop advanced functional knowledge
			internally. An external hosting model may be a cost-effective
			alternative. Comparing MSP options requires detailed knowledge of the
			existing staff cost models and skills, the Operational Level
			Agreements (OLAs) and SLAs delivered internally, and the required
			application service levels. Without the cost and service-level
			information, an informed decision cannot be made. However, if the
			data center hosting the application is outdated or too costly to
			retrofit to host the application, then outsourcing all or part of the
			business process/application may be required.</dd>
	</dl>
</div>
<div class="div_8 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>This decision filter is centered on the application's
			technical requirements. If the application requires specific hardware
			or software support, then colocation is the best choice, if the IT
			organization can place its required hardware into a colocation data
			center facility. Otherwise, if the application can be virtualized to
			run on commodity hardware, then the application can be placed in a
			public cloud IaaS environment where the provider handles the hardware
			management. This allows the IT organization to focus on managing only
			the software/platform stack.</dd>
	</dl>
</div>
<div class="div_9 panel panel-default"
	style="padding-left: 15px; padding-top: 15px; display: none;">
	<dl class="dl-vertical">
		<dt>Objective</dt>
		<dd>The more an enterprise derives its competitive advantage from
			its infrastructure i.e., compute, storage and networking hardware the
			more it will strive to use existing competencies. An enterprise
			looking to retain control over its infrastructure, but lacking the
			capacity or Data Center space to host the application, should opt for
			a colocation hosting model. This allows an enterprise to use its own
			hardware and manage server configurations and the application,
			without having to provide and manage the data center space.</dd>
	</dl>
</div>

<script>
	var divNum = '${divNum}';
</script>
<script src="${contextPath}/resources/js/innov2015/qStart.js"></script>