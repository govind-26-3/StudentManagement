package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.entity.Staff;
import com.ty.entity.Student;
import com.ty.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepo;

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return  studentrepo.findAll();
	}

	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepo.save(student);
		
		
		
	}

	public  Student getById(Integer id) {
		// TODO Auto-generated method stub
		return studentrepo.findById(id).get();
		
		
		
	}

	public void deleteStudentById(Integer id) {
		// TODO Auto-generated method stub
		 studentrepo.deleteById(id);
	}

	
	

}
