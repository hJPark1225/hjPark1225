package org.kedu.service;

import java.util.List;

import org.kedu.domain.Criteria;
import org.kedu.domain.VideoVO;

public interface VideoService {
	
	public void regist(VideoVO vo)throws Exception;
	
	public VideoVO read(Integer vid)throws Exception;
	
	public void modify(VideoVO vo)throws Exception;
	
	public void remove(Integer vid)throws Exception;
	
	public List<VideoVO> listAll()throws Exception;
	
	public List<VideoVO> listCriteria(Criteria cri)throws Exception;
	
	public int listCountCriteria(Criteria cri)throws Exception;
	
	public List<VideoVO> listAllByKeyword(Integer kno)throws Exception;

}
