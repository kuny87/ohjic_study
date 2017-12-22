package com.ohjic.test_ohjic.exception;

import com.ohjic.test_ohjic.rest.common.ResponseCode;

public class IdDuplicatedException extends CommonException {
	/**
	 * 기본 생성자
	 *
	 * @see ResponseCode
	 */
	public IdDuplicatedException() {
		super(ResponseCode.ID_DUPLICATED);
	}
}
