package com.qa.smarthome;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.smarthome.model.IoT;
import com.qa.smarthome.repo.IoTRepo;
import com.qa.smarthome.services.IoTService;

@SpringBootTest
public class IoTServiceTest {

	@Autowired
	private IoTService service;

	@MockBean
	private IoTRepo repo;

	@Test
	void testCreate() {
		final Long id = 1L;
		Mockito.when(this.repo.save(new IoT(id, true, true, "smart plug outlet", "2019", true, true, "Samsung",
				"GP-WOU019BBDWG", "Smart Home Plug", "zigbee")))
				.thenReturn(new IoT(id, true, true, "smart plug outlet", "2019", true, true, "Samsung",
						"GP-WOU019BBDWG", "Smart Home Plug", "zigbee"));

		assertThat(this.service.create(new IoT(null, true, true, "smart plug outlet", "2019", true, true, "Samsung",
				"GP-WOU019BBDWG", "Smart Home Plug", "zigbee")))
				.isEqualTo(new IoT(id, true, true, "smart plug outlet", "2019", true, true, "Samsung", "GP-WOU019BBDWG",
						"Smart Home Plug", "zigbee"));

		Mockito.verify(this.repo, Mockito.times(1)).save(new IoT(null, true, true, "smart plug outlet", "2019", true,
				true, "Samsung", "GP-WOU019BBDWG", "Smart Home Plug", "zigbee"));

	}

	@Test

	void testGetAll() {
		final Long id = 1L;
		List<IoT> IoTList = new ArrayList<IoT>();

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(
				new IoT(id, true, true, "smart speaker", "4th", false, null, "Amazon", "B7W64E", "Echo Dot", "wifi")));
	}

	@Test
	void testUpdate() {
		final long id = 1L;
		IoT testIoT = new IoT(id, true, true, "smart plug outlet", "2019", true, true, "Samsung", "GP-WOU019BBDWG",
				"Smart Home Plug", "zigbee");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(
				new IoT(id, true, true, "smart speaker", "4th", false, null, "Amazon", "B7W64E", "Echo Dot", "wifi")));

		Mockito.when(this.repo.save(testIoT)).thenReturn(testIoT);

		assertThat(testIoT == this.service.update(id, testIoT));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(testIoT);

	}

	@Test
	void testDelete() {
		final long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(true);
		assertThat(this.service.delete(id));
		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
