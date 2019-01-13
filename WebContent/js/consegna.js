function scadenza(){
	document.getElementById("scadenzaConsegna").className = "d-none";
	document.getElementById("modificaConsegnaDiv").className = "d-block";
	
}





function controlloScadenzaConsegna(){
	var lettere6=/^[0-9]{2}$/;
	var lettere7=/^[0-9]{4}$/;
	var data=document.caricaConsegna.scadenzaConsegna.value;
	var giorno=data.substring(8,10);
	var mese=data.substring(5,7);
	var anno=data.substring(0,4);
	if(!giorno.match(lettere6))
	{
		document.caricaConsegna.scadenzaConsegna.style.borderColor="red";
		return false;
	}
	else if(!mese.match(lettere6))
	{
		document.caricaConsegna.scadenzaConsegna.style.borderColor="red";
		return false;
	}
	else if(!anno.match(lettere7))
	{
		document.caricaConsegna.scadenzaConsegna.style.borderColor="red";
		return false;
	}
	else
	{
		document.caricaConsegna.scadenzaConsegna.style.borderColor="green";
		return true;
	}
}
	


function validazione()
{
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	if(!controlloScadenzaConsegna()){
		document.caricaConsegna.scadenzaConsegna.focus();
		div.append("Inserisci una data valida");
		focused=true;
		alert("settato");
	}
	if(focused==true){
		alert("entro");
		return false;
	}
	else{
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
		return true;
	}
}