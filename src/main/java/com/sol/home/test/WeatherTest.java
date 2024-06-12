package com.sol.home.test;

import com.sol.home.weather.WeatherDAO;

public class WeatherTest {

	public static void main(String[] args) throws Exception {

		WeatherDAO wDAO = new WeatherDAO();
		wDAO.getWeathers();
	}

}
