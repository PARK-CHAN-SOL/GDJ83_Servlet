package com.sol.home.weather;

import java.util.List;


public class WeatherService {

	
	public WeatherService() {
	}

	public List<WeatherDTO> getWeathers() {
		
		try {
			return new WeatherDAO().getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
