package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.ScoreDTO;
import com.callor.score.service.ScoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping(value = "/score")
public class ScoreController {
	
	protected final ScoreService scService;

	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET )
	public String scoreList(Model model) {
		
		List<ScoreDTO> scViewList = scService.selectViewAll();
		log.debug("전체 점수 Controller {} :", scViewList.toString());
		
		model.addAttribute("scAllList",scViewList);
		
		model.addAttribute("BODY", "SCORE_VIEW");
		
		return "home";
		
		
		
	}
}
