package com.qa.smarthome.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.smarthome.model.IoT;

@Repository
public interface IoTRepo extends JpaRepository<IoT, Long> {

}
