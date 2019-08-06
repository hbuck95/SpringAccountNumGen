package com.bae.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.bae.util.Constants;

@Service
public class NumGenServiceImpl implements NumGenService {

	@Override
	public String generateAccountNumber() {
		// Generate random number between 0 and 2.
		int length = (int) ((Math.random() * 3));

		// If the length above is not 0 * it by 2 and add it to 6 (default length)
		// e.g. 0 = 0, 1 = 2, 2 = 4
		return generateRandomLetter() + RandomStringUtils.randomNumeric(6 + (length == 0 ? length : length * 2));
	}

	@Override
	public char generateRandomLetter() {
		int range = Constants.MAX_CHAR - Constants.MIN_CHAR + 1;
		return (char) ((Math.random() * range) + Constants.MIN_CHAR);
	}

}
