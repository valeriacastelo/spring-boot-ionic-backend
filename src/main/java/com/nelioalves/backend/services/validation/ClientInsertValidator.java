package com.nelioalves.backend.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nelioalves.backend.domain.enums.ClientType;
import com.nelioalves.backend.dto.ClientNewDTO;
import com.nelioalves.backend.resources.exception.FieldMessage;
import com.nelioalves.backend.services.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
	
	@Override
	public void initialize(ClientInsert ann) {
	}

	@Override
	public boolean isValid(ClientNewDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if (dto.getType().equals(ClientType.PERSON.getId()) && 
				!BR.isValidCPF(dto.getTaxpayerNumber())) {
			list.add(new FieldMessage("taxpayerNumber", "CPF invalid"));
		}
		
		if (dto.getType().equals(ClientType.COMPANY.getId()) && 
				!BR.isValidCNPJ(dto.getTaxpayerNumber())) {
			list.add(new FieldMessage("taxpayerNumber", "CNPJ invalid"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
