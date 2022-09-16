package com.aryan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aryan.model.service.Calculator;

@Controller
public class CalculatorController {
	
	@RequestMapping("/")
	public ModelAndView welcomePage(){
		return new ModelAndView("Input");
		
	}
	@Autowired
	private Calculator calculator;
	
	@RequestMapping("/calculate")
	public ModelAndView sumController(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		
		String no1=request.getParameter("num1");
		String no2=request.getParameter("num2");
		String op=request.getParameter("operator");
		
		int result=0;
		String resultMessage="";
		switch(op){
		case "sum":
			result=calculator.sum(Integer.parseInt(no1),Integer.parseInt(no2));
			resultMessage="Addition";
			break;
		case "minus":
			result=calculator.minus(Integer.parseInt(no1),Integer.parseInt(no2));
			resultMessage="Difference";
			break;
		case "multiply":
			result=calculator.multiply(Integer.parseInt(no1),Integer.parseInt(no2));
			resultMessage="Product";
			break;
		case "divide":
			result=calculator.divide(Integer.parseInt(no1),Integer.parseInt(no2));
			resultMessage="Quotient";
			break;
			
		}
		modelAndView.addObject("result", result);
		modelAndView.addObject("message",resultMessage);
		modelAndView.setViewName("Output");
		
		return modelAndView;
	}
}
