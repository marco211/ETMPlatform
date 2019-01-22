<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.tesi.*,it.unisa.etm.model.bean.*, java.time.* "%>
<%
	Utente utente = (Utente) session.getAttribute("utente");
%>

<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Modifica proposta tesi</title>
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



	<%
		PropostaTesi proposta = (PropostaTesi) request.getAttribute("propostacorrente");
	%>
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<%
			ArrayList<Insegnamento> insegnamenti = (ArrayList<Insegnamento>) request.getAttribute("insegnamenti");
		%>

		<main role="main" class="container">
		<div class="row">
			<div class="col-md-12 my-4">
				<div class="card mb-3">
					<div class="card-body " style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Modifica una proposta di
								tesi&nbsp;</h5>
						</div>
						<form
							action="ConfermaModificaPropostaTesiServlet?proposta_id=<%=proposta.getId()%>"
							method="post" id="aggiungi" name="aggiungiproposta">
							<h6>Inserisci i dati nei campi sottostanti</h6>

							<div class="form-group">
								<label for="inputTitolo">Titolo</label> <input type="text"
									class="form-control" name="titolo" placeholder="Titolo"
									onchange="controlloTitolo()" value="<%=proposta.getTitolo()%>"
									required>
							</div>

							<div class="form-group">
								<label for="inputAmbito">Ambito</label> <input type="text"
									class="form-control" name="ambito" placeholder="Ambito"
									onchange="controlloAmbito()" value="<%=proposta.getAmbito()%>"
									required>
							</div>

							<div class="form-group">
								<label for="inputTempo">Durata</label> <input type="number"
									name="tempo" min="1" class="count" form="aggiungi"
									onchange="controlloTempo()"
									value="<%=proposta.getTempoDiSviluppo()%>"> giorni
							</div>

							<div class="form-group">
								<label for="inputDescrizione">Descrizione</label>
								<textarea class="form-control" id="descrizione" rows="6"
									placeholder="Descrizione" name="descrizione" form="aggiungi"><%=proposta.getDecrizione()%></textarea>
							</div>
							<div class="col-sm-3">
								<select class="form-control" name="materia">
									<option value="<%=proposta.getMaterie()%>"><%=proposta.getMaterie()%></option>

									<%
										for (Insegnamento i : insegnamenti) {
									%>
									<option value="<%=i.getNome()%>"><%=i.getNome()%></option>
									<%
										}
									%>
								</select>
							</div>
							<script type="text/javascript">
								$(document).ready(function() {
									$('.form-control').combobox();
								});
							</script>

							<div id="infoDiv"
								class="alert alert-danger form-group d-none my-3" role="alert">Attenzione!</div>
							<button type="button" class="btn btn-primary mx-3 my-3"
								name="invio" onclick="validazione()">Modifica</button>
						</form>
					</div>
				</div>
			</div>

		</div>
		</main>
	</div>

	<jsp:include page="footer.jsp" />
	<script src="js/validazionePropostaTesi.js"></script>


</body>
</html>