package com.qa.smarthome.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.smarthome.exceptions.ProductNotFoundException;
import com.qa.smarthome.model.IoT;
import com.qa.smarthome.repo.IoTRepo;

@Service
public class IoTService {

	@Autowired
	IoTRepo repo;

	// create
	public IoT create(IoT iot) {
		return repo.save(iot);
	}

	// read All
	public List<IoT> getAll() {
		return repo.findAll();
	}

	// read One
	public IoT getOne(Long index) throws ProductNotFoundException {
		return repo.findById(index).orElseThrow(ProductNotFoundException::new);
	}

	// update
	public IoT update(Long id, IoT iot) {
		IoT found = repo.findById(id).orElseThrow(ProductNotFoundException::new);

		found.setAppRequired(iot.getAppRequired());
		found.setCompatibleWithThirdParty(iot.getCompatibleWithThirdParty());
		found.setDescription(iot.getDescription());
		found.setGeneration(iot.getGeneration());
		found.setHubRequired(iot.getHubRequired());
		found.setManufacturer(iot.getManufacturer());
		found.setModelNumber(iot.getModelNumber());
		found.setProductName(iot.getProductName());
		found.setProtocol(iot.getProtocol());

		return repo.save(found);
	}

	// delete
	public Boolean delete(Long index) {
		repo.deleteById(index);
		return (!repo.existsById(index));
	}

}
