package org.kedu.persistence;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.KeywordVO;


public interface KeywordDAO {
	
	public void create(KeywordVO vo)throws Exception;
	
	public KeywordVO read(Integer kno)throws Exception;
	
	public void update(KeywordVO vo)throws Exception;
	
	public void delete(Integer kno)throws Exception;
	
	public List<KeywordVO> listAll()throws Exception;

	public List<KeywordVO> listPage(int page)throws Exception;
	
	public List<KeywordVO> listCriteria(Criteria cri)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	public void updateCrawling(KeywordVO vo)throws Exception;
	
	public void updateExtracting(KeywordVO vo)throws Exception;
	
}
