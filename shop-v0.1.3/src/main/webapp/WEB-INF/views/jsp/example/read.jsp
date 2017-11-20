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
	<table>
        <tr>
            <td>상품 번호</td>
            <td>${goodsVO.number}</td>
        </tr>
        <tr>
            <td>상품 명</td>
            <td>${goodsVO.name}</td>
        </tr>
        <tr>
            <td>크기</td>
            <td>${goodsVO.size}</td>
        </tr>
        <tr>
            <td>소재</td>
            <td>${goodsVO.material}</td>
        </tr>
        <tr>
            <td>구성</td>
            <td>${goodsVO.component}</td>
        </tr>
        <tr>
            <td>옵션</td>
            <td>${goodsVO.options}</td>
        </tr>
        <tr>
            <td>제조/수입</td>
            <td>${goodsVO.manufacturer}</td>
        </tr>
        <tr>
            <td>제조국</td>
            <td>${goodsVO.madein}</td>
        </tr>

            <td>가격</td>
            <td>${goodsVO.price}</td>
        </tr>
        <tr>
            <td>재고</td>
            <td>${goodsVO.stock}</td>
        </tr>
        <tr>
            <td>등록자</td>
            <td>${goodsVO.userEmail}</td>
        </tr>
        <tr>
            <td>등록일</td>
            <td><fmt:formatDate value="${goodsVO.createdDate}" pattern="yyyy-MM-dd"/></td>
        </tr>

        <tr>
            <td>상품 설명</td>
            <td>
                <pre><c:out value="${goodsVO.description}"/></pre>
            </td>
        </tr>
        <tr>

            <td colspan="2">
                <input type="button" onclick="location.href='list.do?p=${param.p}'" value="목록보기"/>
                <input type="button" onclick="location.href='update.do?p=${param.p}&goodsNumber=${goodsVO.number}'" value="수정하기"/>
                <form action="<c:url value="/goods/delete.do" />" method="post" style="display: inline;">
                    <input type="hidden" name="p" value="${param.p}"/>
                    <input type="hidden" name="goodsNumber" value="${goodsVO.number}"/>
                    <input type="submit" value="삭제하기" >
                </form>
            </td>
        </tr>
    </table>
    <a href="<%=request.getContextPath()%>/main/main.do">Back Home</a>
</div>
</body>

</html>