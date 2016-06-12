package org.kedu.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kedu.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.kedu.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		
		return sqlSession.selectOne(NAMESPACE+".getTime"); // sqlπÆ ¿Ã∏ß
	}

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		sqlSession.insert(NAMESPACE + ".insertMember", vo); 
	}

}
