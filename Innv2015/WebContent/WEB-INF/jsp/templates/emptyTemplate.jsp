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
	
	<link rel="stylesheet" href="${contextPath}/resources/css/boilerplate/sfs-build.css" />
	
	
	<%-- jquery included in <head> so body content can reference window.$ --%>
	<script src="${contextPath}/resources/js/lib/jquery-1.10.2.min.js"></script>
	
	<%-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries --%>
    <!--[if lt IE 9]>
   		<script src="${contextPath}/resources/js/lib/html5shiv.js"></script>
   		<script src="${contextPath}/resources/js/lib/respond.min.js"></script>
    <![endif]-->
    <script src="${contextPath}/resources/js/lib/jquery.idletimeout.js"></script>
    <script src="${contextPath}/resources/js/lib/jquery.idletimer.js"></script>
    <script src="${contextPath}/resources/js/sfsweb/jquery.sessionTimeout.js"></script>
    <script src="${contextPath}/resources/js/sfsweb/sfsweb.js"></script>
    
    <title>SFS Online</title><%-- TODO: Titles --%>
</head>

<body>
	<div id="contentWrapper">		
		<div class="container">					
			<!-- body -->
			<tiles:insertAttribute name="body"/>
		</div>
		<div id="push-footer"></div>
	</div>
			
	<%-- =================== JAVASCRIPT =================== --%>		
	<%-- <script src="${contextPath}/assets/js/ace-extra.min.js"></script> --%>
	<script src="${contextPath}/resources/js/lib/bootstrap.min.js"></script>
	<%-- <script src="${contextPath}/assets/js/ace-elements.min.js"></script> --%>
	<%-- <script src="${contextPath}/assets/js/ace.min.js"></script> --%>
	<script src="${contextPath}/resources/js/lib/jquery.mixitup.js"></script>
	<script src="${contextPath}/resources/js/lib/jquery.dataTables.min.js"></script>
	<script src="${contextPath}/resources/js/lib/bootstrap-datepicker.js"></script>
</body>
</html>