<%@page import="domen.User"%>
<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> <%  
HttpSession sesija=request.getSession();
User user=(User)sesija.getAttribute("ulogovanKorisnik");
if(user != null){
	

%>
<p><%-- <%= user.getUsername() %> --%> </p>
<% }else{
	response.sendRedirect("index.jsp");
}
%>


</body>
</html>