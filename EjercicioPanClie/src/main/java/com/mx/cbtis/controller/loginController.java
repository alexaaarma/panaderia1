package com.mx.cbtis.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mx.cbtis.modelo.Usuario;


@Controller
public class loginController {
	
	@GetMapping("/login")
	public String getLogin()
	{
		return"login";
	}
	

	@GetMapping("/menu")
	public String getMenu()
	{
		return"menu";
	}
	@GetMapping("/registro")
	public String getRegistro()
	{
		return"registro";
	}
	
	
	  @PostMapping("/verificarLogin")
	  public ResponseEntity<Usuario> verificarUsuario(@RequestBody Usuario paramUser){
	  String urlservicebd = "http://localhost:8081/getUsuarioLogin";
	  RestTemplate template= new RestTemplate();
	  ResponseEntity<Usuario> response= template.postForEntity(urlservicebd, paramUser, Usuario.class);
	  	return response;
  }

	  @PostMapping("/saveUsuario")
	  public ModelAndView setSaveUsuario(@ModelAttribute Usuario usuario) {
		  RestTemplate template=new RestTemplate();
		  String urlservicebd= "http://localhost:8081/addUsuario";
		  ResponseEntity<Integer> response = template.postForEntity(urlservicebd, usuario,Integer.class );
		
		  return new ModelAndView ("redirect:/menu");
	  }
	  
}
