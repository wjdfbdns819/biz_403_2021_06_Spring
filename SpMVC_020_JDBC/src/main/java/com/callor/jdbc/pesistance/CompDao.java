package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.CompVO;

public interface CompDao extends GenericDao<CompVO, String> {
	
	// 출판사 코드로 조회
	public CompVO findById(String pk);
	public List<CompVO> findBytel(String ctel);
	public List<CompVO> findByaddr(String caddr);
	
	

}
