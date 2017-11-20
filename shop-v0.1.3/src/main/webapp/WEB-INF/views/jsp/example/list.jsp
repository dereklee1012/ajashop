<%--
  Created by ECLIPSE.
  User: dereklee
  Last Editor: dereklee
  Date: 2017-07-22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/nav.jsp"%>
<div class="main">
	<c:forEach var="list" items="${data}">
		아이디 : ${list.id}, 이름 : ${list.name}<br>
    </c:forEach>
</div>
</body>

</html>