package com.donggw.controller;

import com.donggw.entity.EmailReceiver;
import com.donggw.service.EmailReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editEmailReceiver")
public class EmailReceiverController {

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
		emailReceiverService.deleteById(emailReceiver.getId());
	}

	@PostMapping("/findEmailByid")
	public Optional<EmailReceiver> findById(@RequestBody EmailReceiver emailReceiver) {
		return emailReceiverService.findById(emailReceiver.getId());
	}

	@PostMapping("/findEmailByAny")
	public ResponseEntity<EmailReceiver> findEmailReceiverByParams(@RequestBody EmailReceiver emailReceiver) {
		Optional<EmailReceiver> result = emailReceiverService.findEmailByAny(emailReceiver);
		return result.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

}
