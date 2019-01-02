function controlloNome()
{
	var nome=document.modificaProfilo.nome.value;
	if(nome.length==0)
	{
		document.modificaProfilo.nome.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaProfilo.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var cognome=document.modificaProfilo.cognome.value;
	if(cognome.length==0)
	{
		document.modificaProfilo.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaProfilo.cognome.style.borderColor="green";
		return true;
	}
}

function controlloMatricola()
{
	var lettere6=/^[0-9]{10}$/;
	var matricola=document.modificaProfilo.matricola.value;
	if(!matricola.match(lettere6))
	{
		document.modificaProfilo.matricola.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaProfilo.matricola.style.borderColor="green";
		return true;
	}
}


function controlloUfficio()
{
	var ufficio=document.modificaProfilo.ufficio.value;
	if(ufficio.length==0)
	{
		document.modificaProfilo.ufficio.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaProfilo.ufficio.style.borderColor="green";
		return true;
	}
}

function controlloData()
{
	var lettere6=/^[0-9]{2}$/;
	var lettere7=/^[0-9]{4}$/;
	var data=document.modificaProfilo.data.value;
	var giorno=data.substring(8,10);
	var mese=data.substring(5,7);
	var anno=data.substring(0,4);
	if(!giorno.match(lettere6))
	{
		document.modificaProfilo.data.style.borderColor="red";
		return false;
	}
	else if(!mese.match(lettere6))
	{
		document.modificaProfilo.data.style.borderColor="red";
		return false;
	}
	else if(!anno.match(lettere7))
	{
		document.modificaProfilo.data.style.borderColor="red";
		return false;
	}
	else
	{
		document.modificaProfilo.data.style.borderColor="green";
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
		
		document.modificaProfilo.nome.focus();
		div.append("Inserisci un nome");
	}
	else if(!controlloCognome())
	{
		if(!focused){
			document.modificaProfilo.cognome.focus();
			focused = true;
		}
		div.append("Inserisci un cognome");
	}
	else if(!controlloData())
	{
		var lettere6=/^[0-9]{2}$/;
		var lettere7=/^[0-9]{4}$/;
		var data=document.modificaProfilo.data.value;
		var giorno=data.substring(8,10);
		var mese=data.substring(5,7);
		var anno=data.substring(0,4);
		if(!giorno.match(lettere6))
		{
			document.modificaProfilo.data.style.borderColor="red";
			return false;
		}
		else if(!mese.match(lettere6))
		{
			document.modificaProfilo.data.style.borderColor="red";
			return false;
		}
		else if(!anno.match(lettere7))
		{
			document.modificaProfilo.data.style.borderColor="red";
			return false;
		}
		else
		{
			document.modificaProfilo.data.style.borderColor="green";
			return true;
		}
	}
	else
	{
		var tipo=document.modificaProfilo.tipo.value;
		if(tipo=="s")
		{
			if(!controlloMatricola())
			{
				if(!focused){
					document.modificaProfilo.matricola.focus();
					focused = true;
				}
				div.append("Matricola inserita non valida");
				return false;
			}
		}
		else
		{
			if(!controlloUfficio())
			{
				if(!focused){
					document.modificaProfilo.ufficio.focus();
					focused = true;
				}
				div.append("Inserisci l'ufficio");
				return false;
			}
		}
			document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
			document.modificaProfilo.submit();
		}
	}
