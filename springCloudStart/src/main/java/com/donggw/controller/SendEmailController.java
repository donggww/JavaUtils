package com.donggw.controller;

import com.donggw.dto.EmailRequest;
import com.donggw.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {

	private static final Logger logger = LoggerFactory.getLogger(SendEmailController.class);

	private final EmailService emailService;

	@Autowired
	public SendEmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody EmailRequest emailRequest) {
		try {
			emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
			logger.info("邮件发送成功！");
		} catch (Exception e) {
			logger.error("邮件发送失败", e);
			return "send Email Fail";
		}
		return "send success";
	}
}