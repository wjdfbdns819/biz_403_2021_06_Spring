package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;

/*
 * Dao(Data Access Object)
 *  Service -> Dao -> DBMS 과정에서
 *  실질적인 한개 table에 대한 CRUD를 담당할  interface, class
 *  
 * Servlet project에서 Service가 실행했던 역할을 Dao가 실행하게 된다
 */
public interface BookDao extends GenericDao<BookVO, String> {
	
	// Generic에 선언된 method에 추가하여 도서정보
	// 테이블에서 여러가지로 조회할 method 작성
	
	
	// 도서명으로 조회하기
	public List<BookVO> findByName(String name);

	// 출판일로 조회하기
	public List<BookVO> findByDate(String date);
	
	// 출판사코드로 조회하기
	public List<BookVO> findByComp(String comp);
	
	// 작가코드로 조회하기
	public List<BookVO> findByAuthor(String author);
	
}
