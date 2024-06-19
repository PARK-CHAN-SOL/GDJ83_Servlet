package com.sol.home.student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	private File file;

	public StudentDAO() {
		this.file = new File("C://study//student.txt");
	}

	public List<StudentDTO> getStudents() throws Exception {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String info = br.readLine();
		String[] infos = null;
		List<StudentDTO> sDTOs = new ArrayList<StudentDTO>();

		while (info != null) {
			infos = info.split(",");
			if(info.length() < 5) break;
			StudentDTO sDTO = new StudentDTO();

			sDTO.setNum(Long.parseLong(infos[0].trim()));
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

	public void makeStudent(StudentDTO sDTO) throws Exception {
		FileWriter fw = new FileWriter(file, true);
		StringBuffer sb = new StringBuffer();
		int total = sDTO.getKor() + sDTO.getEng() + sDTO.getMath();
		double avg = total / 3.0;
		sb.append(sDTO.getNum()).append(",").append(sDTO.getName()).append(",")
		.append(sDTO.getKor()).append(",").append(sDTO.getEng()).append(",").append(sDTO.getMath()).append(",")
		.append(total).append(",").append(avg).append("\n");
		fw.write(sb.toString());
		fw.close();
	}

	public StudentDTO getDetail(StudentDTO sDTO) throws Exception {
		List<StudentDTO> sDTOs = this.getStudents();
		for (StudentDTO sDTOTmp : sDTOs) {
			if (sDTOTmp.getNum() == sDTO.getNum()) {
				sDTO = sDTOTmp;
				return sDTO;
			}
		}
		return null;
	}
	
	public void delete(StudentDTO sDTO) throws Exception{
		List<StudentDTO> sDTOs = this.getStudents();
		FileWriter fw = new FileWriter(file,false);
		StringBuffer sb = new StringBuffer();
		for(StudentDTO sDTOtmp : sDTOs) {
			if(sDTOtmp.getNum() == sDTO.getNum()) {
				continue;
			}
			sb.append(sDTOtmp.getNum()).append(",").append(sDTOtmp.getName()).append(",")
			.append(sDTOtmp.getKor()).append(",").append(sDTOtmp.getEng()).append(",").append(sDTOtmp.getMath()).append(",")
			.append(sDTOtmp.getTotal()).append(",").append(sDTOtmp.getAvg()).append("\n");
		}
		fw.write(sb.toString());
		fw.close();
	}
	
	public void update(StudentDTO sDTO) throws Exception{
		List<StudentDTO> sDTOs = this.getStudents();
		FileWriter fw = new FileWriter(file,false);
		int total = sDTO.getKor() + sDTO.getEng() + sDTO.getMath();
		double avg = total / 3.0;
		sDTO.setTotal(total);
		sDTO.setAvg(avg);
		StringBuffer sb = new StringBuffer();
//		for(StudentDTO sDTOtmp : sDTOs) {
//			if(sDTOtmp.getNum() == sDTO.getNum()) {
//				sDTOtmp.setName(sDTO.getName());
//				sDTOtmp.setKor(sDTO.getKor());
//				sDTOtmp.setEng(sDTO.getEng());
//				sDTOtmp.setMath(sDTO.getMath());
//				sDTOtmp.setTotal(total);
//				sDTOtmp.setAvg(avg);
//			}
//			sb.append(sDTOtmp.getNum()).append(",").append(sDTOtmp.getName()).append(",")
//			.append(sDTOtmp.getKor()).append(",").append(sDTOtmp.getEng()).append(",").append(sDTOtmp.getMath()).append(",")
//			.append(sDTOtmp.getTotal()).append(",").append(sDTOtmp.getAvg()).append("\n");
//		}
		for(int i = 0; i < sDTOs.size(); i++) {
			if(sDTO.getNum() == sDTOs.get(i).getNum()) {
				sDTOs.set(i, sDTO);
			}
			sb.append(sDTOs.get(i).getNum()).append(",").append(sDTOs.get(i).getName()).append(",")
			.append(sDTOs.get(i).getKor()).append(",").append(sDTOs.get(i).getEng()).append(",").append(sDTOs.get(i).getMath()).append(",")
			.append(sDTOs.get(i).getTotal()).append(",").append(sDTOs.get(i).getAvg()).append("\n");
		
		}
		fw.write(sb.toString());
		fw.close();
	}

}
