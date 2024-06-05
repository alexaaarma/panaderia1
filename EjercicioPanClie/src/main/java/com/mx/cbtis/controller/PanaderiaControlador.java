package com.mx.cbtis.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import com.mx.cbtis.modelo.Pedidos;


@Controller
public class PanaderiaControlador {
 @GetMapping("/")
 public String getLogin() {
		return "pedidosT";
	}
 
 @GetMapping("/formi")
 public String getPedidos(Model modelo) {
		Pedidos pedidos = new Pedidos();
		modelo.addAttribute("pedidos", pedidos);
	 return "formPedido";
 }
 
 @GetMapping("/pedidos")
	public String getPedido( Model modelo) {
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/buscarPedidos";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Pedidos[] response = template.postForObject(urlservicebd,headers, Pedidos[].class);
		List<Pedidos> pedidos = Arrays.asList(response);
		modelo.addAttribute ("listaPedidos", pedidos);
		return "pedidosT";
	} 
 
 @PostMapping("/savePedidos")
	public ModelAndView setSavePedidos(@ModelAttribute Pedidos pedidos )  {
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/addPedidos";
		ResponseEntity<Integer> response = template.postForEntity(urlservicebd,pedidos,Integer.class);
		return new ModelAndView("redirect:/pedidos");
	}
 
 @PostMapping("/eliminarPedidos")
	public ModelAndView eliminarPedidos(@RequestBody Pedidos  pedidos) {
		System.out.println("El id del pedido es: "+ pedidos.getId());
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/deletePedidos";
		HttpEntity<Pedidos> request = new HttpEntity<Pedidos>(pedidos);
		ResponseEntity<Integer> response = template.exchange(urlservicebd,HttpMethod.DELETE,request,Integer.class);
		return new ModelAndView("redirect:/pedidos");
	}

@GetMapping("/actualizarPedidos")
	public String updatePedidos(@RequestParam(value = "id") int id, Model modelo) {
		RestTemplate template = new RestTemplate();
		Map<String,Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		String urlservicebd = "http://localhost:8081/buscarPedido?id={id}";
		Pedidos pedidos = template.getForObject( urlservicebd, Pedidos.class,params);
		modelo.addAttribute("pedidos", pedidos);
		
		return"formPedido";
	}
 
}


