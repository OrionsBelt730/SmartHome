package com.qa.smarthome.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.smarthome.model.IoT;
import com.qa.smarthome.services.IoTService;

@RestController
@RequestMapping("/SmartHome")

public class IoTController {

	@Autowired
	IoTService service;

//	@RequestMapping("/test")
//	public String HelloWorld() {
//		return "Hello World";
//	}

	// CRUD
	@PostMapping("/create")
	public IoT create(@RequestBody IoT iot) {
		return service.create(iot);
	}

	@GetMapping("/getAll")
	public List<IoT> getAll() {
		return service.getAll();
	}

	@PutMapping("/update{id}")
	public IoT update(@PathParam("id") Long id, @RequestBody IoT iot) {
		return service.update(id, iot);
	}

	@DeleteMapping("/delete/{id}")
	public Boolean deleteOne(@PathVariable("id") Long id) {
		return service.delete(id);
	}

}
