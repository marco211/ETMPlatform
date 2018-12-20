<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>

 	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <title>ETM Platform</title>
  	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  
  </head>

	
<body>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/registrazione.js"></script>

<nav class="navbar navbar-light" style="background-color:#FF9C08">
  <h3>ETM Platform</h3>
  <ul class="nav justify-content-center">
	  <li class="nav-item d-none d-lg-block">
		<form class="form-inline" action="LoginServlet" method="post">
			<input type="email" class="form-control mb-2 mr-sm-2" name="emailLogin" placeholder="E-mail" required>
			<div class="input-group mb-2 mr-sm-2">
				<div class="input-group-prepend">
				    <input type="password" class="form-control" name="passwordLogin" placeholder="Password" required>
				  	<a href="#"><label class="px-2 py-2">password dimenticata</label></a>
				 </div>
			</div>
			<button type="submit" class="btn btn-primary mb-2">Login</button>
		</form>
	  </li>
	  
	  <li class="d-lg-none d-xl-none">
		  <div class="dropdown">
		  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    	Effettua il login 
		  </button>
		
			<form class="dropdown-menu p-4" action="LoginServlet" method="post">
	  			<div class="form-group">
			    <label for="exampleDropdownFormEmail2">E-mail</label>
			    <input type="email" class="form-control" name="emailLogin" placeholder="E-mail" required>
			  	</div>
	  
	  			<div class="form-group">
			    <label for="exampleDropdownFormPassword2">Password</label>
			    <input type="password" class="form-control" name="passwordLogin" placeholder="Password" required>
			  	</div>
			  
		 		 <div class="form-group">
		 		 	<a href="#">
			    		<label class="form-check-label" for="dropdownCheck2">
			     		 password dimenticata
			    		</label>
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
      		<label>ETM Platform:</label>
      		<label>Un modo semplice e voloce per gestire le tue tesi</label>
      		<img alt="load" src="img/logo.png" width="100%">
      	</div>
    </div>
    <div class="col my-4 mx-4">
    	<form action="RegistrazioneServlet" method="post">
    		<h1>Iscriviti</h1>
    		<h6>Gestisci facilmente la tua tesi</h6>
    		
	    	<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="tipo" value="s" checked="checked" onclick="cambiaStudente()">
				  <label class="form-check-label" for="inlineRadio1">Studente</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="tipo" value="d" onclick="cambiaDocente()">
				<label class="form-check-label" for="inlineRadio2">Docente</label>
			</div>
	
		  
    	
		  	<div class="form-row">
		    	<div class="form-group col-md-6">
		      		<label for="inputNome4">Nome</label>
		      		<input type="text" class="form-control" name="nome" placeholder="Nome" required>
		    </div>
		    
		    <div class="form-group col-md-6">
		      <label for="inputCognome4">Cognome</label>
		      <input type="text" class="form-control" name="cognome" placeholder="Cognome" required>
		    </div>
		  </div>
		  
		  <div class="form-group">
			  <label for="inputEmail">E-mail</label>
			  <input type="email" class="form-control" name="email" placeholder="E-mail" required>
		  </div>
		  
		   <div class="form-group" id="matricolaID">
			  <label for="inputMatricola">Matricola</label>
			  <input type="text" class="form-control" name="matricola" placeholder="Matricola" required>
		  </div>
		  
		  <div class="form-group d-none" id="insegnamentoID">
		    <label for="inputInsegnamento">Insegnamento</label>
		    <input type="text" class="form-control" name="insegnamento" placeholder="Insegnamento" required>
		  </div>
		  
		  <div class="form-group d-none" id="ufficioID">
		    <label for="inputUfficio">Ufficio</label>
		    <input type="text" class="form-control" name="ufficio" placeholder="Ufficio" required>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputPassword">Password</label>
		    <input type="text" class="form-control" name="password" placeholder="Password" required>
		  </div>
		  
		   <div class="form-group">
		    <label for="inputData">Data di nascita</label>
		    <input type="date" class="form-control" name="data" required>
		  </div>
		  
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox"name="check" required>
		      <label class="form-check-label" for="gridCheck">
		        Spuntando questa casella, accetti le nostre normative sulla privacy
		      </label>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary">Sign in</button>
		</form>
    </div>
  </div>
 </div>

</body>
</html>