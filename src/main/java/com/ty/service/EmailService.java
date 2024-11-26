package com.ty.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ty.dto.Emaildto;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void send(Emaildto dto) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(dto.getTo());
		sm.setSubject(dto.getSubject());
		sm.setText(dto.getBody());
		
		javaMailSender.send(sm);
		
	};
	
}
