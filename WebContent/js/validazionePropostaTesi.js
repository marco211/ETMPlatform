function controlloTitolo()
{
	var titolo=document.aggiungiproposta.titolo.value;
	if(titolo.length==0)
	{
		document.aggiungiproposta.titolo.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiproposta.titolo.style.borderColor="green";
		return true;
	}
}

function controlloAmbito()
{
	var ambito=document.aggiungiproposta.ambito.value;
	if(ambito.length==0)
	{
		document.aggiungiproposta.ambito.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiproposta.ambito.style.borderColor="green";
		return true;
	}
}

function controlloDescrizione()
{
	var descrizione=document.aggiungiproposta.descrizione.value;
	if(descrizione.length==0)
	{
		document.aggiungiproposta.descrizione.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiproposta.descrizione.style.borderColor="green";
		return true;
	}
}

function controlloTempo()
{
	var tempo=document.aggiungiproposta.tempo.value;
	if(tempo.length==0 || tempo<=0)
	{
		document.aggiungiproposta.descrizione.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiproposta.descrizione.style.borderColor="green";
		return true;
	}
}

function validazione()
{
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	
	if(!controlloTitolo()){
		document.aggiungiproposta.titolo.focus();
		div.append("Inserisci un titolo");
	}
	else if(!controlloAmbito())
	{
		if(!focused){
			document.aggiungiproposta.ambito.focus();
			focused = true;
		}
		div.append("Inserisci un ambito");
	}
	else if(!controlloDescrizione())
	{
		if(!focused){
			document.aggiungiproposta.descrizione.focus();
			focused = true;
		}	
		div.append("Inserisci una descrizione");
	}
	else if(!controlloTempo())
	{
		if(!focused){
			document.aggiungiproposta.tempo.focus();
			focused = true;
		}	
		div.append("La proposta tesi deve avere una durata di almeno 1 giorno");
	}
		else
		{
			document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
			document.aggiungiproposta.submit();
		}
	}