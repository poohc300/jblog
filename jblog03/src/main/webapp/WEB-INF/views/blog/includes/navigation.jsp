<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:out value="${param.id }" />
<div id="navigation">
	<h2>카테고리</h2>
	<ul>	
		<c:forEach items='${categoryVo }' var='categoryVo'>
			<li><a href='${pageContext.request.contextPath }/${categoryVo.blogId }/${categoryVo.no }'>${categoryVo.name }</a></li>				
		</c:forEach>			
		
	</ul>
</div>