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

	<div class="col-md-offset-4  col-md-2 text-center">
	
	<h2>Sign In</h2>
	<br>
	<form action="<c:url value='/j_spring_security_check' />" id="signin" method="post">
		<div class="form-group">
		<label for="email">Email</label>
	 	<input type="text" class="form-control" name="email" id="email" required="required" placeholder="email" autocomplete="off"><br>    
	    </div>
	    
	    <div class="form-group">
		<label for="password">Password</label>
	    <input type="password" class="form-control" name="password" id="password" required="required" placeholder="password" autocomplete="off"><br>
	    </div>
	    <!-- if this is login for update, ignore remember me check -->
		<c:if test="${empty loginUpdate}">
		<div class="form-group">
		<tr>
			<td></td>
			<td>Remember Me: <input type="checkbox" name="remember-me" /></td>
		</tr>
		</div>
		</c:if>
		
	    <button type="submit" class="btn btn-primary btn-lg active">Sign In</button><br>
	</form>
	<a href="<%=request.getContextPath()%>/main/main.do">Back Home</a>
	</div>
</div>

<!-- javascript -->
<script type="text/javascript">
<!--

//-->
</script>

</body>
</html>
