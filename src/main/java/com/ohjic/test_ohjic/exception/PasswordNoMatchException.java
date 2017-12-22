package com.ohjic.test_ohjic.exception;

import com.ohjic.test_ohjic.rest.common.ResponseCode;

public class PasswordNoMatchException extends CommonException {
	/**
	 * 기본 생성자
	 *
	 * @see ResponseCode
	 */
	public PasswordNoMatchException() {
		super(ResponseCode.PASSWORD_NO_MATCH);
	}
}
