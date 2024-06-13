package com.sol.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public List<StudentDTO> getStudents() throws Exception {
		File file = new File("C://study//student.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String info = br.readLine();
		String[] infos = null;
		List<StudentDTO> sDTOs = new ArrayList<StudentDTO>();
		
		while(info != null) {
			infos = info.split(",");
			StudentDTO sDTO = new StudentDTO();
			
			sDTO.setNum(Integer.parseInt(infos[0].trim()));
			sDTO.setName(infos[1].trim());
			sDTO.setKor(Integer.parseInt(infos[2].trim()));
			sDTO.setEng(Integer.parseInt(infos[3].trim()));
			sDTO.setMath(Integer.parseInt(infos[4].trim()));
			sDTO.setTotal(Integer.parseInt(infos[5].trim()));
			sDTO.setAvg(Double.parseDouble(infos[6].trim()));
			
			sDTOs.add(sDTO);
			
			info = br.readLine();
		}
		
		br.close();
		fr.close();
		return sDTOs;
	}
	
	public StudentDTO makeStudent() {
		return null;
	}
	
	public StudentDTO getDetail(StudentDTO sDTO) throws Exception {
		List<StudentDTO> sDTOs = this.getStudents();
		for(StudentDTO sDTOTmp : sDTOs) {
			if(sDTOTmp.getNum() == sDTO.getNum()) {
				sDTO = sDTOTmp;
				return sDTO;
			}
		}
		return null;
	}
}
