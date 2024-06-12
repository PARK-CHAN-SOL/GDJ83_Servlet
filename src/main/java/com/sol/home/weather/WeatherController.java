package com.sol.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sol.home.Action;

// 어떤 url이 왔을 때 어떤 일을 시키고 어떤 jsp로 보낼거냐
// url오면 요청에 맞는 일 시키고 jsp로 보내기
public class WeatherController {

	public Action start(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String[] spltUri = uri.split("/");
		WeatherService ws = new WeatherService();
		Action action = new Action();
		action.setFlag(true);
		action.setPath("/WEB-INF/views/index.jsp");
		if (spltUri.length > 2) {
			
			if (spltUri[2].equals("list")) {
				// WeatherService 파싱해서
				// getWeathers 실행
				// jsp에 보내서 출력
				List<WeatherDTO> wDTOs = ws.getWeathers();
				request.setAttribute("list", wDTOs);
				action.setPath("/WEB-INF/views/weather/list.jsp");
				
			} else if (spltUri[2].equals("add")) {
				action.setPath("/WEB-INF/views/weather/add.jsp");
				
			} else if (spltUri[2].equals("delete")) {
				action.setPath("/WEB-INF/views/weather/delete.jsp");
				
			} else if (spltUri[2].equals("detail")) {
				action.setPath("/WEB-INF/views/weather/detail.jsp");
				
			} else {

			}

		}
		return action;
	}

}
