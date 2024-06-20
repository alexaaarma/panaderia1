package com.mx.cbtis.controller;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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

import com.mx.cbtis.modelo.Asistencia;
import com.mx.cbtis.modelo.Venta;
import com.mx.cbtis.modelo.Pedidos;
import com.mx.cbtis.modelo.Produccion;
import com.mx.cbtis.modelo.Producto;

@Controller
public class PanaderiaControlador {

	@GetMapping("/")
    public String getinicio() {
   		return "inicio";
   	}
	
 @GetMapping("/formi")
 public String getPedidos(Model modelo) {
		Pedidos pedidos = new Pedidos();
		modelo.addAttribute("pedidos", pedidos);
	 return "formPedido";
 }
 
 @PostMapping("/enviarP")
	public ResponseEntity<Pedidos> Pedidoss(@RequestBody Pedidos pedidos){
	    return new ResponseEntity<Pedidos>(pedidos,null,HttpStatus.CREATED);
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

	@GetMapping("/as")
    public String getLogin() {
        return "Asistencia";
    }

    @GetMapping("/asistencias")
    public String gettabla_asistencia() {
        return "tabla_asistencia";
    }

    @GetMapping("/admin")
    public String getAsistencias(Model modelo) {
        RestTemplate template = new RestTemplate();
        String urlservicebd = "http://localhost:8081/buscarAsistencia";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Asistencia[] response = template.postForObject(urlservicebd, headers, Asistencia[].class);
        List<Asistencia> asistencias = Arrays.asList(response);
        modelo.addAttribute("listaAsistencias", asistencias);
        return "tabla_asistencia";
    }

    @PostMapping("/saveAsistencia")
    public ModelAndView setSaveAsistencia(@ModelAttribute Asistencia asistencia) {
        RestTemplate template = new RestTemplate();
        String urlservicebd = "http://localhost:8081/addAsistencia";
        ResponseEntity<Integer> response = template.postForEntity(urlservicebd, asistencia, Integer.class);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/updateAsistencia")
    public ModelAndView updateAsistencia(@ModelAttribute Asistencia asistencia) {
        RestTemplate template = new RestTemplate();
        String urlservicebd = "http://localhost:8081/updateAsistencia";
        ResponseEntity<Integer> response = template.postForEntity(urlservicebd, asistencia, Integer.class);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/agregar_asistencia")
    public String getAgregarAsistencia(Model modelo) {
        Asistencia asistencia = new Asistencia();
        modelo.addAttribute("asistencia", asistencia);
        RestTemplate template = new RestTemplate();
        String urlservicebd = "http://localhost:8081/buscarAsistencia";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Asistencia[] response = template.postForObject(urlservicebd, headers, Asistencia[].class);
        List<Asistencia> asistencias = Arrays.asList(response);
        modelo.addAttribute("listaAsistencias", asistencias);
        return "Asistencias";
    }

    @PostMapping("/eliminarAsistencia")
    public ModelAndView eliminarUsuario(@RequestBody Asistencia asistencia) {
        System.out.println("El id del usuario es: " + asistencia.getId());
        RestTemplate template = new RestTemplate();
        String urlservicebd = "http://localhost:8081/deleteAsistencia";
        HttpEntity<Asistencia> request = new HttpEntity<>(asistencia);
        ResponseEntity<Integer> response = template.exchange(urlservicebd, HttpMethod.DELETE, request, Integer.class);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping("/actualizarAsistencias")
    public String updateAsistencia(@RequestParam(value = "id") int id, Model modelo) {
        RestTemplate template = new RestTemplate();
        Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        String urlservicebd = "http://localhost:8081/buscarAsistencia?id={id}";
        Asistencia asistencia = template.getForObject(urlservicebd, Asistencia.class, params);
        modelo.addAttribute("asistencia", asistencia);
        return "form_actualizar";
    }
    @GetMapping("/agregarP")
   	public String getAgregarProducto() {
   		return "agregarP";
   	}
   	@GetMapping("/producto")
   	public String getProducto(Model modelo) {
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/buscarProductos";
   		HttpHeaders headers = new HttpHeaders();
   		headers.setContentType(MediaType.APPLICATION_JSON);
   		Producto[] response = template.postForObject(urlservicebd,headers,Producto[].class);
   		List<Producto> producto = Arrays.asList(response);
   		modelo.addAttribute("listaProducto", producto);
   		return "producto";
   	}

   	@PostMapping("/saveProducto")
   	public ModelAndView setSaveProducto(@ModelAttribute Producto producto) {
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/addProducto";
   		ResponseEntity <Integer> response = template.postForEntity(urlservicebd, producto, Integer.class);
   		return new ModelAndView("redirect:/producto");
   	}
   	
   	@PostMapping("/eliminarProducto")
   	public ModelAndView eliminarProducto(@RequestBody Producto producto) {
   		System.out.println("El ID del Producto es: " + producto.getId());
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/deleteProducto";
   		HttpEntity<Producto> request = new HttpEntity<Producto>(producto);
   		ResponseEntity <Integer> response = template.exchange(urlservicebd, HttpMethod.DELETE,request, Integer.class);
   		return new ModelAndView("redirect:/producto");
   	}

   	@GetMapping("/actualizarProducto")
   	public String updateProducto(@RequestParam(value = "id") int id, Model model) {
   		RestTemplate template = new RestTemplate();
   		Map<String, Integer> params = new HashMap<String, Integer>();
   		params.put("id", id);
   		String urlservicebd = "http://localhost:8081/buscarProducto?id={id}";
   		Producto producto = template.getForObject(urlservicebd, Producto.class, params);
   		model.addAttribute("producto", producto);
   		return "actualizarP";

   	}
   	@GetMapping("/ventas")
    public String getventas_form() {
   		return "ventas_form";
   	}
 
    
    @GetMapping("/admin1")
   	public String getVenta(Model modelo) {
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/buscarVentas";
   		HttpHeaders headers = new HttpHeaders();
   		headers.setContentType(MediaType.APPLICATION_JSON);
   		Venta[] response = template.postForObject(urlservicebd,headers,Venta[].class);
   		List<Venta> ventas = Arrays.asList(response);
   		modelo.addAttribute("listaVentas", ventas);
   		
   		return "ventas_tabla";
   	}
    @PostMapping("/saveVenta")
   	public ModelAndView setSaveVenta(@ModelAttribute Venta venta ) {
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/addVenta";
   		ResponseEntity<Integer> response = template.postForEntity(urlservicebd,venta,Integer.class);
   		return new ModelAndView("redirect:/admin1");
   	}
    
    @GetMapping("/agregar_venta")
   	public String getagregar_venta(Model modelo) {
   		Venta venta = new Venta();
   		modelo.addAttribute("venta" , venta);
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/buscarVentas";
   		HttpHeaders headers = new HttpHeaders();
   		headers.setContentType(MediaType.APPLICATION_JSON);
   		Venta[] response  = template.postForObject(urlservicebd,headers,Venta[].class);
   		List<Venta> ventas = Arrays.asList(response);
   		modelo.addAttribute("listaVentas" , ventas);
   		return "ventas_tabla";
   				
   }
    @PostMapping("/eliminarVenta")
   	public ModelAndView eliminarVenta(@RequestBody Venta venta) {
   		System.out.println("El id de la venta es: " + venta.getId());
   		RestTemplate template = new RestTemplate();
   		String urlservicebd = "http://localhost:8081/deleteVenta";
   		HttpEntity<Venta> request = new HttpEntity<Venta>(venta);
   		ResponseEntity<Integer> response = template.exchange(urlservicebd, HttpMethod.DELETE, request, Integer.class);
   		return new ModelAndView("redirect:/admin1");
   	}
    
    @GetMapping("/actualizarVenta")
   	public String updateVenta(@RequestParam(value = "id") int id, Model modelo) {
   		RestTemplate template = new RestTemplate();
   		Map<String, Integer> params = new HashMap<String, Integer>();
   		params.put("id", id);
   		String urlservicebd = "http://localhost:8081/buscarVenta?id={id}";
   		Venta venta = template.getForObject(urlservicebd, Venta.class, params);
   		modelo.addAttribute("venta", venta);	
   		return "form_actualizar1";
   	}

}