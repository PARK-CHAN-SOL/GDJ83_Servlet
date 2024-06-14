package com.sol.home.test;

import com.sol.home.weather.WeatherDAO;
import com.sol.home.weather.WeatherDTO;

public class WeatherTest {

	public static void main(String[] args) throws Exception {

		WeatherDAO wDAO = new WeatherDAO();
		WeatherDTO wDTO = new WeatherDTO();
		wDTO.setNum(1L);
		wDAO.delete(wDTO);
		wDAO.getWeathers();
		
	}

}
