package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.dto.Emaildto;
import com.ty.entity.Staff;
import com.ty.entity.Student;
import com.ty.service.EmailService;
import com.ty.service.StaffService;
import com.ty.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EmailService emailService;
	

	@GetMapping("/")
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("staff", new Staff());
		return mv;
	}

	@PostMapping("/register")
	public ModelAndView registerStaff(Staff staff) {

		boolean result = staffService.register(staff);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.addObject("msg", "Registered successfully");
			mv.setViewName("login");
		} else {

			mv.addObject("msg", "Email already exist.");
			mv.setViewName("register");

		}
		return mv;

	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {

		String email = request.getParameter("email");

		String password = request.getParameter("password");

		ModelAndView mv = new ModelAndView();
		boolean result = staffService.login(email, password);

		if (result) {
			List<Student> all = studentService.getAllStudent();
			mv.addObject("msg", "Welcome to App");
			mv.setViewName("home");
			mv.addObject("students", all);
		} else {

			mv.addObject("msg", "Invalid credentials.");
			mv.setViewName("login");

		}

		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");

		return mv;
	}

	@GetMapping("/home")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAllStudent();
		mv.addObject("students", all);
		return mv;
	}

	@GetMapping("/add")
	public ModelAndView addStudent() {
		ModelAndView mv = new ModelAndView("student");
		mv.addObject("student", new Student());

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView saveStudent(Student student) {
		// TODO: process POST request
		Student s = studentService.saveStudent(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAllStudent();
		mv.addObject("students", all);
		if (s != null) {
//			mv.setViewName("home");
			mv.addObject("msg", "Student Registered Sucessfully");

		} else {

//			mv.setViewName("home");
			mv.addObject("msg", "An error Occured");

		}
		return mv;

	}

	@GetMapping("/update")
	public ModelAndView updateStudent(@RequestParam Integer Id) {
		Student s = studentService.getById(Id);
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("stu", s);

		return mv;
	}

	@PostMapping("/update")
	public ModelAndView postMethodName(Student student) {
		// TODO: process POST request
		studentService.saveStudent(student);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAllStudent();
		mv.addObject("students", all);
		return mv;
	}

//	
	@GetMapping("/delete")
	public ModelAndView deleteStudent(@RequestParam Integer Id) {
		Student s = studentService.getById(Id);
		ModelAndView mv = new ModelAndView("home");
		if (s != null) {
//			mv.setViewName("home");
			studentService.deleteStudentById(Id);
			List<Student> all = studentService.getAllStudent();
			mv.addObject("students", all);
			mv.addObject("msg", "Student Deleted Sucessfully");

		} else {


			mv.addObject("msg", "Student Not Found.");

		}
		return mv;

	}
	
	@GetMapping("/email")
	public ModelAndView	 getEmailPage() {
		ModelAndView mv = new ModelAndView("email");
		mv.addObject("emaildto", new Emaildto());
		return mv;
	}	
	@PostMapping("/send")
	public ModelAndView sendEmailTo(Emaildto dto) {
		//TODO: process POST request
		emailService.send(dto);
		ModelAndView mv = new ModelAndView("home");
		List<Student> all = studentService.getAllStudent();
		mv.addObject("students", all);
		mv.addObject("msg", "Mail sent");

		
		return mv;
		
	}
	
	
	

}
