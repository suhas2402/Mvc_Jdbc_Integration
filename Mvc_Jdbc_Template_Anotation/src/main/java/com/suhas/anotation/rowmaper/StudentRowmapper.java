package com.suhas.anotation.rowmaper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.suhas.anotation.Pojo.Student;

public class StudentRowmapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();
		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setMobile(rs.getDouble("mobile"));
		student.setCountry(rs.getString("country"));

		return student;

	}

}
