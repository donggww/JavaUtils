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
	@Autowired
	com.donggw.mapper.EmailReceiver emailReceiverMapper;

	public EmailReceiver save(EmailReceiver emailReviver) {
		return emailReceiverRepository.save(emailReviver);
	}

	public Optional<EmailReceiver> findById(Long id) {
		return emailReceiverRepository.findById(id);
	}

	public List<EmailReceiver> findAll() {
		return emailReceiverRepository.findAll();
	}

	public void deleteById(Long id) {
		emailReceiverRepository.deleteById(id);
	}

	public List<EmailReceiver> selectEmail(EmailReceiver emailReceiver) {
		return emailReceiverMapper.selectEmail(emailReceiver);
	}
}
