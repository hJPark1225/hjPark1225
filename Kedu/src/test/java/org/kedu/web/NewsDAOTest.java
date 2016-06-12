package org.kedu.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kedu.domain.Criteria;
import org.kedu.domain.NewsVO;
import org.kedu.persistence.NewsDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class NewsDAOTest {
	
	@Inject
	private NewsDAO dao;
	
	@Test
	public void testCreate() throws Exception{
	
		NewsVO news = new NewsVO();
		news.setUrl("http://biz.chosun.com/site/data/html_dir/2016/05/17/2016051700521.html");
		news.setNews_title("전운 감도는 국내 클라우드 시장...아마존, &quot;따라올테면 따라와봐&quot;");
		news.setKeyword_id(2);
		dao.create(news);
	}
	
	@Test
	public void testRead() throws Exception{
	
		System.out.println(dao.read(2).toString());
	}
	
	
	@Test
	public void testDelete() throws Exception{
	
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception{
	
		int page = 4;
		List<NewsVO> list = dao.listPage(page);
		
		for(NewsVO newsVO : list) {
			System.out.println(newsVO.getNid() + ":" + newsVO.getNews_title());
		}
	}

	@Test
	public void testListCriteria()throws Exception{
		
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(8);
		
		List<NewsVO> list = dao.listCriteria(cri);
		
		for(NewsVO newsVO : list){
			System.out.println(newsVO.getNid() + " : " + newsVO.getNews_title());
		}
	}
}
