package com.aryan.model.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator{

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		return a-b;

	}

	@Override
	public int divide(int a, int b) {
		return a/b;

	}

	@Override
	public int multiply(int a, int b) {
		return a*b;

	}


}
