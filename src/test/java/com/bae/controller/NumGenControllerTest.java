package com.bae.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.NumGenServiceImpl;

@RunWith(SpringRunner.class)
public class NumGenControllerTest {

	@InjectMocks
	private NumGenServiceImpl service;

	@Mock
	private NumGenController controller;

	private static List<Character> VALID_CHARS;
	private static List<Integer> VALID_LENGTHS;

	@BeforeClass
	public static void setup() {
		VALID_CHARS = new ArrayList<>();
		VALID_CHARS.add('A');
		VALID_CHARS.add('B');
		VALID_CHARS.add('C');

		VALID_LENGTHS = new ArrayList<>();
		VALID_LENGTHS.add(6);
		VALID_LENGTHS.add(8);
		VALID_LENGTHS.add(10);
	}

	@Test
	public void generateAccountNumberTest() {
		Mockito.when(controller.generateAccountNumber()).thenReturn(RandomStringUtils.randomNumeric(10));
		String num = controller.generateAccountNumber();
		Mockito.verify(controller).generateAccountNumber();
		assertEquals(VALID_LENGTHS.contains(num.length()), true);
	}

}
