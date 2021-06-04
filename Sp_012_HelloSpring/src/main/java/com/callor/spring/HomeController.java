package com.callor.spring;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	// getLogger() 안에 HomeController.class 대신 문자열을 넣어도 가능함
	// 디버깅 코드임
	private static final Logger logger = LoggerFactory.getLogger("Home Controller");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// logger의 method들
		//  이 method 들을 logger에서는 level이라고 부름
		
		// ex) 
		//	logback-test.xml의 level을 INFO로 설정
		//	 코드 곳곳에 logger.trace(), logger.debug()로 
		//	 출력한 곳은 모두 코드가 무시된다
		
		logger.trace("트레이스"); // trace가 level이 제일 높음
		logger.debug("디버그");
		logger.info("인포 Welcome home! The client locale is {}.", locale);
		logger.warn("워닝");
		logger.error("에러");
		
		logger.debug(String.valueOf(300 * 400));
		logger.debug("여기는 Home Controller return 바로 위");

		return "home";
	}

}
