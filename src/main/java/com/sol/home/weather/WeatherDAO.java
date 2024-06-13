package com.sol.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

public class WeatherDAO {

	// DTO: Data Transfer Object
	// DAO: Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 읽어와서 파싱한 후에 DTO에 담아서 리턴
	File wtxt;

	public WeatherDAO() {
		this.wtxt = new File("C:\\study", "Weather.txt");
	}

	public List<WeatherDTO> getWeathers() throws Exception {
		if (!wtxt.exists()) return null;
		FileReader fr = new FileReader(wtxt);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		ArrayList<WeatherDTO> wDTOs = new ArrayList<WeatherDTO>();

		while (s != null) {
//			s = s.replace("-", ",");
			String[] infos = s.split(",");
			if(infos.length == 0) break;
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

	// detail
	public WeatherDTO getDetail(WeatherDTO wDTO) throws Exception {
		List<WeatherDTO> wDTOs = this.getWeathers();

		WeatherDTO result = null;

		for (WeatherDTO wDTOTmp : wDTOs) {
			if (wDTO.getNum() == wDTOTmp.getNum()) {
				result = wDTOTmp;
				break;
			}
		}

		return result;
	}

	// 1. 입력 폼 페이지 /weather/add GET
	// 2. 폼에서 입력한 정보를 서버에서 파일로 저장 /weather/add POST
	public void add(WeatherDTO wDTO) throws Exception {
		StringBuffer sb = new StringBuffer();
		FileWriter fw = new FileWriter(wtxt, true);
		List<WeatherDTO> wDTOs = getWeathers();
		wDTO.setNum(wDTOs.size() + 1);
		
		sb.append(wDTO.getNum()).append(",").append(wDTO.getCity())
		.append(",").append(wDTO.getGion()).append(",").append(wDTO.getStatus()).append(",")
		.append(wDTO.getHumidity()).append("\n");
		
		fw.write(sb.toString());
		
		fw.close();
	}

}