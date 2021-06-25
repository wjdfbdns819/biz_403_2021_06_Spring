package com.callor.score.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.callor.score.dao.ext.ScoreDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("scoreServiceV1")
public class ScoreServiceImplV1 implements ScoreService{

	protected final ScoreDao scDao;

	@Override
	public List<ScoreDTO> selectViewAll() {
		
		List<ScoreDTO> scList = scDao.selectViewAll();
		log.debug("전체 점수 service {} :" , scList.toString());
		
		
		return scList;
	}

	@Override
	public Map<String, Object> scoreViewAll() {
		
		List<ScoreDTO> scList = scDao.selectViewAll();
		
		Map<String, Object> maps = new HashMap<String, Object>();
		
		maps.put("전체 view", scList);
		
		log.debug("Map을 사용한 전체 view {} : " , maps.toString());
		
		 
		return maps;
	}

	@Override
	public List<SubjectAndScoreDTO> selectScore(String st_num) {
		
		List<SubjectAndScoreDTO> ssList = scDao.selectSubjectAndScore(st_num);
		
		return ssList;
	}

}
