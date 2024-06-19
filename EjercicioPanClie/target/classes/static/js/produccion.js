$(document).ready(function(){
});

function eliminarProduccion(idProduccion){
	$.ajax({
		url : "/eliminarProduccion",
		contentType:"application/json",
		data :JSON.stringify({id:idProduccion}),
		type : "POST",
		success:function(){window.location.href="produccion"}
	});
}
   