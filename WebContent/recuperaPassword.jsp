<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Recupera password</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-light" style="background-color:#FF9C08">
	<h3>ETM Platform</h3>
	<ul class="nav justify-content-center">
		<li class="nav-item d-none d-lg-block">
			<form class="form-inline" action="#" method="post">
				<input type="email" class="form-control mb-2 mr-sm-2"
					name="emailLogin" placeholder="E-mail" required>
				<div class="input-group mb-2 mr-sm-2">
					<div class="input-group-prepend">
						<input type="password" class="form-control" name="passwordLogin"
							placeholder="Password" required> <a href="#"><label
							class="px-2 py-2">password dimenticata</label></a>
					</div>
				</div>
				<button type="submit" class="btn btn-primary mb-2">Login</button>
			</form>
		</li>

		<li class="d-lg-none d-xl-none">
			<div class="dropdown">
				<button class="btn btn-secondary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Effettua il login</button>

				<form class="dropdown-menu p-4" action="#" method="post">
					<div class="form-group">
						<label for="exampleDropdownFormEmail2">E-mail</label> <input
							type="email" class="form-control" name="emailLogin"
							placeholder="E-mail" required>
					</div>

					<div class="form-group">
						<label for="exampleDropdownFormPassword2">Password</label> <input
							type="password" class="form-control" name="passwordLogin"
							placeholder="Password" required>
					</div>

					<div class="form-group">
						<a href="#"> <label class="form-check-label"
							for="dropdownCheck2"> password dimenticata </label>
						</a>
					</div>
					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</li>
	</ul>
	</nav>


	<section id="cover">
	<div id="cover-caption">
		<div id="container" class="container">
			<div class="row text-black">
				<div class="col-sm-10 offset-sm-1 text-center py-5">
					<img src="https://www.unisa.it/rescue/img/logo_cc.png"
						class="img-fluid" alt="Responsive image">
					<p>Per effettuare il recuperdo della password inserisci la mail
						con la quale ti sei registrato</p>
					<div class="info-form">
						<form action="RecuperaPasswordServlet" method="post"
							name="recupero_password"
							class="form-inline justify-content-center">
							<div class="form-group">
								<label class="sr-only">Email</label> <input type="text"
									name="email" class="form-control "
									placeholder="mario.rossi@gmail.com" onchange="controlloEmail()"
									required>
							</div>
					</div>
					<br>
					<button type="button" class="btn btn-success "
						onclick="validazione()">Recupera password</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	</section>
	<jsp:include page="footer.jsp" />

	<script src="js/validazioneRecuperoPassword.js"></script>

</body>
</html>