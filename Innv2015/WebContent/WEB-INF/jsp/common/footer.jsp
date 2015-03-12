<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<jsp:useBean id="date" class="java.util.Date" />

<footer id="page-footer">
	Copyright © 1999-<fmt:formatDate value="${date}" pattern="yyyy" /> CRGT. All Rights Reserved. <br> 
</footer>