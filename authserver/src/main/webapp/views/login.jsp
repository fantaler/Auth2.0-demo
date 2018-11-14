<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%-- <%
String path1 = request.getContextPath();
response.sendRedirect(path1 + "/login/toLogin.do");  
%> --%>


<html>
<head>

	<script src="${pageContext.request.contextPath }/js/jquery.min63b9.js" type="text/javascript"></script>
   
</head>
<body>
认证开始：
	<form action="${pageContext.request.contextPath}/responseCode" method="post">
		<input type="hidden" name="response_type" value="${response_type}"/>
		<input type="hidden" name="redirect_uri" value="${redirect_uri}"/>
		<input type="hidden" name="client_id" value="${client_id}"/>
		用户名：<input type="text" name="username"/></br>
		密   码：<input type="text" name="password" />
		<input type="submit" value="授权"/>
	</form>


</body>
</html>