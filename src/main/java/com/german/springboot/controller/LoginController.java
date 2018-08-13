package com.german.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.german.springboot.constant.ConstantesVistas;
import com.german.springboot.model.UserCredenciales;

@Controller
public class LoginController {

	@GetMapping(value = "/")
	public String toLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return ConstantesVistas.LOGIN;
	}

	@PostMapping(value = "/logeo")
	public String loginCheck(@ModelAttribute(name = "userCredenciales") UserCredenciales userCredenciales) {
		if (userCredenciales.getUsername().equals("admin") && userCredenciales.getPassword().equals("admin")) {
			return "redirect:/contactos/listaContactos";
		}
		return "redirect:/login";
	}

	// @GetMapping(value = "/si")
	// public ResponseEntity<Curso> creaCurso() {
	// Curso c = new Curso();
	// c.setDescripcion("Spring Framework 4");
	// c.setHoras(12);
	// c.setNombre("Spring Core");
	// c.setPrecio(355);
	// return new ResponseEntity<Curso>(cursoRepository.save(c),
	// HttpStatus.CREATED);
	// }
	//
	// @GetMapping(value = "/curso/{id}")
	// public ResponseEntity<String> elimina(@PathVariable(name = "id") int id) {
	// Optional<Curso> curso = cursoRepository.findById(id);
	// if (curso.isPresent()) {
	// cursoRepository.delete(curso.get());
	// return new ResponseEntity<String>("Eliminado Correctamete", HttpStatus.OK);
	// } else {
	// return new ResponseEntity<String>("El cusro no Existe",
	// HttpStatus.BAD_REQUEST);
	// }
	// }

}
