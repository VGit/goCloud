<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<style>
body{ background-color: #f3f1f1; }
</style>

<div class="clearfix">
<div class="row dashboard">
	<div class="col-md-4 col-sm-6"><div class="inner">
		<h1>My Orders<i class="cutout cutout-truck"></i></h1>		
		<ul>		
			<li><a href="${contextPath}/order/showOrders?type=O-R">Open Orders</a><%-- <span class="openOrdersCnt"></span> --%></li> 
			<li><a href="${contextPath}/order/showOrders?type=B">Booked Orders</a><%-- <span class="bookedOrdersCnt"></span> --%></li>
			<li><a href="${contextPath}/order/showOrders?type=S-P">Shipped Orders</a><%-- <span class="shippedOrdersCnt"></span> --%></li>
			<li><a href="${contextPath}/order/showOrders?type=C">Canceled Orders</a><%-- <span class="canceledOrdersCnt"></span> --%></li>
		</ul>		
	</div></div>
</div>
<script src="${contextPath}/resources/js/sfsweb/dashboardPRU.js"></script>
