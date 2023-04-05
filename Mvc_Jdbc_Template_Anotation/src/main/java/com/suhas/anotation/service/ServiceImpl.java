package com.suhas.anotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suhas.anotation.Dao.StudentDao;
import com.suhas.anotation.Pojo.Student;
@Service
public class ServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	public List<Student> loadstudent() {

		List<Student> studentList = studentDao.loadstudent();
		return studentList;
	}

	@Override
	public void SaveStudent(Student student) {

		studentDao.SaveStudent(student);

	}

	@Override
	public Student getstudent(int id) {

		return studentDao.getstudent(id);
	}

	@Override
	public void update(Student student) {

		studentDao.update(student);

	}

	@Override
	public void delete(int id) {
		studentDao.delete(id);

	}

}
