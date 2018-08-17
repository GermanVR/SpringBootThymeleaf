package com.german.springboot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.german.springboot.constant.ConstantesVistas;
import com.german.springboot.model.ContactoModel;
import com.german.springboot.service.ContactoService;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

	private static Log log = LogFactory.getLog(ContactoController.class);
	@Autowired
	private ContactoService contactoService;

	@GetMapping("/listaContactos")
	public String listaContactos(Model model) {
		model.addAttribute("contactos", contactoService.listarContactosPorEstatus());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername().toUpperCase());
		return ConstantesVistas.CONTACTOS;
	}

	@GetMapping("/agregarcontacto")
	public String formularioContacto(Model model) {
		model.addAttribute("contactoModel", new ContactoModel());
		return ConstantesVistas.FORMULARIO_CONTACTO;
	}

	@GetMapping("/cancela")
	public String cancela(RedirectAttributes model) {
		model.addFlashAttribute("respuesta", "Peticion Cancelada");
		model.addFlashAttribute("cod", "0");
		return "redirect:/contactos/listaContactos";
	}

	@PostMapping("/contacto")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public String agregaContacto(@ModelAttribute(name = "contactoModel") ContactoModel contactoModel, RedirectAttributes model) {
		int ins = contactoModel.getId();
		ContactoModel contactoModelGuardado = null;
		try {
			contactoModelGuardado = contactoService.agregarContacto(contactoModel);
		} catch (Exception e) {
		}
		if (contactoModelGuardado != null) {
			if (ins > 0) {
				model.addFlashAttribute("respuesta", "Contacto Modificado Correctamente!");
			} else {
				model.addFlashAttribute("respuesta", "Contacto Agregado Correctamente!");
			}
			model.addFlashAttribute("cod", "1");
		} else {
			model.addFlashAttribute("respuesta", "Error al Agregar Contacto!");
			model.addFlashAttribute("cod", -1);
		}
		return "redirect:/contactos/listaContactos";
	}

	@PostMapping("/contacto/{id}")
	public String eliminaContactoPorId(@PathVariable(name = "id") int id, RedirectAttributes model) {

		ContactoModel con = contactoService.buscarContactoPorId(id);
		if (con != null) {
			contactoService.eliminarContacto(id);
			model.addFlashAttribute("respuesta", "Contacto Eliminado Correctamente!!");
			model.addFlashAttribute("cod", 1);
		} else {
			model.addFlashAttribute("respuesta", "No existe el Contacto a eliminar!!");
			model.addFlashAttribute("cod", -1);
		}
		return "redirect:/contactos/listaContactos";
	}

	@GetMapping("/contacto/{id}")
	public String obtieneContactoPorId(@PathVariable(name = "id") int id, Model model) {
		ContactoModel con = contactoService.buscarContactoPorId(id);
		model.addAttribute("contactoModel", con);
		return "contactform";
	}

	@PostMapping("/contacto/{id}/{option}")
	public String aprobarContacto(@PathVariable(name = "id") int id, @PathVariable int option, RedirectAttributes model) {
		boolean bol = contactoService.aprobarContacto(id, option);
		if (bol) {
			model.addFlashAttribute("respuesta", option == 0 ? "Contacto Aprobado Correctamente" : "Contacto Rechazado Correctamente");
			model.addFlashAttribute("cod", "1");
		} else {
			model.addFlashAttribute("respuesta", "Error al Aprobar Contacto!!");
			model.addFlashAttribute("cod", "-1");
		}
		return "redirect:/contactos/admin";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminContactos(Model model) {
		log.info("en admin Contactos");
		model.addAttribute("contactos", contactoService.listarContactos());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("admin", user.getUsername().toUpperCase());
		return "admin/contactos";
	}
}
