package com.callor.jdbc.service.impl;

import org.springframework.stereotype.Service;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.service.MemberService;
@Service
public class MemverServiceImplV1 implements MemberService{

	@Override
	public UserVO login(String username, String password) {
		// TODO 로그인 처리
			// 1. id가 맞는 회원인가
		if(username.equalsIgnoreCase("Korea") && password.equals("1234")){
			
			UserVO userVO = new UserVO();
			userVO.setUsername(username);
			userVO.setName("홍길동");
			userVO.setEmail("wjdfbdns819@wjdfbdns819.com");
			return userVO;
		}
		
		return null;
	}

	@Override
	public int join(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserVO viewInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateInfo(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int expire(String username) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
