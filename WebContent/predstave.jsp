<%@page import="domen.Predstave"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.DaoImplPredstave"%>
<%@page import="dao.DaoPredstave"%>
<%@ page language="java" contentType="text/html;charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ include file="redirekcija.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% DaoPredstave dk=new DaoImplPredstave();  
List<Predstave>list=dk.vratiPredstave();

%>

<!-- admin deo za insert,update,delete ,predstava -->
<form action="/PozoristeProjekat/akcija/insertPredstava" method="post">
<table>
<tr> 
<td>naziv <input type="text" name="txt_naziv"></td> 
<br> <br>
<td>cena <input type="number" name="txt_cena"></td>

</tr>

<tr> 
<td><input type="submit" value="unesi Predstavu"></td>
</tr>
<% if(list != null) {
 for(Predstave p:list){ %>
<tr>

<td><label> <%=p.getNaziv() %> </label> </td>
<td><a href="/PozoristeProjekat/akcija/updatePredstave?id=<%=p.getId_predstave()%>&naziv= <%=p.getNaziv()%>">Update </a></td>
<td><a href="/PozoristeProjekat/akcija/deletePredstave?id=<%=p.getId_predstave()%>"> Delete </a>  </td>
</tr>

<%}
 } %>



</table>
</form>
</body>
</html>