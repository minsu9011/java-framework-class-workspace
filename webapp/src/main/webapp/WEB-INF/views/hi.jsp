<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h1>헬로세상아!!!</h1>
<h1>${helloModel.hello} ${helloModel.name}</h1>
<form method="POST" action="/spring/hi/헐크">
    <input type="submit" value="눌러유"/>
</form>
</body>
</html>
