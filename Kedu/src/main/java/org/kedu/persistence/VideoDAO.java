package org.kedu.persistence;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.VideoVO;

public interface VideoDAO {

	public void create(VideoVO vo)throws Exception;
	
	public VideoVO read(Integer vid)throws Exception;
	
	public void update(VideoVO vo)throws Exception;
	
	public void delete(Integer vid)throws Exception;
	
	public List<VideoVO> listAll()throws Exception;
	
	public List<VideoVO> listAllByKeyword(Integer kno)throws Exception;
	
	public List<VideoVO> listPage(int page)throws Exception;
	
	public List<VideoVO> listCriteria(Criteria cri)throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
	
	
}
