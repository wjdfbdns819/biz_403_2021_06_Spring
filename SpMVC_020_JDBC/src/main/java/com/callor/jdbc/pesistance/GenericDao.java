package com.callor.jdbc.pesistance;

import java.util.List;

import com.callor.jdbc.model.AuthorVO;

/*
 * 제네릭
 *  인터페이스의 부모역할을 하는 super interface임
 *   Dao와 같은 인터페이스를 설계할때
 *   Table마다 Dao 인터페이스를 만들고,
 *   인터페이스를 상속받아 클래스를 선언하는데 
 *   이때 대부분의 Dao에는 같은 이름의 method가 존재하더라
 *  
 *  그런데 dl method들이 return type과 매개변수가 달라서
 *   어쩔수 없이 비슷한(거의 같은)method를 갖는
 *   인터페이스를 중복 작성해야 함
 *   
 *  제네릭( <> 로 선언된 것을 의미함 )을 interface에 설정하고,
 *   임의의 이름을 지정해준다
 *   여기에서 VO, PK라는 이름을 임의로 지정하였다
 *  그리고 method를 선언할때
 *   제네릭으로 지정된 이름을 사용하여
 *   retrun type과 공통매개변수를 사용하였다
 *   
 *  이렇게 Generic을 갖는 interface를 만들어 두고,
 *   또다른 interface를 만들때 
 *   이 Generic interface를 상속받아서 사용한다
 *   
 *  상속받는 interface는 상속되는 곳에
 *   자신의 VO, primary key 칼럼의 PK type을 지정해 두면
 *   공통된 메서드를 다시 만들 필요가 없어진다
 *  
 *  
 */
public interface GenericDao<VO,PK> {

	public List<VO> selectAll();
	public VO findById(PK pk);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);
}
