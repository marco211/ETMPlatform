function controlloNome()
{
	var nome=document.carica.nomeFile.value;
	if(nome.length==0 || nome.length>30)
	{
		document.carica.nomeFile.style.borderColor="red";
		return false;
	}
	else
	{
		document.carica.nomeFile.style.borderColor="green";
		return true;
	}
}

function controlloDescrizione()
{
	var descrizione=document.carica.descrizioneFile.value;

	if(descrizione.length==0 || descrizione.lenght>5 )
	{
		document.carica.descrizioneFile.style.borderColor="red";
		return false;
		if(!descrizione.lenght>5){
			alert("mammt");
		}
	}
	else
	{
		document.carica.descrizioneFile.style.borderColor="green";
		return true;
	}
}

function validazione()
{
	document.getElementById("infoDiv").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDiv");
	
	div.text("");
	
	if(!controlloNome()){
		var nome=document.carica.nomeFile.value;
		if(nome.length==0){
			document.carica.nomeFile.focus();
			div.append("Inserisci un nome");
		} else if(nome.length>30){
			document.carica.nomeFile.focus();
			div.append("Il nome del file deve essere minore di trenta caratteri");	
		}
	}
	else if(!controlloDescrizione())
	{
		if(!focused){
			
	
		var descrizione=document.carica.descrizioneFile.value;
		if(descrizione.length<1)
		{
			div.append("Inserisci una descrizione");
			document.carica.descrizioneFile.focus();
			
		}
		else if(descrizione.length>5)
		{
			div.append("La descrizione deve essere minore di mille caratteri");
			document.carica.descrizioneFile.focus();
			
		}
		focused = true;
		}
	}else
	{
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
		document.carica.submit();
	}
}