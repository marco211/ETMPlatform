function controlloVoto()
{
	var voto=document.valuta.voto.value;
	if(voto==null || voto==0)
	{
		document.valuta.voto.style.borderColor="red";
		return false;
	}
	else
	{
		document.valuta.voto.style.borderColor="green";
		return true;
	}
}

function controlloDescrizione()
{
	var descrizione=document.valuta.descrizione.value;
	if(descrizione.length<1 || descrizione.lenght>1000)
	{
		document.valuta.descrizione.style.borderColor="red";
		return false;
	}
	else
	{
		document.valuta.descrizione.style.borderColor="green";
		return true;
	}
}

function validazione()
{
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	
	if(!controlloVoto()){
		
		document.valuta.voto.focus();
		div.append("Inserisci una valutazione");
	}
	else if(!controlloDescrizione())
	{
		if(!focused){
			document.valuta.voto.focus();
			focused = true;
		}
		div.append("Inserisci una descrizione");
	}
}