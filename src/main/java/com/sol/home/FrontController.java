package com.sol.home;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sol.home.student.StudentController;
import com.sol.home.weather.WeatherController;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("doGet(...) 실행됨");
		String uri = request.getRequestURI();
		String method = request.getMethod();

		if (!uri.equals("/favicon.ico")) {
			StringTokenizer st = new StringTokenizer(uri, "/");
			String folderStr = "";

			if (st.hasMoreTokens()) folderStr = st.nextToken();

			Action action = new Action();
			System.out.println(uri);
			System.out.println(method);

			if (uri.equals("/")) {
				action.setFlag(true);
				action.setPath("/WEB-INF/views/index.jsp");

			} else if (folderStr.equals("student")) {
				StudentController sc = new StudentController();
				action = sc.start(request);

			} else if (folderStr.equals("weather")) {
				WeatherController wc = new WeatherController();
				action = wc.start(request);

			}
			System.out.println( request.getRemoteAddr() );
			if (action.isFlag()) {
				RequestDispatcher view = request.getRequestDispatcher(action.getPath());
				view.forward(request, response);

			} else {
				response.sendRedirect(action.getPath());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
