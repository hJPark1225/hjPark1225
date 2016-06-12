package org.kedu.persistence;

import java.util.List;

import org.kedu.domain.GuidewordVO;

public interface GuidewordDAO {
	
	public void create(GuidewordVO vo)throws Exception;
	
	public GuidewordVO read(Integer gno)throws Exception;
	
	public void delete(Integer keyword_id)throws Exception;
	
	public List<GuidewordVO> listAllByKeyword(Integer keyword_id)throws Exception;
	
}
