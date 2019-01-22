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
	var c=descrizione.length;
	if(descrizione.length==0 || c>1000 )
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
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	
	if(!controlloVoto()){
		
		document.valuta.voto.focus();
		div.append("Inserisci una valutazione");
		focused=true;
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	}
	else if(!controlloDescrizione())
	{
		var descrizione=document.valuta.descrizione.value;
		var c=descrizione.length;
		if(c<1)
		{
			div.append("Inserisci una descrizione");
			document.valuta.descrizione.focus();
			focused=true;
			document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
		}
		else if(c>1000)
		{
			div.append("La descrizione deve essere minore di mille caratteri");
			document.valuta.descrizione.focus();
			focused=true;
			document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
		}
	}
	
	if(focused==true){
		return false;
	}
	else{
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
		return true;
	}
}