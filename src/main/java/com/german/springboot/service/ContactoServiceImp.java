package com.german.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.german.springboot.component.ContactConverter;
import com.german.springboot.entity.Contacto;
import com.german.springboot.model.ContactoModel;
import com.german.springboot.repository.ContactoRepository;

@Service
public class ContactoServiceImp implements ContactoService {

	@Autowired
	private ContactConverter contactConverter;

	@Autowired
	private ContactoRepository contactoRepository;

	@Override
	public List<ContactoModel> listarContactos() {

		List<Contacto> listContactos = contactoRepository.getByEstatusGreaterThan("0");
		List<ContactoModel> listaContactosModel = new ArrayList<>();
		for (Contacto contacto : listContactos) {
			listaContactosModel.add(contactConverter.convertirDeContactoAModel(contacto));
		}
		return listaContactosModel;
	}

	@Override
	public ContactoModel agregarContacto(ContactoModel contactoModel) {
		return contactConverter.convertirDeContactoAModel(contactoRepository.save(contactConverter.convertirDeModelAContacto(contactoModel)));
	}

	@Override
	public void eliminarContacto(int id) {
		Contacto contacto = contactoRepository.findById(id).get();
		if (contacto != null) {
			contactoRepository.delete(contacto);
		}
	}

	@Override
	public ContactoModel buscarContactoPorId(int id) {
		return contactConverter.convertirDeContactoAModel(contactoRepository.findById(id).get());
	}

}
