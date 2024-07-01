package com.donggw.controller;

import com.donggw.dto.ApiResponse;
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
import java.util.Optional;


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
	public ApiResponse<List<EmailReceiver>> findAll() {

		List<EmailReceiver> emailReceivers = emailReceiverService.findAll();
		if (!emailReceivers.isEmpty()) {
			return ApiResponse.success(emailReceivers);
		} else {
			return ApiResponse.error("100001", "查询无返回记录");
		}
	}

	@PostMapping("/deleteEmailById")
	public ApiResponse<List<?>> deleteById(@RequestBody EmailReceiver emailReceiver) {
		try {
			emailReceiverService.deleteById(emailReceiver.getAutincId());
			return ApiResponse.success(null);
		} catch (EmptyResultDataAccessException e) {
			// Handle the exception, e.g., log it or rethrow a custom exception]
			log.info("无可删除记录！");
			return ApiResponse.error("100001", "无可删除记录");

		}
	}

	@PostMapping("/findEmailByid")
	public ApiResponse<Optional<EmailReceiver>> findById(@RequestBody EmailReceiver emailReceiver) {
		Optional<EmailReceiver> result = emailReceiverService.findById(emailReceiver.getAutincId());
		if (result.isPresent()) {
			return ApiResponse.success(result);
		} else {
			return ApiResponse.error("100001", "查询无返回记录");
		}
	}

	@PostMapping("/findEmailByAny")
	public List<EmailReceiver> findEmailByAny(@RequestBody EmailReceiver emailReceiver) {
		return emailReceiverService.selectEmail(emailReceiver);
	}

}
