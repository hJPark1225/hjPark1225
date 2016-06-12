package org.kedu.service;

import java.util.List;

import javax.inject.Inject;

import org.kedu.domain.GuidewordVO;
import org.kedu.persistence.GuidewordDAO;
import org.springframework.stereotype.Service;

@Service
public class GuidewordServiceImpl implements GuidewordService {

	@Inject
	private GuidewordDAO dao;
	
	@Override
	public void regist(GuidewordVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public GuidewordVO read(Integer gno) throws Exception {
		return dao.read(gno);
	}

	@Override
	public void remove(Integer keyword_id) throws Exception {
		dao.delete(keyword_id);
	}

	@Override
	public List<GuidewordVO> listAllByKeyword(Integer keyword_id) throws Exception {
		return dao.listAllByKeyword(keyword_id);
	}

}
