package com.ohjic.test_ohjic.search.type;

/**
 * 모든 게시판에서 검색 유형을 관리하는 Enum 클래스
 * @author ohjic
 *
 */
public enum SBoardSizeType implements SType {
	// getName() (getVname(), getSvalue()) 형태
	이십개("20개씩", "20"),
	사십개("40개씩", "40"),
	육십개("60개씩", "60"),
	팔십개("80개씩", "80"),
	백개("100개씩", "100")
	;
	
	String vName;
	String sValue;

	SBoardSizeType(String vName, String sValue) {
		this.vName = vName;
		this.sValue = sValue;
	}
	
	@Override
	public String getName() {
		return name(); // CONTENT
	}

	@Override
	public String getVName() {
		return vName; // "내용"
	}
	
	@Override
	public String getSValue() {
		return sValue; // "content"
	}
}
