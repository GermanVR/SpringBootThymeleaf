package com.german.springboot.service;

import java.util.List;

import com.german.springboot.model.ContactoModel;

public interface ContactoService {

	public List<ContactoModel> listarContactos();

	public List<ContactoModel> listarContactosPorEstatus();

	public ContactoModel agregarContacto(ContactoModel contacto);

	public void eliminarContacto(int id);

	public ContactoModel buscarContactoPorId(int id);

	public boolean aprobarContacto(int id, int option);
}
