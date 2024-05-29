$(document).ready(function(){
	
	
	
});

function eliminarPedido(idPedidos){
	
	$.ajax({
		url : "/eliminarPedidos",
		contentType:"application/json",
		data :JSON.stringify({id:idPedidos}),
		type : "POST",
		success:function(){window.location.herf = "pedidos"}
			
	});
	
}
	function actualizarPedidos(idPedidos){
	
	$.ajax({
		url : "/actualizarPedidos",
		contentType:"application/json",
		data :JSON.stringify({id:idPedidos}),
		type : "GET",
		success:function(){}
			
	});
	}