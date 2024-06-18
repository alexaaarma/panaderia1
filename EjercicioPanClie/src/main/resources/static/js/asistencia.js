$(document).ready(function(){

});

function eliminarAsistencia(idAsistencia){

	$.ajax({
		url : "/eliminarAsistencia",
		contentType: "application/json",
		data: JSON.stringify({id:idAsistencia}),
		type: "POST",
		success: function(){window.location.href = 'admin';
		}
		
	});
}
function actualizarAistencia(idAsistencia){

	$.ajax({
		url : "/actualizarAistencia",
		contentType: "application/json",
		data: JSON.stringify({id:idAsistencia}),
		type: "GET",
		success: function(){window.location.reload()},
		});
		
		
}




