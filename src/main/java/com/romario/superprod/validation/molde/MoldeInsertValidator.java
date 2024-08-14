package com.romario.superprod.validation.molde;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.dto.flat.MoldeFlat;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.resource.execption.FieldMessage;



public class MoldeInsertValidator implements ConstraintValidator<MoldeInsert, MoldeFlat> {
	
	@Autowired
	private MoldeRepository repo;

	@Override
	public void initialize(MoldeInsert ann) {
	}

	@Override
	public boolean isValid(MoldeFlat objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Molde aux1 = repo.findByNome(objDto.getNome());
		if(aux1 !=null) {
			list.add(new FieldMessage("Molde"," Molde já existente"));
			}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
