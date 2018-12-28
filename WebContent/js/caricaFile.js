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
	if(descrizione.length<1 || descrizione.lenght>1000)
	{
		document.carica.descrizioneFile.style.borderColor="red";
		return false;
	}
	else
	{
		document.carica.descrizioneFile.style.borderColor="green";
		return true;
	}
}

function controlloFile()
{
	var file=document.getElementById('uploadFile').value;
	if(file.size==0)
	{
		document.carica.uploadFile.style.borderColor="red";
		return false;
	}
	else
	{
		document.carica.uploadFile.style.borderColor="green";
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
		
		document.carica.nomeFile.focus();
		div.append("Inserisci un nome");
	}
	else if(!controlloDescrizione())
	{
		if(!focused){
			document.carica.descrizioneFile.focus();
			focused = true;
		}
		div.append("Inserisci una descrizione");
	}
	else if(!controlloFile())
	{
		if(!focused){
			document.carica.uploadFile.focus();
			focused=true;
		}
		div.append("Inserisci un file")
		}
	}