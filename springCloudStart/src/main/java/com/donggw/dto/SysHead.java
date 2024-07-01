package com.donggw.dto;

import lombok.Data;

@Data
public class SysHead {

	String errorCode;
	String errorMessage;

	public SysHead(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

}
