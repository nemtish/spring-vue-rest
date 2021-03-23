package com.cyrillic.farm;

import static org.assertj.core.api.Assertions.assertThat;

import com.cyrillic.farm.controller.FarmController;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private FarmController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}