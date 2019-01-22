<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>ETM Platform</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">



</head>


<body>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/registrazione.js"></script>

	<nav class="navbar navbar-light" style="background-color: #FF9C08">
		<h3>ETM Platform</h3>
		<ul class="nav justify-content-center">
			<li class="nav-item d-none d-lg-block">

				<form action="LoginServlet" method="post">
					<div class="form-row">
						<div class="col">
							<input type="email" class="form-control mb-2 mr-sm-2"
								name="emailLogin" placeholder="E-mail" required>
						</div>
						<div class="col">
							<input type="password" class="form-control" name="passwordLogin"
								placeholder="Password" required>
						</div>
						<div class="col">
							<button type="submit" class="btn btn-primary mb-2">Login</button>
						</div>
					</div>

					<div class="form-row">
						<div class="col-4"></div>
						<div class="col">
							<a href="recuperaPassword.jsp">Password dimenticata?</a>
						</div>

					</div>

				</form>
			</li>

			<li class="d-lg-none d-xl-none">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Effettua il
						login</button>

					<form class="dropdown-menu p-4" action="LoginServlet" method="post">
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


	<div class="container-fluid">
		<div class="row">
			<div class="col my-4 mx-4 d-none d-lg-block d-xl-block">
				<div class="mx-auto my-5" style="width: 50%">
					<label>ETM Platform:</label> <label>Un modo semplice e
						veloce per gestire le tue tesi</label> <img alt="load" src="img/logo.png"
						width="100%">
				</div>
			</div>
			<div class="col my-4 mx-4">
				<h1>Registrazione confermata con successo</h1>
				<h6>Adesso &egrave; possibile effettuare l'accesso</h6>
				<h6>
					<a href="http://localhost:8080/ETMPlatform/index.jsp">Torna
						alla home</a>
				</h6>
			</div>
		</div>
	</div>

</body>
</html>