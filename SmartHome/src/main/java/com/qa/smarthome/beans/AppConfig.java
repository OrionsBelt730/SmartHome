package com.qa.smarthome.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.smarthome.model.IoT;

@Configuration
@Profile("!test")
public class AppConfig {

	@Bean
	public List<IoT> iot() {
		return new ArrayList<IoT>();
	}

}
