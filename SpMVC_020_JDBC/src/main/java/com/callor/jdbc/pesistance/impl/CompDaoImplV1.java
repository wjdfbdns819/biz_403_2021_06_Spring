package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;

// 콘솔에 출력해보기 위해서 slf4j를 사용
@Slf4j

@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;
	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	
	}
	
	@Override
	public List<CompVO> selectAll() {
		// TODO 출판사 전체 조회
		String sql = " SELECT * FROM tbl_company";
		
		List<CompVO> compList
		= jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
	
		log.debug("Comp Select {}", compList.toString());
		
		return compList;
	}

	@Override
	public int insert(CompVO vo) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO tbl_company";
		sql += " (cp_code,cp_title,cp_ceo,cp_addr,cp_tel) ";
		sql += " VALUES( ?,?,?,?,? ) ";
		
		Object[] params = new Object[] {
				vo.getCp_code(),
				vo.getCp_title(),
				vo.getCp_ceo(),
				vo.getCp_addr(),
				vo.getCp_tel()
		};
		
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CompVO findById(String pk) {
		String sql = " SELECT * FROM tbl_company";
		
		sql = " WHERE";
		Object[] params = new Object[] { pk } ;
		
		CompVO vo = (CompVO) jdbcTemplate.query(sql, 
				params, new BeanPropertyRowMapper<CompVO>(CompVO.class));
		return vo;
	}

	@Override
	public List<CompVO> findBytel(String ctel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByaddr(String caddr) {
		// TODO Auto-generated method stub
		return null;
	}

}
