package org.kedu.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kedu.domain.MemberVO;
import org.kedu.persistence.MemberDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void test1() {
		
		System.out.println(dao);
	}
	
	@Test
	public void test2() {
		
		System.out.println(dao.getTime());
	}
	
	@Test
	public void insertTest() throws Exception{
		
		for(int i = 0; i<=100; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("user" + i);
			vo.setUserpw("user" + i);
			vo.setUsername("USER" + i);
			vo.setEmail("user" + i + "@aaa.com");
		
			dao.insertMember(vo);
		}
	}
}
