package org.kedu.service;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.NewsVO;

public interface NewsService {

	public void regist(NewsVO vo)throws Exception;
	
	public NewsVO read(Integer nid)throws Exception;
	
	public void modify(NewsVO vo)throws Exception;
	
	public void remove(Integer nid)throws Exception;
	
	public List<NewsVO> listAll()throws Exception;
	
	public List<NewsVO> listCriteria(Criteria cri)throws Exception;
	
	public int listCountCriteria(Criteria cri)throws Exception;
	
	public List<NewsVO> listAllByKeyword(Integer kno)throws Exception;
	
	public List<NewsVO> listUrlByKeyword(Integer kno)throws Exception;
	
	public void updateScore(NewsVO vo) throws Exception;

}
