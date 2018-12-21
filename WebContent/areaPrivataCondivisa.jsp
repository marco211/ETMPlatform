<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.unisa.etm.bean.*,java.util.*"%>
<% String tipo= (String)session.getAttribute("tipo");
if(tipo==null){
	response.sendRedirect("./index.jsp");
	return;
}
ArrayList<File> file = (ArrayList<File>) session.getAttribute("listaFile");
if(file==null){
	response.sendRedirect("./VisualizzaListaFileServlet");
}
ArrayList<Consegna> consegne = (ArrayList<Consegna>)  session.getAttribute("listaConsegne");
if(consegne==null){
	response.sendRedirect("./VisualizzaListaConsegneServlet");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area Privata Condivisa</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div style="background-color: #FF9C08">
		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3">
					<div class="card-body">
						<form class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Area Privata Condivisa&nbsp;</h5>
							<%if(tipo.equals("s")){ %>
							<button type="button"
								class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
								id="CercaProposta">
								<span class="fa fa-archive"></span>
							</button>
							<%} %>
							<button type="button"
								class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
								id="AddProposta">
								<i class="fas fa-plus-circle"></i>
							</button>
						</form>
						<ul class="list-group list-group-flush">
						<%for(int i=0; i<file.size();i++){ %>
							<li class="list-group-item"><a href="#"><%file.get(i).getNome();%></a></li>
						<%}%>
						</ul>
					</div>
				</div>

			</div>


			<aside class="col-md-4 my-4">
			<div class="p-3 card">
			<% if(tipo.equals("s")){ %>
				<h4 class="font-italic">To Do List</h4>
				<ul class="list-group list-group-flush">
				 <%for(int i=0; i<consegne.size();i++){  %>
					<li class="list-group-item"><a href="#"><%consegne.get(i).getNome();%></a></li>
				<%} %>
				</ul>
					<%}else if(tipo.equals("d")){%>
					<h4 class="font-italic">Impostazioni</h4>
				<ul class="list-group list-group-flush">
					<li class="list-group-item"><a href="#">Visualizza storico attivita'</a></li>
				</ul>
				<%} %>
			</div>
			</aside>
</div>
</main>
</div>

<jsp:include page="footer.jsp" />
