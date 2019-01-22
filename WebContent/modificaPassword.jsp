<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Modifica Password</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>


<body>
	<jsp:include page="header.jsp" />

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
	<script type="text/javascript" src="js/modificaPassword.js"></script>



	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 81vh;">
		<section id="cover">
			<div id="cover-caption">
				<div id="container" class="container">
					<div class="row text-black">
						<div class="col-sm-10 offset-sm-1 text-center py-5">
							<img src="https://www.unisa.it/rescue/img/logo_cc.png"
								class="img-fluid" alt="Responsive image">
							<p>Inserisci due volte la nuova password per apportare la
								modifica.</p>
								
							<form action="ModificaPasswordServlet" method="post"
								name="modificaPassword"
								class="form-inline justify-content-center">
								<div class="info-form">
									<div class="form-group">
										<label class="sr-only">Nuova Password</label> <input
											type="password" onchange="controlloPassword()"
											name="password" class="form-control"
											placeholder="Nuova Password"> <input type="password"
											onchange="controlloPassword2()" name="password2"
											class="form-control" placeholder="Conferma Password">

									</div>

								</div>
								<br>
								<button type="submit" class="btn btn-success"
									onclick="return validazione()">Modifica password</button>
							</form>
							<div class="col text-center mt-3">
								<div id="infoDiv" class="alert alert-danger form-group d-none"
									role="alert"></div>
						
						</div>
					</div>
				</div>
			</div>

		</section>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>