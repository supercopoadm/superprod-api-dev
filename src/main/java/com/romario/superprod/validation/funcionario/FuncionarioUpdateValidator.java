package com.romario.superprod.validation.funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.romario.superprod.domain.Funcionario;
import com.romario.superprod.domain.dto.FuncionarioDTO;
import com.romario.superprod.repository.FuncioarioRepository;
import com.romario.superprod.resource.execption.FieldMessage;





public class FuncionarioUpdateValidator implements ConstraintValidator<FuncionarioUpdate, FuncionarioDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private FuncioarioRepository repo;

	@Override
	public void initialize(FuncionarioUpdate ann) {
	}

	@Override
	public boolean isValid(FuncionarioDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Map<String,String>map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));	
		
		Funcionario aux = repo.findByNome(objDto.getNome());
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
