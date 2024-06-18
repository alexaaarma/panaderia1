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
import com.mx.cbtis.modelo.Produccion;


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
 

	@GetMapping("/form")
	public String getProduccion(Model modelo) {
		Produccion produccion = new Produccion();
		modelo.addAttribute("produccion", produccion);
		return "form_produccion";
	}

	@GetMapping("/produccion")
	public String getProduccion1(Model modelo) {
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/buscarProduccions";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Produccion[] response = template.postForObject(urlservicebd, headers, Produccion[].class);
		List<Produccion> produccion = Arrays.asList(response);
		modelo.addAttribute("listaProduccion", produccion);
		return "panaderia_produccion";
	}

	@PostMapping("/saveProduccion")
	public ModelAndView setSaveProduccion(@ModelAttribute Produccion produccion) {
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/addProduccion";
		ResponseEntity<Integer> response = template.postForEntity(urlservicebd, produccion, Integer.class);
		return new ModelAndView("redirect:/produccion");
	}

	@PostMapping("/eliminarProduccion")
	public ModelAndView eliminarProduccion(@RequestBody Produccion produccion) {
		System.out.println("El id de la produccion es:" + produccion.getId());
		RestTemplate template = new RestTemplate();
		String urlservicebd = "http://localhost:8081/deleteProduccion";
		HttpEntity<Produccion> request = new HttpEntity<Produccion>(produccion);
		ResponseEntity<Integer> response = template.exchange(urlservicebd, HttpMethod.DELETE, request, Integer.class);
		return new ModelAndView("redirect:/produccion");
	}

	@GetMapping("/actualizarProduccion")
	public String updateProduccion(@RequestParam(value = "id") int id, Model modelo) {
		RestTemplate template = new RestTemplate();
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);
		String urlservicebd = "http://localhost:8081/buscarProduccion?id={id}";
		Produccion produccion = template.getForObject(urlservicebd, Produccion.class, params);
		modelo.addAttribute("produccion", produccion);
		return "form_produccion";

	}
}

 



