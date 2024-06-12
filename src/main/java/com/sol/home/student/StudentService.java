package com.sol.home.student;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StudentService {
	
	public List<Student> getStudents() {
		LinkedList<Student> students = new LinkedList<Student>();
		Random random = new Random();
		
		for(int i = 0; i < 5; i++) {
			Student student = new Student();
			
			student.setNum(i+1);
			student.setName("name"+i);
			student.setAvg(random.nextInt(100)+random.nextDouble());
			
			students.add(student);
		}
		
		return students;
	}
	
	public Student makeStudent() {
		Student student = new Student();
		
		student.setName("sol");
		student.setAvg(4.28);
		student.setNum(1);
		
		return student;
	}
}
