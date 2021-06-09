package com.callor.jdbc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.jdbc.service.RentService;


@Controller
public class HomeController {
	
	protected final RentService rentService;
	public HomeController(RentService rentService) {
		this.rentService = rentService;
		
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		rentService.viewBookAndComp();		
		return "home";
	}
	
}
