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

    <form action="<c:url value="./update.do" />" method="post">
        <input type="hidden" name="goodsNumber" value="${goodsVO.number}"/>
        <input type="hidden" name="p" value="${param.p}"/>
	        상품 명 : <input type="text" name="name" size="100" value="${goodsVO.name}"/><br/>
	        크기 : <input type="text" name="size" size="20" value="${goodsVO.size}"/><br/>
	        소재 : <input type="text" name="material" size="50" value="${goodsVO.material}"/><br/>
	        구성 : <input type="text" name="component" size="20" value="${goodsVO.component}"/><br/>
	        옵션 : <input type="text" name="options" value="${goodsVO.options}"/><br/>
	        제조/수입 : <input type="text" name="manufacturer" size="50" value="${goodsVO.manufacturer}"/><br/>
	        제조국 : <input type="text" name="madein" size="50" value="${goodsVO.madein}"/><br/>
	        가격 : <input type="text" name="price" size="20" value="${goodsVO.price}"/><br/>
	        재고 : <input type="text" name="stock" size="20" value="${goodsVO.stock}"/><br/>
	
	        상품 설명 : <br/>
        <textarea name="description" cols="40" rows="5">${goodsVO.description}</textarea>
        <br/>
        <input type="submit" value="전송"/>
    </form>

</div>
</body>

</html>