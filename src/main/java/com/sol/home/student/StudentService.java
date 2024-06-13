package com.sol.home.student;

import java.util.List;

public class StudentService {
	
	private StudentDAO sDAO = null;
	
	public StudentService() {
		this.sDAO = new StudentDAO();
	}
	
	
	public List<StudentDTO> getStudents() {
		try {
			return sDAO.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public StudentDTO makeStudent() {
		StudentDTO studentDTO = new StudentDTO();
		
		studentDTO.setName("sol");
		studentDTO.setAvg(4.28);
		studentDTO.setNum(1);
		
		return studentDTO;
	}
	
	public StudentDTO getDetail(StudentDTO sDTO) {
		try {
			sDTO = this.sDAO.getDetail(sDTO);
			return sDTO;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
