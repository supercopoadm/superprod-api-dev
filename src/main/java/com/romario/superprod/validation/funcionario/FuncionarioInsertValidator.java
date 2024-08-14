package com.romario.superprod.validation.funcionario;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.dto.flat.FuncionarioFlat;
import com.romario.superprod.repository.FuncioarioRepository;
import com.romario.superprod.resource.execption.FieldMessage;



public class FuncionarioInsertValidator implements ConstraintValidator<FuncionarioInsert, FuncionarioFlat> {
	
	@Autowired
	private FuncioarioRepository repo;

	@Override
	public void initialize(FuncionarioInsert ann) {
	}

	@Override
	public boolean isValid(FuncionarioFlat objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Funcionario aux1 = repo.findByNome(objDto.getNome());
		if(aux1 !=null) {
			list.add(new FieldMessage("Funcionario"," Funcionario já existente"));
			}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
