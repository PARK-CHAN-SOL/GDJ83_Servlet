package com.sol.home.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sol.home.Action;

public class StudentController {

	private StudentService studentService;

	public StudentController() {
		this.studentService = new StudentService();
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	public Action start(HttpServletRequest request) {
		// /student/???

		// list : 학생정보전체출력
		// add : 학생한명정보추가
		// delete : 학생한명정보삭제
		// detail : 한생한명정보출력
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String[] spltUri = uri.split("/");

		Action action = new Action();
		action.setFlag(true);
		action.setPath("/WEB-INF/views/index.jsp");

		if (spltUri.length > 2) {
			if (spltUri[2].equals("list")) {
				List<StudentDTO> sDTOs = this.studentService.getStudents();
				if (sDTOs != null) {
					request.setAttribute("list", sDTOs);
					action.setPath("/WEB-INF/views/student/list.jsp");
				} else {
					request.setAttribute("messages", "정보가 없습니다");
					action.setPath("/WEB-INF/views/commons/messages.jsp");
				}

			} else if (spltUri[2].equals("add")) {
				if (method.toUpperCase().equals("POST")) {
					StudentDTO sDTO = new StudentDTO();
					String name = request.getParameter("name");
					int num = Integer.parseInt(request.getParameter("num"));
					double avg = Double.parseDouble(request.getParameter("avg"));
					System.out.println(name + num + avg);
					sDTO.setName(name);
					sDTO.setNum(num);
					sDTO.setAvg(avg);

					System.out.println(request.getParameter("ch"));
					System.out.println(request.getParameter("mobile"));

					for (String ch2 : request.getParameterValues("ch2")) {
						System.out.println(ch2);
					}

					System.out.println(request.getParameter("textArea"));

					action.setFlag(false);
					action.setPath("./list");
				} else {
					action.setPath("/WEB-INF/views/student/add.jsp");
				}

			} else if (spltUri[2].equals("delete")) {
//				action.setPath("/WEB-INF/views/student/delete.jsp");

			} else if (spltUri[2].equals("detail")) {
				StudentDTO sDTO = new StudentDTO();
				sDTO.setNum(Integer.parseInt(request.getParameter("num")));
				sDTO = studentService.getDetail(sDTO);
				if(sDTO != null) {
					request.setAttribute("sDTO", sDTO);
					action.setPath("/WEB-INF/views/student/detail.jsp");					
				} else {
					request.setAttribute("messages", "정보가 없습니다");
					action.setPath("/WEB-INF/views/commons/messages.jsp");
				}

			} else {

			}

		}
		return action;
	}

}
