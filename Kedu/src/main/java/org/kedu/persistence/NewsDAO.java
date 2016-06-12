package org.kedu.persistence;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.NewsVO;

public interface NewsDAO {
	
	public void create(NewsVO vo)throws Exception;
	
	public NewsVO read(Integer nid)throws Exception;
	
	public void update(NewsVO vo)throws Exception;
	
	public void updateImage(NewsVO vo) throws Exception;
	
	public List<NewsVO> listUrlByKeyword(Integer kno)throws Exception;
	
	public void updateScore(NewsVO vo) throws Exception;
	
	public void delete(Integer nid)throws Exception;
	
	public List<NewsVO> listAll()throws Exception;
	
	public List<NewsVO> listAllByKeyword(Integer kno)throws Exception;
	
	public List<NewsVO> listPage(int page)throws Exception;
	
	public List<NewsVO> listCriteria(Criteria cri)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	
}
