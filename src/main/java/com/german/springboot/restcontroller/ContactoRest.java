package com.german.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.german.springboot.model.ContactoModel;
import com.german.springboot.service.ContactoService;

@RestController
@RequestMapping(value = "/rest")
public class ContactoRest {

	@Autowired
	private ContactoService contactoService;

	@GetMapping(value = "/contactos")
	public ResponseEntity<List<ContactoModel>> obtieneContactos() {
		return new ResponseEntity<List<ContactoModel>>(contactoService.listarContactosPorEstatus(), HttpStatus.OK);
	}

	@GetMapping(value = "/contacto/{id}")
	public ResponseEntity<ContactoModel> obtieneContactos(@PathVariable int id) {
		return new ResponseEntity<ContactoModel>(contactoService.buscarContactoPorId(id), HttpStatus.OK);
	}

}
