package com.suhas.anotation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suhas.anotation.Pojo.Student;
import com.suhas.anotation.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/showstudent", method = RequestMethod.GET)
	public String ShowStudentlist(Model model) {

		List<Student> studentlist = studentService.loadstudent();

		model.addAttribute("Student", studentlist);

		return "student-list";

	}

	@RequestMapping(value = "/showform", method = RequestMethod.GET)
	public String AddStudent(Model model) {

		Student addstudent = new Student();
		model.addAttribute("students", addstudent);

		return "add-student";

	}

	@RequestMapping(value = "/savestudent", method = RequestMethod.GET)
	public String SaveStudent(Student student) {
		if (student.getId() == 0) {
			studentService.SaveStudent(student);
		} else {
			studentService.update(student);
		}
		return "redirect:/showstudent";

	}

	@RequestMapping(value = "/updatestudent", method = RequestMethod.GET)
	public String updateStudent(@RequestParam("userId") int id, @ModelAttribute("students") Student student,
			Model model) {

		Student thestudent = studentService.getstudent(id);
		model.addAttribute("students", thestudent);

		return "add-student";

	}

	@RequestMapping(value = "/deletestudent", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam("userId") int id, Model model) {

	studentService.delete(id);

		return "redirect:/showstudent";

	}

}
