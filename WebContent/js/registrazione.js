function cambiaDocente(){
	document.getElementById("insegnamentoID").className = "form-group d-block";
	document.getElementById("matricolaID").className = "form-group d-none";
	document.getElementById("ufficioID").className = "form-group d-block";
}

function cambiaStudente(){
	document.getElementById("insegnamentoID").className = "form-group d-none";
	document.getElementById("matricolaID").className = "form-group d-block";
	document.getElementById("ufficioID").className = "form-group d-none";
}

