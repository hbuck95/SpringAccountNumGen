package com.bae.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class NumGenServiceImpl implements NumGenService {

	@Override
	public String generateAccountNumber() {
		return generateRandomLetter() + RandomStringUtils.randomNumeric(10);
	}

	public char generateRandomLetter() {
		int min = 'A';
		int max = 'C';
		int range = max - min + 1;

		return (char) ((Math.random() * range) + min);
	}

}
