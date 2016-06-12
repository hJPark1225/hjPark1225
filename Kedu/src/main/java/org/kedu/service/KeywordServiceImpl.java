package org.kedu.service;

import java.util.List;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.KeywordVO;
import org.kedu.persistence.KeywordDAO;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Inject
	private KeywordDAO dao;
	
	@Override
	public void regist(KeywordVO keyword) throws Exception {
		dao.create(keyword);
	}

	@Override
	public KeywordVO read(Integer kno) throws Exception {
		return dao.read(kno);
	}

	@Override
	public void modify(KeywordVO keyword) throws Exception {
		dao.update(keyword);
	}

	@Override
	public void remove(Integer kno) throws Exception {

		dao.delete(kno);
	}

	@Override
	public List<KeywordVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<KeywordVO> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public void updateCrawling(KeywordVO keyword) throws Exception {
		
		dao.updateCrawling(keyword);
	}

	@Override
	public void updateExtracting(KeywordVO vo) throws Exception {
	
		dao.updateExtracting(vo);	
	}

}
