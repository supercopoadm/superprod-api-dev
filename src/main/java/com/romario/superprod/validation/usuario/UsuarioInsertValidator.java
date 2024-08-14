package com.romario.superprod.validation.usuario;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.superprod.domain.Usuario;
import com.romario.superprod.domain.dto.UsuarioNewDTO;
import com.romario.superprod.repository.UsuarioRepository;
import com.romario.superprod.resource.execption.FieldMessage;



public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {
	@Autowired
	private UsuarioRepository repo;

	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux1 = repo.findPorEmail(objDto.getEmail());
		if(aux1 !=null) {
			list.add(new FieldMessage("email"," Email já existente"));
			}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
