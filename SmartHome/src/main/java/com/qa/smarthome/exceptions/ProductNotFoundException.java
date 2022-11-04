package com.qa.smarthome.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Product Not Found")
public class ProductNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 4756765556920070624L;

}
