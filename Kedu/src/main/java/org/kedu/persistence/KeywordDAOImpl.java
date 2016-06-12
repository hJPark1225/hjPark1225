package org.kedu.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kedu.domain.Criteria;
import org.kedu.domain.KeywordVO;
import org.springframework.stereotype.Repository;

@Repository
public class KeywordDAOImpl implements KeywordDAO {

	@Inject
	private SqlSession session;
	private static String NAMESPACE ="org.kedu.mapper.KeywordMapper";
	
	@Override
	public void create(KeywordVO vo) throws Exception {
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public KeywordVO read(Integer kno) throws Exception {
		return session.selectOne(NAMESPACE + ".read", kno);
	}

	@Override
	public void update(KeywordVO vo) throws Exception {
		session.update(NAMESPACE + ".updateWord", vo);
	}

	@Override
	public void delete(Integer kno) throws Exception {

		session.delete(NAMESPACE + ".delete", kno);
	}

	@Override
	public List<KeywordVO> listAll() throws Exception {
	
		return session.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<KeywordVO> listPage(int page) throws Exception {

		if(page <= 0){
			page =1;
		}
		
		page = (page -1) * 8;
		
		return session.selectList(NAMESPACE + ".listPage", page);
	}

	@Override
	public List<KeywordVO> listCriteria(Criteria cri) throws Exception {

		return session.selectList(NAMESPACE + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {

		return session.selectOne(NAMESPACE + ".countPaging", cri);
	}

	@Override
	public void updateCrawling(KeywordVO vo) throws Exception {

		session.update(NAMESPACE + ".updateCrawling", vo);
		
	}

	@Override
	public void updateExtracting(KeywordVO vo) throws Exception {
		
		session.update(NAMESPACE + ".updateExtracting", vo);
	}

}
