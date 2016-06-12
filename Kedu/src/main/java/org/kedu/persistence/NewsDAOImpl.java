package org.kedu.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kedu.domain.Criteria;
import org.kedu.domain.NewsVO;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Inject
	private SqlSession session;
	
	private static final String NAMESPACE = "org.kedu.mapper.NewsMapper";
	
	@Override
	public void create(NewsVO vo) throws Exception {
		
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public NewsVO read(Integer nid) throws Exception {

		return session.selectOne(NAMESPACE + ".read", nid);
	}

	@Override
	public void update(NewsVO vo) throws Exception {

		session.update(NAMESPACE + ".update", vo);
	}

	@Override
	public void delete(Integer nid) throws Exception {

		session.delete(NAMESPACE + ".delete", nid);
	}

	@Override
	public List<NewsVO> listAll() throws Exception {

		return session.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public void updateImage(NewsVO vo) throws Exception {
		
		session.update(NAMESPACE + ".updateImage", vo);
	}

	@Override
	public List<NewsVO> listPage(int page) throws Exception {

		if(page <= 0){
			page =1;
		}
		
		page = (page -1) * 8;
		
		return session.selectList(NAMESPACE + ".listPage", page);
	}


	@Override
	public List<NewsVO> listCriteria(Criteria cri) throws Exception {
		
		return session.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public List<NewsVO> listAllByKeyword(Integer kno) throws Exception {
		
		return session.selectList(NAMESPACE + ".listAllByKeyword", kno);
	}

	@Override
	public List<NewsVO> listUrlByKeyword(Integer kno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + ".listUrlByKeyword", kno);
	}

	@Override
	public void updateScore(NewsVO vo) throws Exception {
		session.update(NAMESPACE + ".updateScore", vo);
		
	}
	
	
	

}
