package com.ty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ty.entity.Staff;
import com.ty.entity.Student;
import com.ty.repository.StaffRepository;
import com.ty.repository.StudentRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepo;

	public boolean register(Staff staff) {
		// TODO Auto-generated method stub

		Optional<Staff> s = staffRepo.findByEmail(staff.getEmail());

		if (s.isPresent()) {
			return false;
		} else {
			staffRepo.save(staff);
			return true;
		}

	}

	public boolean login(String email, String password) {
		// TODO
		Optional<Staff> s = staffRepo.findByEmail(email);

		if (s.isPresent()) {

			if (s.get().getPassword().equals(password))
				return true;

			return false;
		} else {
			return false;
		}
	}

}
