<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<jsp:useBean id="date" class="java.util.Date" />

<footer id="page-footer">
	Copyright © 2014-<fmt:formatDate value="${date}" pattern="yyyy" /> Go Cloud. All Rights Reserved. <br> 
</footer>