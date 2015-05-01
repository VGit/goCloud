
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!--[if IE 9 ]>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<![endif]-->
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html class=""> <!--<![endif]-->
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
	
	<!--[if IE 8 ]>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<![endif]-->
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<%-- =================== CSS =================== --%>
	
	
	<link rel="stylesheet" href="${contextPath}/resources/css/font-awesome.min.css" />
	
	<link rel="stylesheet" href="${contextPath}/resources/css/jquery.dataTables.css" />
	
	<link rel="stylesheet" href="${contextPath}/resources/css/dataTables.tableTools.css" />
	
	<link rel="stylesheet" href="${contextPath}/resources/css/datepicker3.css" />
	
	<link rel="stylesheet" href="${contextPath}/resources/css/boilerplate/sfs-build.css" />
	
	
	<%-- jquery included in <head> so body content can reference window.$ --%>
	<script src="${contextPath}/resources/js/lib/jquery-1.10.2.min.js"></script>
	<script src="${contextPath}/resources/js/lib/jquery-ui-1.10.3.full.min.js"></script>
	
	<%-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries --%>
    <!--[if lt IE 9]>
   		<script src="${contextPath}/resources/js/lib/html5shiv.js"></script>
   		<script src="${contextPath}/resources/js/lib/respond.min.js"></script>
    <![endif]-->
    
    <script>
    	var hasActiveSession = ${authorizedUserInSession != null};
    </script>
    
<title>${not empty title ? title : 'Go Cloud'} </title><%-- TODO: Titles --%>
</head>

<body>
	<div id="contentWrapper">
		<tiles:insertAttribute name="header"/>
		<div class="container">
			<!-- body -->
			<tiles:insertAttribute name="body"/>
		</div>
	</div>
	
	<!-- footer -->
	<tiles:insertAttribute name="footer"/>
		
	
	<div class="modal fade no-header" id="sessionTimeout-dialog" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					<button type="button" class="close clearfix pull-right"
						data-dismiss="modal" aria-hidden="true">
					<span class="sr-only">Close Session Time out alert</span>&times;</button>
					
					Your session will expire in 
					<span id="dialog-countdown" style="font-weight:bold"></span>&nbsp;seconds.
					<br><br>
					Do you want to continue your session?						
				</div>
				<div class="modal-footer">
					<button id="sessionTimeout-resume" type="button" class="btn btn-primary pull-right" data-dismiss="modal">
						Yes, Stay on this page
					</button>
					<a href="${contextPath}/auth/logout" class="btn btn-primary pull-left">No, Log Out</a>
				</div>
			</div>
		</div>
	</div>
	
	
	<%-- =================== JAVASCRIPT =================== --%>
	
	
	
	<%-- <script src="${contextPath}/assets/js/ace-extra.min.js"></script> --%>
	<script src="${contextPath}/resources/js/lib/bootstrap.min.js"></script>
	<%-- <script src="${contextPath}/assets/js/ace-elements.min.js"></script> --%>
	<%-- <script src="${contextPath}/assets/js/ace.min.js"></script> --%>
	
	<script src="${contextPath}/resources/js/lib/jquery.idletimeout.js"></script>
    <script src="${contextPath}/resources/js/lib/jquery.idletimer.js"></script>
    <script src="${contextPath}/resources/js/sfsweb/jquery.sessionTimeout.js"></script>
	<script src="${contextPath}/resources/js/lib/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/resources/js/lib/dataTables.tableTools.js"></script>	
	<script src="${contextPath}/resources/js/lib/dataTables.formattedNumbers.js"></script>
	<script src="${contextPath}/resources/js/lib/dataTables.currencySort.js"></script>
	<script src="${contextPath}/resources/js/lib/bootstrap-datepicker.js"></script>
	
</body>
</html>