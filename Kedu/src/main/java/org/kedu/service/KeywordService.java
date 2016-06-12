package org.kedu.service;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.KeywordVO;

public interface KeywordService {
	
	public void regist(KeywordVO keyword)throws Exception;
	
	public KeywordVO read(Integer kno)throws Exception;
	
	public void modify(KeywordVO keyword)throws Exception;
	
	public void remove(Integer kno)throws Exception;
	
	public List<KeywordVO> listAll()throws Exception;

	public List<KeywordVO> listCriteria(Criteria cri)throws Exception;
	
	public int listCountCriteria(Criteria cri)throws Exception;
	
	public void updateCrawling(KeywordVO keyword)throws Exception;
	
	public void updateExtracting(KeywordVO vo) throws Exception;
}
