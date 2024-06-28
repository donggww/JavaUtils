package com.donggw.controller;

import com.donggw.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	private final EmailService emailService;

	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestParam String to,
	                        @RequestParam String subject,
	                        @RequestParam String text) {
		try {
			emailService.sendEmail(to, subject, text);
			logger.info("邮件发送成功！");
		} catch (Exception e) {
			logger.error("邮件发送失败", e);
			return "send fail";
		}
		return "send success";
	}
}