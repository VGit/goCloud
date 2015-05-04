<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<div class="row" style="text-align: center;">
	<img alt="AWS" src="${contextPath}/resources/images/aws.png">&nbsp;
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="Cloud Foundry"
		src="${contextPath}/resources/images/cloudfoundry.jpg">&nbsp;
	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="IBM Bluemix"
		src="${contextPath}/resources/images/microsoftazure.jpg">
</div>
<br>

<table id="cspDataTable" class="table" style="width: 75%;" style="display:none">
	<thead>
		<tr role="row">
			<th></th>
			<th>Amazon Web Service (AWS)</th>
			<th>Cloud Foundry</th>
			<th>Microsoft Azure</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>Total</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
	</tfoot>
	<tbody role="alert" aria-live="polite" aria-relevant="all">
		<c:forEach items="${cspvoList}" var="cspvo">
			<tr>
				<td>${cspvo.type}</td>
				<td
					<c:if test="${'0' eq cspvo.awsValue}"> style="background-color:#ffffff !important;"</c:if>
					<c:if test="${'1' eq cspvo.awsValue}"> style="background-color:#D6EBF2 !important;"</c:if>
					<c:if test="${'2' eq cspvo.awsValue}"> style="background-color:#CBFDCB !important;"</c:if>
					<c:if test="${'3' eq cspvo.awsValue}"> style="background-color:#B2FFFF !important;"</c:if>>${cspvo.awsValue}</td>
				<td
					<c:if test="${'0' eq cspvo.cfValue}"> style="background-color:#ffffff !important;"</c:if>
					<c:if test="${'1' eq cspvo.cfValue}"> style="background-color:#D6EBF2 !important;"</c:if>
					<c:if test="${'2' eq cspvo.cfValue}"> style="background-color:#CBFDCB !important;"</c:if>
					<c:if test="${'3' eq cspvo.cfValue}"> style="background-color:#B2FFFF !important;"</c:if>>${cspvo.cfValue}</td>
				<td
					<c:if test="${'0' eq cspvo.azureValue}"> style="background-color:#ffffff !important;"</c:if>
					<c:if test="${'1' eq cspvo.azureValue}"> style="background-color:#D6EBF2 !important;"</c:if>
					<c:if test="${'2' eq cspvo.azureValue}"> style="background-color:#CBFDCB !important;"</c:if>
					<c:if test="${'3' eq cspvo.azureValue}"> style="background-color:#B2FFFF !important;"</c:if>>${cspvo.azureValue}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
Reference : <a href="http://www.slideshare.net/Pivotal/paa-s-comparison2014v08" target="_blank">http://www.slideshare.net/Pivotal/paa-s-comparison2014v08</a>
</div>
<script>
	$(window).load(
			function() {
				table = $('#cspDataTable').DataTable(
						{
							"dom" : '<f"top">rt<"bottom"pl><"clear">',
							"retrieve" : true,
							 destroy : true,
							"paging" : false,
							"footerCallback" : function(row, data, start, end,
									display) {
								var api = this.api(), data;

								// Remove the formatting to get integer data for summation
								var intVal = function(i) {
									if(isNaN(i)){
										return 0;
									}
									return typeof i === 'string' ? i.replace(
											/[\$,]/g, '') * 1
											: typeof i === 'number' ? i : 0;
								};

								// Total over all pages
								awstotal = api.column(1).data().reduce(
										function(a, b) {
											return intVal(a) + intVal(b);
										});

								// Update footer
								$(api.column(1).footer()).html(awstotal);
								// Total over all pages
								cftotal = api.column(2).data().reduce(
										function(a, b) {
											return intVal(a) + intVal(b);
										});

								// Update footer
								$(api.column(2).footer()).html(cftotal);
								matotal = api.column(3).data().reduce(
										function(a, b) {
											return intVal(a) + intVal(b);
										});

								// Update footer
								$(api.column(3).footer()).html(matotal);
							}
						});
			});
	$('#cspDataTable').show();
</script>