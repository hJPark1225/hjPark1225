package org.kedu.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kedu.domain.GuidewordVO;
import org.springframework.stereotype.Repository;

@Repository
public class GuidewordDAOImpl implements GuidewordDAO {

	@Inject
	private SqlSession session;
	private static String NAMESPACE = "org.kedu.mapper.GuidewordMapper";
	
	@Override
	public void create(GuidewordVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(NAMESPACE + ".create", vo);
	}

	@Override
	public GuidewordVO read(Integer gno) throws Exception {
		
		return session.selectOne(NAMESPACE + ".read", gno);
	}

	@Override
	public void delete(Integer keyword_id) throws Exception {
		
		session.delete(NAMESPACE + ".delete", keyword_id);
	}

	@Override
	public List<GuidewordVO> listAllByKeyword(Integer keyword_id) throws Exception {
		
		return session.selectList(NAMESPACE + ".listAllByKeyword", keyword_id);
	}

}
