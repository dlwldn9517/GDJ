package com.gdu.app05.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {

		// API 요청 및 응답
		
		String key = "2226b7bc92047543a3afd798f6033fa3";
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=" + key + "&targetDt=" + targetDt;
		
		// API 주소 (주소 + 요청 파라미터)
		StringBuilder urlBuilder = new StringBuilder();
		
		try {
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			BufferedReader br = null;
			StringBuilder sb = new StringBuilder();
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
}
