package org.kedu.service;

import java.util.List;

import org.kedu.domain.GuidewordVO;

public interface GuidewordService {
	
	public void regist(GuidewordVO vo)throws Exception;
	
	public GuidewordVO read(Integer gno)throws Exception;
	
	public void remove(Integer keyword_id)throws Exception;
	
	public List<GuidewordVO> listAllByKeyword(Integer keyword_id)throws Exception;

}
