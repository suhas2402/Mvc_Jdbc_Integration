package com.suhas.anotation.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.suhas.anotation.Dao.StudentDao;
import com.suhas.anotation.Dao.StudentDaoImpl;
import com.suhas.anotation.service.ServiceImpl;
import com.suhas.anotation.service.StudentService;

@EnableWebMvc
@ComponentScan(basePackages = "com.suhas.anotation.controllers")
@Configuration
public class AppCnfg {
	@Bean
	public InternalResourceViewResolver viewresolver() {

		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");

		return viewresolver;

	}

	@Bean
	public DataSource datasource() {

		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUsername("system");
		datasource.setPassword("admin");
		datasource.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");

		return datasource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;
	}

	@Bean
	public StudentDao studentDao() {
		StudentDaoImpl sdimpl = new StudentDaoImpl();
		sdimpl.setJdbcTemplate(jdbcTemplate());
		return sdimpl;
	}

	@Bean
	public StudentService studentService() {
		ServiceImpl sd = new ServiceImpl();
		sd.setStudentDao(studentDao());
		return sd;
	}

}
