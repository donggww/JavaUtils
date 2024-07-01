package com.donggw.controller;

import com.donggw.entity.EmailReceiver;
import com.donggw.service.EmailReceiverService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/editEmailReceiver")
public class EmailReceiverController {

	private static final Logger log = LogManager.getLogger(EmailReceiverController.class);
	@Autowired
	private EmailReceiverService emailReceiverService;

	@PostMapping
	public EmailReceiver save(@RequestBody EmailReceiver emailReceiver) {
		return emailReceiverService.save(emailReceiver);
	}


	@PostMapping("/findEmailAll")
	public List<EmailReceiver> findAll() {
		return emailReceiverService.findAll();
	}

	@PostMapping("/deleteEmailById")
	public void deleteById(@RequestBody EmailReceiver emailReceiver) {
		try {
			emailReceiverService.deleteById(emailReceiver.getAutincId());
		} catch (EmptyResultDataAccessException e) {
			// Handle the exception, e.g., log it or rethrow a custom exception]
			log.info("无可删除记录！");
		}
	}

	@PostMapping("/findEmailByid")
	public EmailReceiver findById(@RequestBody EmailReceiver emailReceiver) {
		return emailReceiverService.findById(emailReceiver.getAutincId()).orElse(null);
	}

	@PostMapping("/findEmailByAny")
	public List<EmailReceiver> findEmailByAny(@RequestBody EmailReceiver emailReceiver) {
		return emailReceiverService.selectEmail(emailReceiver);
	}

}
