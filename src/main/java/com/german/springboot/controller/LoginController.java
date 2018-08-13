package com.german.springboot.controller;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.german.springboot.constant.ConstantesVistas;

@Controller
public class LoginController {

	private Logger log = Logger.getLogger(LoginController.class);

	@GetMapping("/login")
	public String login(Model model, 
			@RequestParam(name = "error", required = false) String error, 
			@RequestParam(name = "logout", required = false) String logout) {
		log.info("En /login");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ConstantesVistas.LOGIN;
	}

	@GetMapping(value = { "/loginsuccess", "/" })
	public String loginCheck() {
		log.info("En /loginsuccess");
		return "redirect:/contactos/listaContactos";
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
