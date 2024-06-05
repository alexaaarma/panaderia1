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

import com.mx.cbtis.modelo.Asistencia;



@Controller
public class PanaderiaControlador {

	@GetMapping("/")
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

}