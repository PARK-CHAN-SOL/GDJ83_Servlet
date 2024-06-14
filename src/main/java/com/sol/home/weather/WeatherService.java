package com.sol.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO wDAO = null;

	public WeatherService() {
		this.wDAO = new WeatherDAO();
	}

	public List<WeatherDTO> getWeathers() {

		try {
			return this.wDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public WeatherDTO getDetail(WeatherDTO wDTO) {

		try {
			wDTO = wDAO.getDetail(wDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Exception 발생하면 try 에서 초기화가 진행되지 않는다
			wDTO = null;
		}

		return wDTO;
	}

	public void add(WeatherDTO wDTO) {
		try {
			wDAO.add(wDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(WeatherDTO wDTO) {
		try {
			wDAO.delete(wDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(WeatherDTO wDTO) {
		try {
			wDAO.update(wDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
