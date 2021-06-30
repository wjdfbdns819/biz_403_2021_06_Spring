package com.callor.book.service.impl.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.callor.book.config.NaverSecret;
import com.callor.book.model.MovieDTO;
import com.callor.book.service.NaverMovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("naverMovieService")
public class NaverMovieServiceImplV1 implements NaverMovieService {

	@Override
	public String queryURL(String search) {
		// TODO Auto-generated method stub
		// 문자열 인코딩
		String searchUTF8 = null;
		
		try {
			searchUTF8 = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder queryURL = new StringBuilder();
		queryURL.append(NaverSecret.Nurl.MOVIE);
		
		String queryString = String.format("?query=%s", searchUTF8);
		queryURL.append(queryString);
		
		queryString = String.format("&display=%d", 10);
		queryURL.append(queryString);
		log.debug("Movie URL {}", queryURL.toString());
		
		return queryURL.toString();
	}

	@Override
	public String getJsonString(String queryURL) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		URL url = null;
		
		HttpURLConnection httpConn = null;
		
		// url 주소를 request 정보로 변환
		url = new URL(queryURL);
		
		// 생성된 url을 다른 서버에 연결
		httpConn = (HttpURLConnection) url.openConnection();
		
		// 요청하는 method get으로 설정(가져오기)
		httpConn.setRequestMethod("GET");
		
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverSecret.NAVER_CLIENT_ID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverSecret.NAVER_CLIENT_SECRET);
		
		int httpStatusCode = httpConn.getResponseCode();
		
		// naver로 부터 수신할 객체 설정
		InputStreamReader isr = null;
		
		if(httpStatusCode == 200) {
			isr = new InputStreamReader(httpConn.getInputStream());
			
		} else {
			isr = new InputStreamReader(httpConn.getInputStream());
		}
		
		BufferedReader buffer = null;
		buffer = new BufferedReader(isr);
		
		StringBuffer stBuffer = new StringBuffer();
		
		// 가져온 데이터 읽고, 변수에 저장
		while(true) {
			String reader = buffer.readLine();
			if(reader == null ) {
				break;
			}
			stBuffer.append(reader);
		}
		return stBuffer.toString();
	}

	@Override
	public List<MovieDTO> getNaverList(String jsonString) throws ParseException {
		// TODO List에 담아서 return
		
		// json parsing 도구 선언
		JSONParser jp = new JSONParser();
		
		// JsonString을 JSON 객체로 전환
		JSONObject jo = (JSONObject) jp.parse(jsonString);
		
		// ITEM 항목 추출한뒤 JSON 배열타입으로 변환
		// get("items")은 네이버가 client로 보내주는 값이라서 변수명을 변경하면 안됨
		// -> 설정한 변수에 아무것도 담기지 않아 오류로 null값이 return 됨
		JSONArray it = (JSONArray) jo.get("items");
		
		List<MovieDTO> mList = new ArrayList<MovieDTO>();
		
		int nMovieSize = it.size();
		for(int i  = 0 ; i < nMovieSize ; i++ ) {
			
			JSONObject its = (JSONObject) it.get(i);
			
			String title = (String) its.get("title");
			String link  = (String) its.get("link");
			String image = (String) its.get("image");
			String subtitle = (String) its.get("subtitle");
			String pubDate = (String) its.get("pubDate");
			String director = (String) its.get("director");
			String actor = (String) its.get("actor");
			String userRating = (String) its.get("userRating");
			
			
			// VO에 담기
			
			MovieDTO mDTO = MovieDTO.builder()
					.title(title)
					.link(link)
					.image(image)
					.subtitle(subtitle)
					.pubDate(pubDate)
					.director(director)
					.actor(actor)
					.userRating(userRating)
					.build();
			
			mList.add(mDTO);
			
		}
		return mList;
	}

}
