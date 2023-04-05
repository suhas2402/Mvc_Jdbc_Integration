package com.suhas.anotation.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suhas.anotation.Pojo.Student;
import com.suhas.anotation.rowmaper.StudentRowmapper;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> loadstudent() {

		String sql = "SELECT * FROM stu";
		List<Student> studentList = jdbcTemplate.query(sql, new StudentRowmapper());

		return studentList;
	}

	@Override
	public void SaveStudent(Student student) {

		Object[] parameters = { student.getName(), student.getMobile(), student.getCountry() };

		String sql = "insert into stu(name,mobile,country) values(?,?,?)";

		jdbcTemplate.update(sql, parameters);

		System.out.println("1 Record Inserted Successfully");

	}

	@Override
	public Student getstudent(int id) {
		String sql = "SELECT * FROM stu where id=?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowmapper(), id);
		return student;
	}

	@Override
	public void update(Student student) {
		String sql = "UPDATE stu SET name=?,mobile=?,country=? WHERE id=?";
		jdbcTemplate.update(sql, student.getName(), student.getMobile(), student.getCountry(), student.getId());
		System.out.println("1 Record Updated....");
	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM stu WHERE id=? ";
		jdbcTemplate.update(sql, id);

	}

}
