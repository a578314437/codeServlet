<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>custPersionCodePage</title>
</head>
<body>
 <%  
String srcUrl = (String)request.getAttribute("srcUrl");  
String textUrl = (String)request.getAttribute("textUrl");
String strRequest = (String)request.getAttribute("strRequest");  
String custPersionCode = (String)request.getAttribute("custPersionCode");  
String[] custPersionCodeUrls = ((String)request.getAttribute("custUrl")).split("=");
String custPersionCodeUrl=custPersionCodeUrls[1]+"="+custPersionCodeUrls[2];
%>
<p><%=custPersionCodeUrl%></p>
<img src=<%=custPersionCodeUrl%>/>
</body>
</html>