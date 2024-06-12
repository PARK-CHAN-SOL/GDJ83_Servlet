package com.sol.home.weather;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class WeatherService {

	private StringBuffer sb;
	
	public WeatherService() {
		this.sb = new StringBuffer();
		this.sb.append("서울 , 29.3 - 맑음 - 60");
		this.sb.append("-부산 , 33.6 - 맑음 - 90");
		this.sb.append("-제주 , 26.3 - 눈 - 30");
		this.sb.append("-광주 , 10.6 - 태풍 - 80");
	}

	public List<WeatherDTO> getWeathers() {
		String str = this.sb.toString();
		str = str.replace(",", "-");
		StringTokenizer st = new StringTokenizer(str, "-");
		LinkedList<WeatherDTO> wDTOs = new LinkedList<WeatherDTO>();
		while(st.hasMoreTokens()) {
			WeatherDTO wDTO = new WeatherDTO();
			wDTO.setCity(st.nextToken().trim());
			wDTO.setGion(Double.parseDouble(st.nextToken().trim()));
			wDTO.setStatus(st.nextToken().trim());
			wDTO.setHumidity(Integer.parseInt(st.nextToken().trim()));
			wDTOs.add(wDTO);
		}
		return wDTOs;
	}

}
