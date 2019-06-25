<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>

<meta charset="utf-8">


<html>
<head>
<title>Prijava</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body>
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-12">

						<header id="header">
							<h1>
								<h1><a href="index.jsp" id="logo">POZORIŠTE  STAR</a></h1>
									<nav id="nav">
										<a href="index.jsp" >Početna</a>
										<a href="istorijat.jsp">Istorijat</a>
										<a href="repertoar.jsp">Repertoar</a>
									      <a href="rezervacija.jsp">Rezervacija</a>
										<a href="prijava.jsp" class="current-page-item"  >Prijava</a>
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
					<div class="col-3 col-12-medium">

                       	<% String msg1 = (String) request.getAttribute("msg1");
                             if(msg1 != null){
	                                       %>
						<p>
							<%=msg1 %>
						</p>
						<% } %>

						<form action="ServletLogin" method="post">

							<h2>Prijavi se</h2>

							Username <br>
							<br> <input type="text" name="user"
								placeholder="unesite username" required> <br> <br>

							Password <br> <br> <input type="password" name="pass"
								placeholder="unesite password" required> <br> <br>

							<input type="submit" name="submit" class="button" value="Prijavi se">

						</form>

					</div>
					<div class="col-6 col-12-medium imp-medium">
						<% String msg = (String) request.getAttribute("msg");
                             if(msg != null){
	                                       %>
						<p>
							<%=msg %>
						</p>
						<% } %>
						<form action="ServletLogin" method="post">

							<h2>Registracija</h2>
							Username <br>
							<br> <input type="text" name="user1"
								placeholder="unesite username" required> <br> <br>

							Password <br> <br> <input type="password" name="pass1"
								placeholder="unesite password" required> <br> <br>
							Potvrdite password<br> <br> <input type="password"
								name="pass2" placeholder="potvrdi password" required> <br>
							<br> Ime i Prezime <br> <br> <input type="text"
								name="ime" placeholder="unesite ime i prezime"> <br>
							<br> E-mail <br> <br> <input type="text"
								name="mail" placeholder="unesite mail" required> <br>
							<br> <input type="submit" name="submit" class="button"
								value="Registruj se" required>


						</form>

					</div>
					

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
					<div class="col-4 col-12-medium">

					


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