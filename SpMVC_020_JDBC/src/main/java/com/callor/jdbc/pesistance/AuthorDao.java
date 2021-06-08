package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

public interface AuthorDao extends GenericDao<AuthorVO, String>{

	//작가 코드로 조회
	public AuthorVO findById(String pk);
	public List<AuthorVO> findByTel(String atel);
}
