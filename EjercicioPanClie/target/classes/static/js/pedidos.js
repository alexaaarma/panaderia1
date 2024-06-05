$(document).ready(function(){
	
	
	
});

function eliminarPedidos(idPedidos){
	
	$.ajax({
		url : "/eliminarPedidos",
		contentType:"application/json",
		data :JSON.stringify({id:idPedidos}),
		type : "POST",
		success:function(){window.location.href = "pedidos"}
			
	});
	
}