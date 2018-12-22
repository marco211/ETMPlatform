
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* "%>


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

<title>Aggiungi proposta tesi</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">



</head>


<body>
	<jsp:include page="header.jsp"/>

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




	<div class="container-fluid" style="background-color: #FF9C08">
			<div class="col my-4 mx-4">
				<form action="RegistrazioneServlet" method="post">
					<h1>Aggiungi una nuova proposta di tesi</h1>
					<h6>Inserisci i dati nei campi sottostanti</h6>

						<div class="form-group">
							<label for="inputNome4">Titolo</label> <input type="text"
								class="form-control" name="titolo" placeholder="Titolo" required>
						</div>

						<div class="form-group">
							<label for="inputCognome4">Ambito</label> <input type="text"
								class="form-control" name="ambito" placeholder="Ambito"
								required>
						</div>

					<div class="form-group">
						<label for="inputEmail">Tempo</label> <input type="email"
							class="form-control" name="tempo" placeholder="Tempo" required>
					</div>

					<div class="form-group" >
						<label for="inputMatricola">Descrizione</label>
							<textarea class="form-control" id="exampleTextarea" rows="3" placeholder="Descrizione"></textarea>
					</div>

					<div class="form-group">
						<label for="inputUfficio">Materia</label> <input type="text"
							class="form-control" name="materia" placeholder="Materia"
							>
					</div>
					</div>
					<button type="submit" class="btn btn-primary">Aggiungi</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>