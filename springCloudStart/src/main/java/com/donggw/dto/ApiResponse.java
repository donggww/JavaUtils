package com.donggw.dto;

import lombok.Data;

import static com.donggw.SpringContants.SUCCESS_CODE;
import static com.donggw.SpringContants.SUCCESS_MESSAGE;

@Data
public class ApiResponse<T> {

	private SysHead sysHead;

	private T body;

	private ApiResponse(SysHead sysHead, T body) {
		this.sysHead = sysHead;
		this.body = body;
	}

	public static <T> ApiResponse<T> success(T body) {
		SysHead sysHead = new SysHead(SUCCESS_CODE, SUCCESS_MESSAGE);
		return new ApiResponse<>(sysHead, body);
	}

	public static <T> ApiResponse<T> error(String erroeCode, String errorMessage) {
		SysHead sysHead = new SysHead(erroeCode, errorMessage);
		return new ApiResponse<>(sysHead, null);

	}
}
