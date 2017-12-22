package com.ohjic.test_ohjic.exception;

import com.ohjic.test_ohjic.rest.common.ResponseCode;

public class IdNoMatchException extends CommonException {
	/**
	 * 기본 생성자
	 *
	 * @see ResponseCode
	 */
	public IdNoMatchException() {
		super(ResponseCode.ID_NO_MATCH);
	}
}
