package com.callor.score.service;

import java.util.List;
import java.util.Map;

import com.callor.score.model.ScoreDTO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreService {

	public List<ScoreDTO> selectViewAll();
	
	public Map<String, Object> scoreViewAll();
	
	public List<SubjectAndScoreDTO> selectScore(String st_num);
}
