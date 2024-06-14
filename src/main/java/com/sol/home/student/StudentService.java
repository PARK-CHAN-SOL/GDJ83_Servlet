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
	
	public void makeStudent(StudentDTO sDTO) {
		try {
			sDAO.makeStudent(sDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
