package com.donggw.controller;

import com.donggw.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	private final EmailService emailService;

	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestParam String to,
	                        @RequestParam String subject,
	                        @RequestParam String text) {

		emailService.sendEmail(to, subject, text);

		return "send success";
	}
}
