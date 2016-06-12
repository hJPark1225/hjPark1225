package org.kedu.persistence;

import org.kedu.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	
	public void insertMember(MemberVO vo) throws Exception;

}
