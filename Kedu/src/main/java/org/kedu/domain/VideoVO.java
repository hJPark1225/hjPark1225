package org.kedu.domain;

import java.util.Date;

public class VideoVO {
	/*
	vid INT NOT NULL AUTO_INCREMENT,
	url VARCHAR(100) NOT NULL,
	title VARCHAR(20) NOT NULL,
	regdate TIMESTAMP NOT NULL DEFAULT now(),
	keyword_id INT NOT NULL,
	thumbnail_url VARCHAR(100) NOT NULL,
	crawling BOOLEAN NOT NULL,*/
	
	private Integer vid;
	private String url;
	private String title;
	private Date moddate;
	private String thumbnail_url;
	private boolean crawling;
	private Integer keyword_id;
	
	public Integer getKeyword_id() {
		return keyword_id;
	}
	public void setKeyword_id(Integer keyword_id) {
		this.keyword_id = keyword_id;
	}
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getModdate() {
		return moddate;
	}
	
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public boolean isCrawling() {
		return crawling;
	}
	public void setCrawling(boolean crawling) {
		this.crawling = crawling;
	}
	@Override
	public String toString() {
		return "VideoVO [vid=" + vid + ", url=" + url + ", title=" + title + ", moddate=" + moddate + ", thumbnail_url="
				+ thumbnail_url + ", crawling=" + crawling + ", keyword_id=" + keyword_id + "]";
	}

	
	
}
