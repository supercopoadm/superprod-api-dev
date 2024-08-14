package com.romario.superprod.validation.maquina;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.romario.superprod.domain.Maquina;
import com.romario.superprod.domain.dto.flat.MaquinaFlatInsert;
import com.romario.superprod.repository.MaquinaRepository;
import com.romario.superprod.resource.execption.FieldMessage;
import com.romario.superprod.service.util.Tenantuser;



public class MaquinaInsertValidator implements ConstraintValidator<MaquinaInsert, MaquinaFlatInsert> {
	@Autowired
	private MaquinaRepository repo;
	
	@Autowired
	private Tenantuser tenantUsuario;
	
	@Override
	public void initialize(MaquinaInsert ann) {
	}
	@Override
	public boolean isValid(MaquinaFlatInsert value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();      
		
        Maquina aux1 = repo.findByNumeroAndTenant(value.getNumero(),tenantUsuario.buscarOuFalhar() );

        if(aux1 !=null) {
			list.add(new FieldMessage("numero"," Numero da maquina  já existente"));
			}	

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
