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
	var c=descrizione.length;
	if(descrizione.length==0 || c>1000 )
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
	
	if(!controlloNomeConsegna()){
		
		document.caricaConsegna.nomeConsegna.focus();
		div.append("Inserisci un nome");
		focused=true;
		
	}
	else if(!controlloDescrizioneConsegna())
	{
		var descrizione=document.caricaConsegna.descrizioneConsegna.value;
		var c=descrizione.length;
		if(c<1)
		{
			div.append("Inserisci una descrizione");
			document.caricaConsegna.descrizioneConsegna.focus();
			focused=true;
			
		}
		else if(c>1000)
		{
			div.append("La descrizione deve essere minore di mille caratteri");
			document.caricaConsegna.descrizioneConsegna.focus();
			focused=true;
			
		}
	}
	else if(!controlloScadenzaConsegna()){
			document.caricaConsegna.scadenzaConsegna.focus();
		div.append("Inserisci una data valida");
		focused=true;
		
	}

	if(focused==true){
		return false;
	}
	else{
		document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
		return true;
	}
}