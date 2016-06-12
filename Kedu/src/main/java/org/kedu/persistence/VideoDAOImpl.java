package org.kedu.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kedu.domain.Criteria;
import org.kedu.domain.VideoVO;
import org.springframework.stereotype.Repository;

@Repository
public class VideoDAOImpl implements VideoDAO {

	@Inject
	private SqlSession session;
	
	private static final String NAMESPACE = "org.kedu.mapper.VideoMapper";
	
	
	@Override
	public void create(VideoVO vo) throws Exception {
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public VideoVO read(Integer vid) throws Exception {
		
		return session.selectOne(NAMESPACE + ".read", vid);
	}

	@Override
	public void update(VideoVO vo) throws Exception {
		
		session.update(NAMESPACE + ".update", vo);}

	@Override
	public void delete(Integer vid) throws Exception {

		session.delete(NAMESPACE + ".delete", vid);
	}

	@Override
	public List<VideoVO> listAll() throws Exception {
		
		return session.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<VideoVO> listPage(int page) throws Exception {
		
		if(page <= 0){
			page =1;
		}
		
		page = (page -1) * 8;
		
		return session.selectList(NAMESPACE + ".listPage", page);
		
	}

	@Override
	public List<VideoVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return session.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<VideoVO> listAllByKeyword(Integer kno) throws Exception {
		
		return session.selectList(NAMESPACE + ".listAllByKeyword", kno);
	}
		
}
