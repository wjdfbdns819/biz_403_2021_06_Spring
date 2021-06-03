package com.callor.hello;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	// value 항목은 하나의 project에서 절대 겹쳐서는 안됨 
	@RequestMapping(value = "/", method = RequestMethod.GET) // -->  가장 중요 
	
	// 실제 method이름을 중요하지 않음
	public String home(Locale locale, Model model) {

		return "home";
	}

}