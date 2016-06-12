package org.kedu.domain;

import java.util.Date;

public class NewsVO {
	
/*	nid INT NOT NULL AUTO_INCREMENT,
	url VARCHAR(50) NOT NULL,
	title VARCHAR(50) NOT NULL,
	moddate TIMESTAMP NOT NULL DEFAULT now(),
	crawling BOOLEAN NOT NULL DEFAULT false,
*/
	private Integer nid;
	private String url;
	private String news_title;
	private Date moddate;
	private boolean crawling;
	
/*	keyword_id INT NOT NULL,
	thumbnail_name VARCHAR(40),
	thumbnail_flag BOOLEAN,
	contents VARCHAR(100) NOT NULL,*/
	
	private Integer keyword_id;
	private boolean thumbnail_flag;
	private String thumbnail_url;
	private String contents;
	private double score;
	

	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getKeyword_id() {
		return keyword_id;
	}
	public void setKeyword_id(Integer keyword_id) {
		this.keyword_id = keyword_id;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public Date getModdate() {
		return moddate;
	}
	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}
	public boolean isCrawling() {
		return crawling;
	}
	public void setCrawling(boolean crawling) {
		this.crawling = crawling;
	}
	
	public boolean isThumbnail_flag() {
		return thumbnail_flag;
	}
	public void setThumbnail_flag(boolean thumbnail_flag) {
		this.thumbnail_flag = thumbnail_flag;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	@Override
	public String toString() {
		return "NewsVO [nid=" + nid + ", url=" + url + ", news_title=" + news_title + ", moddate=" + moddate
				+ ", crawling=" + crawling + ", keyword_id=" + keyword_id + ", thumbnail_flag=" + thumbnail_flag
				+ ", thumbnail_url=" + thumbnail_url + ", contents=" + contents + ", score=" + score + "]";
	}

}
