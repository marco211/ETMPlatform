$(document).ready(notifications());


//Questa funzione chiama la servlet per ottenere il JSON associato alle attività effettuate dall'utente loggato
//Esse vengono quindi inserite nel div con id notifications

function notifications(){

	$.getJSON('CaricaNotificheServlet', function(data){
		if(data != "no"){
			var num_notifications = data.shift();
			if(num_notifications == 0){
				$('#num_notifications').hide();
			}else{
				$('#num_notifications').show();
				$('#num_notifications').text(num_notifications);
			}

			var i;

			// changing backgroud if notification is readed or not

			for(i = 0; i < data.length; i=i+2){
				if(data[i+1] == 0){
					//non letto
					$('#notifications').append("<strong><span class='dropdown-item-text' style='background-color: #BEF6EE;'>" + data[i] + "</span></strong>");

				}else{
					//letto
					$('#notifications').append("<span class='dropdown-item-text' style='background-color: #FEF6EE;'>" + data[i] + "</span>");
				}


				$('#notifications').append("<div class='dropdown-divider' style='background-color: #FEE5CC;'></div>");
			}
		} else {
			$('#notifications').append("<span class='dropdown-item-text'>Nessuna notifica presente! Inizia ad usare subito il sito!</span>");
			$('#notifications').append("<div class='dropdown-divider' style='background-color: #FEE5CC;'></div>");
		}


	});
}



function visualizza(){


	var xmlHttp = new XMLHttpRequest();

	xmlHttp.onreadystatechange = function() { 
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
			$('#num_notifications').hide();
	}
	xmlHttp.open("GET", 'VisualizzaNotificheServlet', true); // true for asynchronous 
	xmlHttp.send(null);

}
