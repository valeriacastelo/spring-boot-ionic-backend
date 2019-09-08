package com.nelioalves.backend.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.nelioalves.backend.domain.Client;
import com.nelioalves.backend.dto.ClientDTO;
import com.nelioalves.backend.repositories.ClientRepository;
import com.nelioalves.backend.resources.exception.FieldMessage;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClientDTO> {
	
	@Autowired
	private ClientRepository repo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(ClientUpdate ann) {
	}

	@Override
	public boolean isValid(ClientDTO dto, ConstraintValidatorContext context) {
		
		Map<String, String> attributes = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer clientId = Integer.parseInt(attributes.get("id"));
		
		
		List<FieldMessage> list = new ArrayList<>();
		
		Client findByEmail = repo.findByEmail(dto.getEmail());
		if (findByEmail != null && !findByEmail.getId().equals(clientId)) {
			list.add(new FieldMessage("email", "Existent email"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
