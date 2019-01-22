<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, it.unisa.etm.control.tesi.*,it.unisa.etm.model.bean.*"%>

<%
Utente docente = (Utente) session.getAttribute("docente");
PropostaTesi propostatesi = (PropostaTesi) request.getAttribute("propostatesi");
if(propostatesi==null){
	response.sendRedirect("./index.jsp");
    return;
}

Utente utente = (Utente) session.getAttribute("utente");
if(utente==null){
	response.sendRedirect("./index.jsp");
    return;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>ETM Platform - Dettagli proposta tesi</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>
<body>

	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<div class="container emp-profile">
							<div class="row">
								<div class="col-md-4">
									<div class="profile-img">
										<img alt="load" src="img/logo.png" width="100%">
									</div>
								</div>
								<div class="col-md-6">
									<div class="profile-head">
										<h5 class="card-title"><%=propostatesi.getTitolo()%></h5>
										<ul class="nav nav-tabs" id="myTab" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												id="home-tab" data-toggle="tab" href="#home" role="tab"
												aria-controls="home" aria-selected="true">Informazioni
													della proposta di tesi</a></li>
										</ul>
									</div>
								</div>
							</div>
							<%
    				ArrayList<Utente> utenti = (ArrayList<Utente>)request.getAttribute("utenti");
    				if(utente.getEmail().equals(propostatesi.getUtenteEmail())){
    				boolean b = false;
    				for(Utente u : utenti){
    						if(u.getPropostaTesi_Id()==propostatesi.getId())
    							b = true;
    				}if(b){
    					if(!propostatesi.isArchiviato()){
    				%>

							<div class="col-md-6">

								<p class="py-0 my-0" style="font-size: small;">
									<i class="fas fa-exclamation pr-2 mt-1"></i>A questa proposta
									di tesi vi stanno partecipando uno o piu studenti.
								</p>

							</div>
							<%}}} %>
							<%if((propostatesi.isChiuso())&&(!propostatesi.isArchiviato())){%>
							<div class="col-md-6">
								<p class="py-0 my-0" style="font-size: small;">
									<i class="fas fa-exclamation pr-2"></i>La proposta di tesi e <u
										data-toggle="tooltip" data-placement="bottom"
										title="La proposta tesi e terminata e non piu accessibile a nuove richiesta">chiusa</u>
								</p>
							</div>
							<%} %>
							<%if(propostatesi.isArchiviato()){%>
							<div class="col-md-6">
								<p class="py-0 my-0" style="font-size: small;">
									<i class="fas fa-exclamation pr-2 mt-1"></i>Questa proposta di
									tesi e stata completata
								</p>
								<p class="py-0 my-0" style="font-size: small;">
									<i class="fas fa-exclamation pr-2"></i>La proposta di tesi e <u
										data-toggle="tooltip" data-placement="bottom"
										title="La proposta tesi e terminata e non piu accessibile a nuove richiesta">archiviata</u>
								</p>
							</div>
							<%} %>
							<div class="row">
								<div class="col-md-8">
									<div class="tab-content profile-tab" id="myTabContent">
										<div class="tab-pane fade show active" id="home"
											role="tabpanel" aria-labelledby="home-tab">
											<div class="row">
												<div class="col-md-6">
													<label>Descrizione: </label>
												</div>
												<div class="col-md-6">
													<p><%=propostatesi.getDecrizione()%></p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Ambito:</label>
												</div>
												<div class="col-md-6">
													<p><%=propostatesi.getAmbito()%></p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Cognome dell'autore:</label>
												</div>
												<div class="col-md-6">
													<p><%=docente.getCognome()%></p>
												</div>
											</div>

											<div class="row">
												<div class="col-md-6">
													<label>Nome dell'autore:</label>
												</div>
												<div class="col-md-6">
													<p><%=docente.getNome() %></p>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


			<aside class="col-md-4 my-4">
			<div class="list-group p-3 card">
				<div class="card-body">
					<%if(utente.getEmail().equals(propostatesi.getUtenteEmail())){
  		 		boolean c = false;
    			if((!propostatesi.isChiuso())&&(!propostatesi.isArchiviato())){%>
					<a class="btn bg-warning "
						href="ChiudiPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>"
						id="ChiudiProposta" data-toggle="tooltip" data-placement="bottom"
						title="Chiudi la proposta tesi: essa e terminata e non piu accessibile a nuove richiesta"><i
						class="fas fa-door-closed "></i></a>
					<%c=true;} %>
					<%if(!propostatesi.isArchiviato()){ %>
					<a class="btn bg-warning "
						href="ArchiviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>"
						id="ArchiviaProposta" data-toggle="tooltip"
						data-placement="bottom"
						title="Archivia la proposta tesi: essa e ancora in atto ma non piu accessibile a nuove richiesta"><i
						class="fas fa-archive " style="display: inline"></i></a> <a
						class="btn bg-warning "
						href="ModificaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>&propostatesi_titolo=<%=propostatesi.getTitolo()%>&propostatesi_ambito=<%=propostatesi.getAmbito()%>&propostatesi_tempo=<%=propostatesi.getTempoDiSviluppo()%>&propostatesi_descrizione=<%=propostatesi.getDecrizione()%>&propostatesi_materia=<%=propostatesi.getMaterie()%>"
						id="ModificaProposta" data-toggle="tooltip"
						data-placement="bottom" title="Modifica la proposta tesi"><i
						class="fas fa-edit" style="display: inline"></i></a>
					<% c=true;}%>

					<a class="btn bg-warning "
						href="RimuoviPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId()%>"
						" id="RimuoviProposta" data-toggle="tooltip"
						data-placement="bottom" title="Rimuovi la proposta tesi"><i
						class="fas fa-trash-alt"></i></a>

					<%
    			if(!c){
    				%>
					<p>Questa proposta di tesi e stata completata</p>
					<%}
    			}else if(utente.getTipo().equals("d")){%>
					<p>Questa non e una tua proposta di tesi</p>
					<%}else{
    				boolean b2 = false;
    			ArrayList<RichiestaPartecipazione> richieste2 =(ArrayList<RichiestaPartecipazione>)request.getAttribute("richiesteproposte");
    			if(utente.getTipo().equals("s")){
    				if(utente.getPropostaTesi_Id()==0){
    			if(utente.getPropostaTesi_Id()!=propostatesi.getId()) {
    				if(richieste2!=null){
	    				for(RichiestaPartecipazione r : richieste2){
	    					if(r.getPropostatesi_id()==propostatesi.getId()){
	    						b2 = true;
	    					}
    				}
    				}if(!b2){ %>
					<a class="alert-link"
						href="InviaPropostaTesiServlet?propostatesi_id=<%=propostatesi.getId() %>"
						class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
						id="AddRichiesta"><i class="fas fa-plus-circle">Invia
							richiesta di partecipazione&nbsp;</i></a>
					<%}else{%>
					<p>Hai gia inviato una richiesta di partecipazione</p>
					<%}}}}} %>
					<hr>
					<p>
						Materia/e:
						<%=propostatesi.getMaterie()%></p>
					<hr>
					<p>
						Tempo di sviluppo:
						<%=propostatesi.getTempoDiSviluppo()%>
						giorni
					</p>
					<hr>
					<a
						href="VisualizzaProfiloUtenteServlet?utente_email=<%=docente.getEmail() %>"><i
						class="fas fa-user"></i>&nbsp; <%=docente.getEmail()%></a>
				</div>
			</div>
			</aside>
		</div>
		</main>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>