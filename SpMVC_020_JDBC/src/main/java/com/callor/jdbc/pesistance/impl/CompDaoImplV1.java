package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;

/*
 * [@Component] 
 *  모든 Component를 대표하는 Annotation
 *   컴파일과정에서 다소 비용이 많이 소요된다
 *   
 * 그래서 별도로
 * @Controller, @Service, @Repository 등의 Annotation을 사용한다
 *  Spring Container에게 이 표식들이 부착된 클래스를 bean으로 생성하여
 *  보관해 달라는 지시어들임
 *  (@Controller, @Service, @Repository 들도 Component Annotation에 속함)
 *  
 *  
 *  CompVO c = new CompVO()
 *  Object o = new CompVO()
 *  
 *  CompServiceImplV1 cs = new CompServiceImpV1();
 *  ComService cs1 = new CompServiceImplV1();
 */

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
		
		// VO가 바로 주입이 안되기때문에 배열을 생성해야함
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

	/*
	 * jdbcTemlate을 사용하여 QUERY를 실행할때
	 *  각 method에서 매개변수를 받아
	 *  QUERY에 전달할텐데
	 *  이때 매개변수는 primitive로 받으면 값을 변환시키는 어려움이 있기 때문에
	 *  권장사항으로 매개변수를 wrapper class type으로 설정해야 한다
	 *  
	 *  즉 숫자형일 경우 int, long 대신 Integer, Long 형으로 선언
	 *  
	 * VO에 담겨서 전달된 값은 Object[] 배열로 변환한 후
	 *  jdbcTemlate에 전달해 주어야 한다
	 *  
	 * 하지만 1 ~ 2개 정도의 값을 전달할때 Object[] 배열로 변환 후
	 *  전달을 하면 Object 객체 저장소가 생성되고, 메모리를 사용한다
	 *  이때 전달되는 변수가 wrapper class type이면 
	 *  Object[] 배열로 만들지 않고, 바로 주입할수 있다 
	 */
	@Override
	public int delete(String cpcode) {
		// TODO 출판사 정보 삭제
		String sql = " DELETE FROM tbl_company ";
		sql += " WHERE cp_code = ? ";
		
		/*
		 * cpcode가 String wrapper class type 이므로
		 *  Object[] 배열로 변환하지 않고, 바로 전달이 가능하다
		 */
		// Object[] params = new Object[] {cpcode};
		
		return jdbcTemplate.update(sql,cpcode);	
	}

	@Override
	public CompVO findById(String cp_code) {
		String sql = " SELECT * FROM tbl_company";
		
		sql = " WHERE cp_code = ? ";
		Object[] params = new Object[] { cp_code } ;
		
		CompVO vo = (CompVO) jdbcTemplate.query(sql, 
				params, new BeanPropertyRowMapper<CompVO>(CompVO.class));
		return vo;
	}


	/*
	 * tbl_company table에서 cpcode(출판사코드) 중
	 *  가장 큰값을 추출하기
	 */
	@Override
	public String findByMaxCdoe() {
		// TODO Auto-generated method stub
		String sql = " SELECT MAX(cp_code) FROM tbl_company ";
		
		String cpCode = (String) jdbcTemplate.queryForObject(sql, String.class);
				
		return cpCode;
	}

	@Override
	public List<CompVO> findByCName(String cname) {
		// TODO 출판사 이름으로 조회하기
		
		String sql = " SELECT * FROM tbl_company ";
		
		// 오라클의 경우 
		// WHERE cp_code LIKE '%' || '%' 으로 사용
		sql += " WHERE cp_name LIKE CONCAT('%', ? '%') "; // mysql
		
		
		// SELECT를 수행한 후 각각의 데이터를 compVO에 담고,
		// List에 add하여 return 한후
		// compList에 받기
		List<CompVO> compList
			= jdbcTemplate.query(sql, new Object[] {cname},
					new BeanPropertyRowMapper<CompVO>(CompVO.class)
					);
		
		return compList;
	}

	@Override
	public List<CompVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}

}
