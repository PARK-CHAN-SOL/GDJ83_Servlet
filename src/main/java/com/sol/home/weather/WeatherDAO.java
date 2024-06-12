package com.sol.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

	// DTO: Data Transfer Object
	// DAO: Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 읽어와서 파싱한 후에 DTO에 담아서 리턴
	public List<WeatherDTO> getWeathers() throws Exception {
		File wtxt = new File("C:\\study", "Weather.txt");
		if(!wtxt.exists()) return null;
		FileReader fr = new FileReader(wtxt);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		ArrayList<WeatherDTO> wDTOs = new ArrayList<WeatherDTO>();
		
		while (s != null) {
			s = s.replace("-", ",");
			String[] infos = s.split(",");
			WeatherDTO wDTO = new WeatherDTO();
			wDTO.setNum(Long.parseLong(infos[0].trim()));
			wDTO.setCity(infos[1].trim());
			wDTO.setGion(Double.parseDouble(infos[2].trim()));
			wDTO.setStatus(infos[3].trim());
			wDTO.setHumidity(Integer.parseInt(infos[4].trim()));
			s = br.readLine();
			wDTOs.add(wDTO);
		}

		fr.close();
		br.close();
		return wDTOs;
	}
}