package com.romario.superprod.validation.molde;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.romario.superprod.domain.Molde;
import com.romario.superprod.domain.dto.MoldeDTO;
import com.romario.superprod.repository.MoldeRepository;
import com.romario.superprod.resource.execption.FieldMessage;





public class MoldeUpdateValidator implements ConstraintValidator<MoldeUpdate, MoldeDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MoldeRepository repo;

	@Override
	public void initialize(MoldeUpdate ann) {
	}

	@Override
	public boolean isValid(MoldeDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));	
		
		Molde aux = repo.findByNome(objDto.getNome());
		if(aux !=null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("Nome"," Nome já existente"));
		}
			

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
		
	}
}
