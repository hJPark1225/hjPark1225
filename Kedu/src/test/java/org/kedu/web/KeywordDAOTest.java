package org.kedu.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kedu.domain.KeywordVO;
import org.kedu.persistence.KeywordDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class KeywordDAOTest {
	
	@Inject
	private KeywordDAO dao;
	
	@Test
	public void testCreate() throws Exception{
	
		KeywordVO keyword = new KeywordVO();
		keyword.setWord("클라우드");
		keyword.setCrawling(false);
		dao.create(keyword);
	}
	
	@Test
	public void testRead() throws Exception{
	
		System.out.println(dao.read(2).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		
		KeywordVO keyword = new KeywordVO();
		keyword.setKno(1);
		keyword.setWord("클라우드_수정");
		keyword.setCrawling(false);
		dao.update(keyword);
	}
	
	@Test
	public void testDelete() throws Exception{
	
		dao.delete(1);
	}	

}
