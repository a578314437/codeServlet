<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>devicesCodePage</title>
</head>
<body>
 <%  
String srcUrl = (String)request.getAttribute("srcUrl");  
String textUrl = (String)request.getAttribute("textUrl");
String strRequest = (String)request.getAttribute("strRequest");  
String devicesCode = (String)request.getAttribute("devicesCode");  
String[] devicesCodeUrls = ((String)request.getAttribute("devicesUrl")).split("=");
String devicesCodeUrl=devicesCodeUrls[1]+"="+devicesCodeUrls[2];
%>
<p><%=devicesCodeUrl%></p>
<img src=<%=devicesCodeUrl%>/>
</body>
</html>