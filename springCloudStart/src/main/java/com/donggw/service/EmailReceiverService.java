package com.donggw.service;

import com.donggw.entity.EmailReceiver;
import com.donggw.repository.EmailReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailReceiverService {

	@Autowired
	EmailReceiverRepository emailReceiverRepository;

	public EmailReceiver save(EmailReceiver emailReviver) {
		return emailReceiverRepository.save(emailReviver);
	}

	public Optional<EmailReceiver> findById(Integer id) {
		return emailReceiverRepository.findById(id);
	}

	public List<EmailReceiver> findAll() {
		return emailReceiverRepository.findAll();
	}

	public void deleteById(Integer id) {
		emailReceiverRepository.deleteById(id);
	}
}
