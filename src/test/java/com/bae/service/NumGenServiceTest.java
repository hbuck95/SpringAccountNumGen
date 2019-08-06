package com.bae.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class NumGenServiceTest {

	@Mock
	private NumGenServiceImpl service;

	private static final int LENGTH = 10;

	private static List<Character> VALID_CHARS;

	@BeforeClass
	public static void setup() {
		VALID_CHARS = new ArrayList<>();
		VALID_CHARS.add('A');
		VALID_CHARS.add('B');
		VALID_CHARS.add('C');
	}

	@Test
	public void generateAccountNumberTest() {
		Mockito.when(service.generateAccountNumber()).thenReturn(RandomStringUtils.randomNumeric(10));
		String num = service.generateAccountNumber();
		Mockito.verify(service).generateAccountNumber();
		assertEquals(LENGTH, num.length());
	}

	@Test
	public void generateRandomLetterTest() {
		Mockito.when(service.generateRandomLetter()).thenReturn((char) ((Math.random() * 3) + 65));
		char c = service.generateRandomLetter();
		assertEquals(VALID_CHARS.contains(c), true);
	}

}
