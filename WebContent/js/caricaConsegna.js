function controlloNomeConsegna()
{
	var nome=document.caricaConsegna.nomeConsegna.value;
	if(nome.length==0 || nome.length>30)
	{
		document.caricaConsegna.nomeConsegna.style.borderColor="red";
		return false;
	}
	else
	{
		document.caricaConsegna.nomeConsegna.style.borderColor="green";
		return true;
	}
}

function controlloDescrizioneConsegna()
{
	var descrizione=document.caricaConsegna.descrizioneConsegna.value;
	if(descrizione.length<1 || descrizione.lenght>1000)
	{
		document.caricaConsegna.descrizioneConsegna.style.borderColor="red";
		return false;
	}
	else
	{
		document.caricaConsegna.descrizioneConsegna.style.borderColor="green";
		return true;
	}
}

function controlloScadenza(){
	var date=/\d{1,2}\/\d{1,2}\/\d{4}/;	
	var scadenza=document.caricaConsegna.scadenzaConsegna.value;
	if(scadenza.match(date)){
		document.caricaConsegna.scadenzaConsegna.style.borderColor="green";
		return true;
	}
	else{
		document.caricaConsegna.scadenzaConsegna.style.borderColor="red";
		return false;
	}
	
}

function validazione()
{
	document.getElementById("infoDivConsegna").className = "alert alert-danger form-group d-block";
	var focused = false;
	var div = $("#infoDivConsegna");
	
	div.text("");
	
	if(!controlloNomeConsegna()){
		
		document.caricaConsegna.nomeConsegna.focus();
		div.append("Inserisci un nome");
	}
	else if(!controlloDescrizioneConsegna())
	{
		if(!focused){
			document.caricaConsegna.descrizioneConsegna.focus();
			focused = true;
		}
		div.append("Inserisci una descrizione");
	}
	else if(!controlloScadenza()){
		if(!focused){
			document.caricaConsegna.scadenzaConsegna.focus();
			focused = true;
		}
		div.append("Inserisci una data valida");
	}
	else
	{
		document.getElementById("infoDivConsegna").className = "alert alert-danger form-group d-none";
		document.caricaConsegna.submit();
	}
}