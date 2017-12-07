package com.ohjic.test_ohjic.controller.restController.common;

/**
 * 응답 코드
 */
public enum ResponseCode {
	SUCCESS("SUCC00", ""),
	UNKOWN("ERR0000", "알 수 없는 오류입니다.")
	;

	/**
	 * 응답 코드
	 */
	private String code;

	/**
	 * 응답 메세지
	 */
	private String message;

	/**
	 * 기본 생성자
	 *
	 * @param code - 응답 코드
	 * @param message - 응답 메세지
	 */
	ResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 응답 코드 반환
	 *
	 * @return 응답 코드
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 응답 메세지 반환
	 *
	 * @return 응답 메세지
	 */
	public String getMessage() {
		return message;
	}

	public static ResponseCode getResponseCodeByCode(String code) {
		ResponseCode[] values = ResponseCode.values();
		
		for (ResponseCode responseCode : values) {
			if(responseCode.getCode().equals(code)) {
				return responseCode;
			}
		}
		
		return null;
	}
}
