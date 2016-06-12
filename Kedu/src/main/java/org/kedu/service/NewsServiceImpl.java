package org.kedu.service;

import java.util.List;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.NewsVO;
import org.kedu.persistence.NewsDAO;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

	@Inject 
	NewsDAO dao;
	
	@Override
	public void regist(NewsVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public NewsVO read(Integer nid) throws Exception {
		return dao.read(nid);
	}

	@Override
	public void modify(NewsVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer nid) throws Exception {
		dao.delete(nid);
	}

	@Override
	public List<NewsVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<NewsVO> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {

		return dao.countPaging(cri);
	}

	@Override
	public List<NewsVO> listAllByKeyword(Integer kno) throws Exception {

		return dao.listAllByKeyword(kno);
	}

	@Override
	public List<NewsVO> listUrlByKeyword(Integer kno) throws Exception {
		return dao.listUrlByKeyword(kno);
	}

	@Override
	public void updateScore(NewsVO vo) throws Exception {
		dao.updateScore(vo);
	}


}
