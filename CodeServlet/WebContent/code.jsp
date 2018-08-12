<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>code page</title>
</head>
<body>
<h1>自服务二维码生成</h1>
<form method="post" action="code.do">
    Select:<br>
    <select name="select">
        <option>keyPersionCode</option>
        <option>custPersionCode</option>
        <option>devicesCode</option>
        <option>unactivatedCode</option>
    </select>
    <center>
        <input type="submit" value="生成二维码">
    </center>
</form>
</body>
</html>