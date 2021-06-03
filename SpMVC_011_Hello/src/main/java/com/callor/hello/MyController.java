package com.callor.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	
	/*
	 * RequsetMathod 일반적인 HTTP Server에서
	 * 		GET : 데이터 조회(SELECT)할때 사용 - a tag의 link 클릭
	 * 		POST : 데이터를 추가(INSERT) 할때 사용 - form에 값을 입력하여 서버로 보낼 때 
	 * 
	 * RESTfull HTTP Server에서 추가하여 사용
	 * 		PUT : 데이터를 업데이트(UPDATE) 할때 사용
	 * 		DELETE : 데이터를 삭제(DELETE)할때 사용
	 * 
	 * RequestMapping이 같고, RequestMethod가 같은 경우는 절대 허용하지 않는다
	 * 
	 * RequestMapping이 같더라도 RequsetMethod가 다르면 같이 사용할수 있다
	 * 
	 * GET mathod 방식으로 form에 담긴 데이터를 전송할때
	 * http://localhost:8080/hello.insert?name=홍길동&tel=전화번호
	 *  --> - 전송하는 데이터가 주소에 포함되어 전송되기 때문에 데이터가 쉽게 노출될수 있다
	 *  	-전체 URI(주소, 데이터 등등)의 길이가 256byte를 넘어가면 데이터가 잘리는 현상이 발생한다
	 * 
	 * POST method 방식으로 form에 담긴 데이터를 전송할때
	 * http://localhost:8080/hello/insert
	 *  --> - 전송하는 데이터가 HTTP 프로토콜의 BODY에 담겨서 
	 *  		전송되기 때문에 일단 주소창 등에 노출되지 않는다
	 *  	- 이론상으로는 전송하는 데이터의 크기에 제한이 없다
	 *   		다만, 이미지와 같은 큰 데이터를 전송하게 되면 네트워크에
	 *   		문제가 발생할 수 있어서 설정에서 일부 크기를 제한하기도 한다
	 *   
	 * 서버 입장에서 
	 * 	GET: http://localhost:8080/hello/insert?name=홍길동 으로 요청을 받았으면
	 * 	 @RequestMapping(value="/inset", method=GET)을 처리하는 method가 있어야 한다
	 * 
	 *  Mapping(value="/insert")가 있는데 method=POST만 있을 경우
	 *   서버는 405 Http 상태코드(Status Code)를 응답한다
	 *   
	 * 404 오류: URI가 없을때
	 * 
	 * 405 오류: URI는 있지만 
	 *  
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST) // --> Mapping 주소가 같더라도 RequestMethod가 다르면 사용할수있음
	public void my() {
		
	}
	
	// insert URI mapping으로 POST 방식의 요청을 처리하겠다
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insert() {
		
	}
	
	/*
	 * Spring에서는 Web으로부터 전달받은 데이터를
	 *  Java method의 매개변수를 설정하여 받을 수있다
	 *  
	 * Spring framework 내부에서 Reflection이라는 코드가 작동되어서
	 *  전달받은 변수이름과 Java method의 매개변수와 이름 매칭방법으로 변수를 받는다
	 * 	이런 코드는 개발자가 신경쓰지 않아도 자동으로 작동되는 코드이다
	 * 	getParameter() 등의 코드를 이제는 잊어도 된다
	 * 
	 * 그런데,
	 * 		Java method의 변수를 String형이 아닌 것으로 숫자형, Boolean형 등
	 * 	 설정을 하면 Reflection이 실행되는 동안에 
	 * 		String형 데이터를 설정된 데이터 type으로 형변환 과정이 실행된다
	 * 		이 과정에서 형변환의 Exception이 발생하면
	 * 		Reflection 코드가 중단되고, Spring Dispatcher는 Web 400 Status Code를
	 * 		응답해 버린다
	 * 	
	 * 		또한 구체적인 어떤 문제가 발생했는지 알려주지 않는다
	 * 	
	 */
	
	// insert URI mapping으로 GET 방식의 요청을 처리하겠다
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(String dummy, int num) {
		
		Integer.valueOf(dummy);
		
		
		//String strNum = "300A";
		
		//NumberFromat Exception이 발생함
		//Integer intNum = Integer.valueOf(strNum);
				
				
		
	}
}
