package com.donggw.controller;

import com.donggw.entity.EmailReceiver;
import com.donggw.service.EmailReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/findById/{id}")
	public Optional<EmailReceiver> findById(@PathVariable Integer id) {
		return emailReceiverService.findById(id);
	}

	@GetMapping("/findAll")
	public List<EmailReceiver> findAll() {
		return emailReceiverService.findAll();
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Integer id) {
		emailReceiverService.deleteById(id);
	}
}
