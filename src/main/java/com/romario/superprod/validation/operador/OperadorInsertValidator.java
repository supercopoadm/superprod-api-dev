package com.romario.superprod.validation.operador;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.dto.flat.OperadorFlat;
import com.romario.superprod.repository.OperadorRepository;
import com.romario.superprod.resource.execption.FieldMessage;



public class OperadorInsertValidator implements ConstraintValidator<OperadorInsert, OperadorFlat> {
	
	@Autowired
	private OperadorRepository repo;

	@Override
	public void initialize(OperadorInsert ann) {
	}

	@Override
	public boolean isValid(OperadorFlat objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Operador aux1 = repo.findByNumero(objDto.getNumero());
		if(aux1 !=null) {
			list.add(new FieldMessage("operador"," Operador já existente"));
			}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
