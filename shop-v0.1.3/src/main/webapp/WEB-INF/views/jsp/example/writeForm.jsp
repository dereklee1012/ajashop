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
	<form action="<c:url value="./write.do" />" method="post">
	        상품 명 : <input type="text" name="name" size="100"/><br/>
	        크기 : <input type="text" name="size" size="20"/><br/>
	        소재 : <input type="text" name="material" size="50"/><br/>
	        구성 : <input type="text" name="component" size="20"/><br/>
	        옵션 : <input type="text" name="options"/><br/>
	        제조/수입 : <input type="text" name="manufacturer" size="50"/><br/>
	        제조국 : <input type="text" name="madein" size="50"/><br/>
	        가격 : <input type="text" name="price" size="20"/><br/>
	        재고 : <input type="text" name="stock" size="20"/><br/>
	
	        상품 설명 : <br/>
        <textarea name="description" cols="40" rows="5"></textarea>
        <br/>

        <input type="button" onclick="location.href='list.do?s=${param.s}'" value="취소"/>
        <input type="submit" value="전송">
    </form>
</div>
</body>

</html>