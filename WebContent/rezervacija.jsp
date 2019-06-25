<%@page import="domen.Predstave"%>
<%@page import="java.util.List"%>
<%@page import="dao.DaoPredstave"%>
<%@page import="dao.impl.DaoImplPredstave"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML>

<html>
<head>
<title>rezervacija</title>
<meta charset="utf-8" />

<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />


<% %>

<!--  funkcija za uzimanje id-ja iz combo boxa -->
<script type="text/javascript"> 
function findIdCombo() {
	var id= document.getElementById("predstaveCombo");
	 var idPredstave=id.options[id.selectedIndex].value;
	   document.getElementById("id").value +=idPredstave;
	//   alert("predstava cena"+document.getElementById("id").value);
	   console.log(idPredstave);
	   //dobili smo broj 500jel to to jeste tarleiba sada da uzmes da setujes u skriveno polje a to si vec uradio
	   //jel dobra ovo cenaili nije nije ovo je id predstave
	 //setovsao sam vrednost i id i cenu na serveru uzmi string uradi substring i eto cene jel to ok substring na servletud daparsiraj u int i to je to da isecem id? pa da vazi HVALA!!!!nistaodoh
}//ajde pokreni
</script>

</head>

<body>
	<% DaoPredstave dp= new DaoImplPredstave();
List<Predstave>list=dp.vratiPredstave();
%>
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-12">

						<header id="header">
							<h1>
								<a href="index.jsp" id="logo">POZORIŠTE  STAR</a>
							</h1>
							<nav id="nav">
								<a href="index.jsp">Početna</a> 
								<a href="istorijat.jsp">Istorijat</a>
								<a href="repertoar.jsp">Repertoar</a> 
								<a href="rezervacija.jsp" class="current-page-item">Rezervacija</a> 
								<a href="prijava.jsp">Prijava</a>

							</nav>
						</header>

					</div>
				</div>
			</div>
		</div>

		<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row main-row">
					<div class="col-12">

						<section>
							<% String msg = (String) request.getAttribute("msg");
                             if(msg != null){
	                                       %>
							<p>
								<%=msg %>
							</p>
							<% } %>

							<h2>Izaberite predstavu</h2>
							<form action="ServletRezervacija" method="post">   
								<input type="hidden" id="id" name="id"> <select
									id="predstaveCombo" name="predstave" onchange="findIdCombo()">     <!-- combo koji skuplja predstave iz baze podataka -->
									<% for(Predstave p : list){%>

									<option value="<%=p.getId_predstave()%><%=p.getCena()%>"> <%=p.getNaziv() %> </option>
                                  
      		<br> <br>


										</optgroup>

										<% } %> <br> <br>
								</select> 
								
								<br> <br> <br>
								<br> Izaberite datum : <br> <br>
								 <input type="date" name="datum"> <br> <br> 
								 Unesite  broj karata (maksimalno 5 karata): <br> <br> 
								 <input   type="number" name="kolicina" min="1" max="5"><br>
									
										
							
								<br> Da biste rezervisali karte morate biti ulogovani (ukoliko niste ulogovani bićete automatski prebačeni na stranicu za prijavu) <br>
								<br> 
								<input type="submit" class="button" value="REZERVIŠI">



							</form>


						</section>

					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<div id="footer-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-8 col-12-medium">

							<section>
								
									<div>
										<div class="row">
											<div class="col-3 col-6-medium col-12-small">
												<ul class="link-list" >
													<li><a href="index.jsp">Početna</a></li>
													<li><a href="istorijat.jsp">Istorijat</a></li>
													<li><a href="repertoar.jsp">Repertoar</a></li>
													<li><a href="rezervacija.jsp">Rezervacija</a></li>
													<li><a href="prijava.jsp">Prijava</a></li>
												</ul>
											</div>
											
											
										</div>
									</div>
								</section>

					</div>
					
				</div>
				

					</div>
				</div>
			</div>
		</div>

	</div>



	<!-- Scripts -->


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>
