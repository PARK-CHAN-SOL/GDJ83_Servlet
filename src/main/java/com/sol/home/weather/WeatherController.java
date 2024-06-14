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

		// method 형식
		String method = request.getMethod().toUpperCase();

		if (spltUri.length > 2) {

			if (spltUri[2].equals("list")) {
				// WeatherService 파싱해서
				// getWeathers 실행
				// jsp에 보내서 출력
				List<WeatherDTO> wDTOs = ws.getWeathers();
				request.setAttribute("list", wDTOs);
				action.setPath("/WEB-INF/views/weather/list.jsp");

			} else if (spltUri[2].equals("add")) {
				if (method.equals("POST")) {
					String city = request.getParameter("city");
					double gion = Double.parseDouble(request.getParameter("gion"));
					String status = request.getParameter("status");
					int humidity = Integer.parseInt(request.getParameter("humidity"));
					WeatherDTO wDTO = new WeatherDTO();
					wDTO.setCity(city);
					wDTO.setGion(gion);
					wDTO.setStatus(status);
					wDTO.setHumidity(humidity);
					ws.add(wDTO);
					// 셋 다 동일
					// action .setPath("./list")
					// action.setPath("list")
					action.setPath("/weather/list");
					action.setFlag(false);
				} else {
					action.setPath("/WEB-INF/views/weather/add.jsp");
				}

			} else if (spltUri[2].equals("delete")) {
				if (method.equals("POST")) {
					action.setPath("/weather/list");
					action.setFlag(false);
					WeatherDTO wDTO = new WeatherDTO();
					wDTO.setNum(Long.parseLong(request.getParameter("num")));
					ws.delete(wDTO);
				} else {
					action.setPath("/weather/list");
					action.setFlag(false);
				}
			} else if (spltUri[2].equals("detail")) {
				//
				String num = request.getParameter("num");
				WeatherDTO wDTO = new WeatherDTO();
				wDTO.setNum(Long.parseLong(num));
				wDTO = ws.getDetail(wDTO);

				if (wDTO != null) {
					request.setAttribute("wDTO", wDTO);
					action.setPath("/WEB-INF/views/weather/detail.jsp");
				} else {
					request.setAttribute("message", "정보가 없습니다");
					action.setPath("/WEB-INF/views/commons/message.jsp");
				}

			} else if (spltUri[2].equals("update")){
				if(method.equals("POST")){
					WeatherDTO wDTO = new WeatherDTO();
					wDTO.setNum(Long.parseLong(request.getParameter("num")));
					wDTO.setCity(request.getParameter("city"));
					wDTO.setGion(Double.parseDouble(request.getParameter("gion")));
					wDTO.setStatus(request.getParameter("status"));
					wDTO.setHumidity(Integer.parseInt(request.getParameter("humidity")));
					ws.update(wDTO);
				} else {
					WeatherDTO wDTO = new WeatherDTO();
					wDTO.setNum(Long.parseLong(request.getParameter("num")));
					wDTO = ws.getDetail(wDTO);
					request.setAttribute("wDTO", wDTO);
					action.setPath("/WEB-INF/views/weather/update.jsp");					
				}
			}else {

			}

		}
		return action;
	}

}
