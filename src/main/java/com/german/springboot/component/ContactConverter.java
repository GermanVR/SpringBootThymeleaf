package com.german.springboot.component;

import org.springframework.stereotype.Component;

import com.german.springboot.entity.Contacto;
import com.german.springboot.model.ContactoModel;

@Component
public class ContactConverter {

	public Contacto convertirDeModelAContacto(ContactoModel contactModel) {
		Contacto contacto = new Contacto();
		contacto.setId(contactModel.getId());
		contacto.setApellidoMaterno(contactModel.getApellidoMaterno());
		contacto.setApellidoPaterno(contactModel.getApellidoPaterno());
		contacto.setCiudad(contactModel.getCiudad());
		contacto.setEstatus(contactModel.getEstatus());
		contacto.setNombre(contactModel.getNombre());
		contacto.setTelefono(contactModel.getTelefono());
		return contacto;
	}

	public ContactoModel convertirDeContactoAModel(Contacto contact) {
		ContactoModel contactoModel = new ContactoModel();
		contactoModel.setId(contact.getId());
		contactoModel.setApellidoMaterno(contact.getApellidoMaterno());
		contactoModel.setApellidoPaterno(contact.getApellidoPaterno());
		contactoModel.setCiudad(contact.getCiudad());
		contactoModel.setEstatus(contact.getEstatus());
		contactoModel.setNombre(contact.getNombre());
		contactoModel.setTelefono(contact.getTelefono());
		return contactoModel;
	}
}
