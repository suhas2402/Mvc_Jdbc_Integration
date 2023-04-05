package com.suhas.anotation.Dao;

import java.util.List;

import com.suhas.anotation.Pojo.Student;

public interface StudentDao {

	public List<Student> loadstudent();
	public void SaveStudent(Student student);
	Student getstudent(int id);
	public void update(Student student);
	public void delete(int id);
}
