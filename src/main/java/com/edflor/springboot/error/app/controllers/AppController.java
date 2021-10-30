package com.edflor.springboot.error.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edflor.springboot.error.app.errors.UsuarioNoEncontradoExeption;
import com.edflor.springboot.error.app.models.domain.Usuario;
import com.edflor.springboot.error.app.services.UsuarioService;

@Controller
public class AppController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/index")
	public String index(Model model) {
		
		//Integer valor = 100 / 0;
		Integer valor = Integer.parseInt("10x");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
		
		//Usuario usuario = usuarioService.obtenerPorId(id);
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(()-> new UsuarioNoEncontradoExeption(id.toString()));
		/*
		 * if (usuario == null) { throw new UsuarioNoEncontradoExeption(id.toString());
		 * }
		 */
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		
		return "ver";
	}
	
	
}
