<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>unactivatedCodePage</title>
</head>
<body>
 <%  
String srcUrl = (String)request.getAttribute("srcUrl");  
String textUrl = (String)request.getAttribute("textUrl");
String strRequest = (String)request.getAttribute("strRequest");  
String unactivatedCode = (String)request.getAttribute("unactivatedCode");  
String[] unactivatedCodeUrls = ((String)request.getAttribute("unactivatedUrl")).split("=");
String unactivatedCodeUrl=unactivatedCodeUrls[1]+"="+unactivatedCodeUrls[2];
%>
<p><%=unactivatedCodeUrl%></p>
<p><%=unactivatedCode%></p>
<img src=<%=unactivatedCodeUrl%>/>
</body>
</html>