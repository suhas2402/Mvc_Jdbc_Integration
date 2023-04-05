package com.suhas.anotation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suhas.anotation.Pojo.Student;


public interface StudentService {
	public List<Student> loadstudent();
	public void SaveStudent(Student student);
	Student getstudent(int id);
	public void update(Student student);
	public void delete(int id);
}
