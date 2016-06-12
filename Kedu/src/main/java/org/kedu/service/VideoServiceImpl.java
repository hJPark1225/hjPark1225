package org.kedu.service;

import java.util.List;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.VideoVO;
import org.kedu.persistence.VideoDAO;
import org.springframework.stereotype.Service;


@Service
public class VideoServiceImpl implements VideoService {

	@Inject 
	VideoDAO dao;
	
	@Override
	public void regist(VideoVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public VideoVO read(Integer vid) throws Exception {
		return dao.read(vid);
	}

	@Override
	public void modify(VideoVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(Integer vid) throws Exception {
		dao.delete(vid);
	}

	@Override
	public List<VideoVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<VideoVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return dao.countPaging(cri);
	}

	@Override
	public List<VideoVO> listAllByKeyword(Integer kno) throws Exception {

		return dao.listAllByKeyword(kno);
	}
}
