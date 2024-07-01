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
		return emailReceiverRepository.findById(Math.toIntExact(id));
	}

	public List<EmailReceiver> findAll() {
		return emailReceiverMapper.findAll();
	}

	public void deleteById(Long id) {
		emailReceiverRepository.deleteById(Math.toIntExact(id));
	}

	public List<EmailReceiver> selectEmail(EmailReceiver emailReceiver) {
		return emailReceiverMapper.selectEmail(emailReceiver);
	}
}
