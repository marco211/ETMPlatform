function controlloNome()
{
	var lettere=/^[a-z A-Z]+$/;
	var lettere2=/^[ ]+$/;
	var nome=document.registrazione.nome.value;
	if(nome.length==0 || nome.length>30 || !nome.match(lettere))
	{
		document.registrazione.nome.style.borderColor="red";
		return false;
	}
	else if(nome.match(lettere2))
	{
		document.registrazione.nome.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var lettere=/^[a-z A-Z]+$/;
	var lettere2=/^[ ]+$/;
	var cognome=document.registrazione.cognome.value;
	if(cognome.length==0 || cognome.length>30 || !cognome.match(lettere))
	{
		document.registrazione.cognome.style.borderColor="red";
		return false;
	}
	else if(cognome.match(lettere2))
	{
		document.registrazione.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.cognome.style.borderColor="green";
		return true;
	}
}

function controlloEmail()
{
	var lettere5=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	var email=document.registrazione.email.value;
	if(email.length<10 || email.length>40)
	{
		document.registrazione.email.style.borderColor="red";
		return false;
	}
	else if(!email.match(lettere5))
	{
		document.registrazione.email.style.borderColor="red";
		return false;
	}
	else
	{
		var tipo=document.registrazione.tipo.value;
		if(tipo=="s")
		{
			if(email.substring(email.indexOf("@"), email.length)==='@studenti.unisa.it')
			{
				document.registrazione.email.style.borderColor="green";
				return true;
			}
			else
			{
				document.registrazione.email.style.borderColor="red";
				return false;
			}
		}
		else
		{
			if(email.substring(email.indexOf("@"), email.length)==='@unisa.it')
			{
				document.registrazione.email.style.borderColor="green";
				return true;
			}
			else
			{
				document.registrazione.email.style.borderColor="red";
				return false;
			}
		}	
	}
}

function controlloMatricola()
{
	var lettere6=/^[0-9]{10}$/;
	var matricola=document.registrazione.matricola.value;
	if(!matricola.match(lettere6))
	{
		document.registrazione.matricola.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.matricola.style.borderColor="green";
		return true;
	}
}

function controlloInsegnamento()
{
	var insegnamento=document.registrazione.insegnamento.value;
	if(insegnamento.length==0 || insegnamento.length>50)
	{
		document.registrazione.insegnamento.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.insegnamento.style.borderColor="green";
		return true;
	}
}

function controlloUfficio()
{
	var ufficio=document.registrazione.ufficio.value;
	if(ufficio.length==0 || ufficio.length>50)
	{
		document.registrazione.ufficio.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.ufficio.style.borderColor="green";
		return true;
	}
}

function controlloPassword()
{
	var lettere4=/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z]{8,16}$/ //8-16 caratteri(1 cifra,1 lettera mi e ma)
	var password=document.registrazione.password.value;
	if(!password.match(lettere4))
	{
		document.registrazione.password.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.password.style.borderColor="green";
		return true;
	}
}

function controlloData()
{
	var lettere6=/^[0-9]{2}$/;
	var lettere7=/^[0-9]{4}$/;
	var data=document.registrazione.data.value;
	var giorno=data.substring(8,10);
	var mese=data.substring(5,7);
	var anno=data.substring(0,4);
	if(!giorno.match(lettere6))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else if(!mese.match(lettere6))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else if(!anno.match(lettere7))
	{
		document.registrazione.data.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.data.style.borderColor="green";
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
		var nome=document.registrazione.nome.value;
		if(nome.length>30)
		{
			document.registrazione.nome.focus();
			div.append("Nome inserito troppo lungo");
		}
		else
		{
			document.registrazione.nome.focus();
			div.append("Inserisci un nome");
		}

	}
	else if(!controlloCognome())
	{
		if(!focused){
			document.registrazione.cognome.focus();
			focused = true;
		}
		var cognome=document.registrazione.cognome.value;
		if(cognome.length>30)
		{
			div.append("Cognome inserito troppo lungo");
		}
		else
		{
			div.append("Inserisci un cognome");
		}
	}
	else if(!controlloEmail())
	{
		if(!focused){
			document.registrazione.email.focus();
			focused = true;
		}	
		div.append("E-mail inserita non valida");
	}
	else
	{
		var tipo=document.registrazione.tipo.value;
		if(tipo=="s")
		{
			if(!controlloMatricola())
			{
				if(!focused){
					document.registrazione.matricola.focus();
					focused = true;
				}
				div.append("Matricola inserita non valida");
				return false;
			}
		}
		else
		{
			if(!controlloInsegnamento())
			{
				if(!focused){
					document.registrazione.insegnamento.focus();
					focused = true;
				}
				var insegnamento=document.registrazione.insegnamento.value;
				if(insegnamento.length>50)
				{
					div.append("Insegnamento inserito troppo lungo");
				}
				else
				{
					div.append("Inserisci un insegnamento");
				}
				return false;
			}
			else if(!controlloUfficio())
			{
				if(!focused){
					document.registrazione.ufficio.focus();
					focused = true;
				}
				var ufficio=document.registrazione.ufficio.value;
				if(ufficio.length>50)
				{
					div.append("Ufficio inserito troppo lungo");
				}
				else
				{
					div.append("Inserisci l'ufficio");
				}
				return false;
			}
		}
		if(!controlloPassword())
		{
			if(!focused){
				document.registrazione.password.focus();
				focused = true;
			}
			div.append("La password deve contenere almeno una lettera maiuscola, una lettera minuscola ed un numero e deve avere una lunghezza compresa tra 8 e 16 caratteri.");
		}
		else if(!controlloData())
		{
			if(!focused){
				document.registrazione.data.focus();
				focused = true;
			}
			div.append("Data non valida");
		}
		else if(!document.registrazione.check.checked==true)
		{
			if(!focused){
				document.registrazione.check.focus();
				focused = true;
			}
			div.append("Spuntare la casella in alto");
		}
		else
		{
			document.getElementById("infoDiv").className = "alert alert-danger form-group d-none";
			document.registrazione.submit();
		}
	}
}


