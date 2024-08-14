package com.romario.superprod.validation.operador;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.romario.superprod.domain.Operador;
import com.romario.superprod.domain.dto.OperadorDTO;
import com.romario.superprod.repository.OperadorRepository;
import com.romario.superprod.resource.execption.FieldMessage;





public class OperadorUpdateValidator implements ConstraintValidator<OperadorUpdate, OperadorDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private OperadorRepository repo;

	@Override
	public void initialize(OperadorUpdate ann) {
	}

	@Override
	public boolean isValid(OperadorDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));	
		
		Operador aux = repo.findByNumero(objDto.getNumero());
		if(aux !=null && !aux.getId().equals(uriId)) {
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
