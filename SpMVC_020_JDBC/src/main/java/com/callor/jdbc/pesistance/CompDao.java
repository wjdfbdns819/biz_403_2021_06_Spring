package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.CompVO;

public interface CompDao extends GenericDao<CompVO, String> {
	
	// 출판사 코드로 조회
	public String findByMaxCdoe();
	public List<CompVO> findByCName(String cname);
	public List<CompVO> findByTel(String tel);
	public List<CompVO> findByCeo(String ceo);
	
	

}
