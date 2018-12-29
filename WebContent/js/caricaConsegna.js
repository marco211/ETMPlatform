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
	else if(!controlloScadenzaConsegna()){
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