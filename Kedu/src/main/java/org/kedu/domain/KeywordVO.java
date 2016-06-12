package org.kedu.domain;

import java.util.Date;

public class KeywordVO {
	
	/*
	kno INT NOT NULL AUTO_INCREMENT,
	word VARCHAR(20) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	crawling BOOLEAN NOT NULL,
	*/
	
	private Integer kno;
	private String word;
	private Date regdate;
	private boolean crawling;
	private boolean extracting;
	
	public boolean isExtracting() {
		return extracting;
	}
	public void setExtracting(boolean extracting) {
		this.extracting = extracting;
	}
	public Integer getKno() {
		return kno;
	}
	public void setKno(Integer kno) {
		this.kno = kno;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public boolean isCrawling() {
		return crawling;
	}
	public void setCrawling(boolean crawling) {
		this.crawling = crawling;
	}
	
	@Override
	public String toString() {
		return "KeywordVO [kno=" + kno + ", word=" + word + ", regdate=" + regdate + ", crawling=" + crawling
				+ ", extracting=" + extracting + "]";
	}
	
	
	
	
	
	

}
