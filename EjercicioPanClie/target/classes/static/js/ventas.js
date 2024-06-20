$(document).ready(function(){	

});
function eliminarVenta(idVenta){

	$.ajax({
		url : "/eliminarVenta",
		contentType: "application/json",
		data: JSON.stringify({id:idVenta}),
		type: "POST",
		success: function(){window.location.href = 'admin1';

		}

	});

}


