<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ include file="redirekcija.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String id= (String)request.getAttribute("id");
String naziv= (String) request.getAttribute("naziv");
String cena =(String) request.getAttribute("cena");
%>

<form action="/PozoristeProjekat/akcija/updatePredstave" method="post">
<input type="text" name="naziv" value="<%=naziv%>">
<input type="number" name="cena" value="<%=cena%>">


<input type="hidden" name="id" value="<%=id%>">
<input type="submit" value="update">






</form>
</body>
</html>