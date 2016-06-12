package org.kedu.domain;

public class GuidewordVO {
	
	private Integer gno;
	private Integer keyword_id; // 키워드 번호
	private String guideword; // 색인어
	
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	
	public String getGuideword() {
		return guideword;
	}
	public void setGuideword(String guideword) {
		this.guideword = guideword;
	}
	public Integer getKeyword_id() {
		return keyword_id;
	}
	public void setKeyword_id(Integer keyword_id) {
		this.keyword_id = keyword_id;
	}
	
	@Override
	public String toString() {
		return "GuidewordVO [gno=" + gno + ", keyword_id=" + keyword_id + ", guideword=" + guideword + "]";
	}
}
