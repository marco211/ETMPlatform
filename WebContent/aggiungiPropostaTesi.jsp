
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.unisa.etm.bean.* "%>


<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="css/stile.css">
    <title>ETM Platform - Aggiungi proposta tesi</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
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




	<div style="background-color: #FF9C08; min-height: 81vh;">
			
				
			<div class="col my-4 mx-4">
				<form action="AggiungiPropostaTesiServlet" method="post" id="aggiungi">
					<h1>Aggiungi una nuova proposta di tesi</h1>
					<h6>Inserisci i dati nei campi sottostanti</h6>

						<div class="form-group col-4 pt-4">
							<label for="inputTitolo">Titolo</label> <input type="text"
								class="form-control" name="titolo" placeholder="Titolo" required>
						</div>

						<div class="form-group col-4">
							<label for="inputAmbito">Ambito</label> <input type="text"
								class="form-control" name="ambito" placeholder="Ambito"
								required>
						</div>

					<div class="form-group col-4">
                        <label for="inputTempo">Tempo</label> <input type="number" class="count" name="tempo" value="1">
					</div>

					<div class="form-group col-5" >
						<label for="inputDescrizione">Descrizione</label>
							<textarea class="form-control" id="descrizione" rows="6" placeholder="Descrizione" name="descrizione" form="aggiungi"></textarea>
					</div>

					<div class="form-group col-4">
						<label for="inputMateria">Materia</label> <input type="text"
							class="form-control" name="materia" placeholder="Materia"
							>
					</div>
					
					
					<button type="submit" class="btn btn-primary col-2 my-2">Aggiungi</button>
					</div>
				</form>
			</div>
			
		</div>
		
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>