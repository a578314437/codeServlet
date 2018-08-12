<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>keyPersionCodePage</title>
</head>
<body>
 <%  
String srcUrl = (String)request.getAttribute("srcUrl");  
String textUrl = (String)request.getAttribute("textUrl");
String strRequest = (String)request.getAttribute("strRequest");  
String keyPersionCode = (String)request.getAttribute("keyPersionCode");  
String[] keyPersionCodeUrls = ((String)request.getAttribute("keyPersiontUrl")).split("=");
String keyPersionCodeUrl=keyPersionCodeUrls[1]+"="+keyPersionCodeUrls[2];
%>
<p><%=keyPersionCodeUrl%></p>
<img src=<%=keyPersionCodeUrl%>/>
</body>
</html>