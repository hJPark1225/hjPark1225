package org.kedu.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.kedu.domain.GuidewordVO;
import org.kedu.domain.KeywordVO;
import org.kedu.domain.NewsVO;
import org.kedu.domain.TF_IDF;
import org.kedu.domain.VideoVO;
import org.kedu.service.GuidewordService;
import org.kedu.service.KeywordService;
import org.kedu.service.NewsService;
import org.kedu.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/crawling/*")
public class CrawlingController {

	private static final Logger logger = LoggerFactory.getLogger(CrawlingController.class);

	@Inject
	private KeywordService kService;

	@Inject
	private NewsService nService;
	
	@Inject
	private VideoService vService;
	
	@Inject
	private GuidewordService gService;
	
	
	@RequestMapping(value = "/collect", method = RequestMethod.GET)
	private String run_test(Model model) throws Exception {

		List<KeywordVO> keywordList = kService.listAll();
		KeywordVO vo;

		ArrayList<String> url_list = new ArrayList<String>();
		ArrayList<Double> score_list = new ArrayList<Double>();

		int page_index = 10;

		for (int i = 0; i < keywordList.size(); i++) {

			vo = keywordList.get(i);
			if (vo.isCrawling() == false) {

				// Ű���忡 ���� ���ξ� ����Ʈ�� Array ����Ʈ�� ���
				List<GuidewordVO> gvoList = gService.listAllByKeyword(vo.getKno());

				if (gvoList == null) {
					return "error";
				}

				ArrayList<String> guidewordList = new ArrayList<String>();
				for (int k = 0; k < gvoList.size(); k++) {
					guidewordList.add(gvoList.get(k).getGuideword());
				}

				// ���ϴ� ������ ��ŭ ������ ���� ���� url�� ������.
				for (int j = 1; j <= page_index + 1; j++) {

					String keyword = URLEncoder.encode(vo.getWord(), "UTF-8"); // ����������
					String url = "http://news.naver.com/main/search/search.nhn?query=" + keyword
							+ "&display=10&start=1&target=webkr&sm=top_hty&fbm=1&ie=utf8&page=" + page_index;

					Document doc = Jsoup.connect(url).timeout(30000).get();
					Elements search_lst = doc.getElementsByClass("srch_lst");

					for (Element link : search_lst) {

						Elements els = link.getElementsByTag("a"); // a�±� ����

						for (Element el : els) {

							if (el.attr("data-url") != "") {

								url_list.add(el.attr("data-url"));
							}
						}

						// url_list.addAll(crawlingNewsTest(vo.getKno(),
						// vo.getWord(),j));
					}

					//score_list = calcTfIdF(url_list, guidewordList);

					if (metadataCrawlingRun(vo.getKno(), url_list)){ // score_list)) {
						vo.setCrawling(true);
						kService.updateCrawling(vo);
					}
				}
			}

		}
		return "redirect:/?page=1&perPageNum=8?tab=news";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	private String tf_idf_test(Model model) throws Exception {

		List<KeywordVO> keywordList = kService.listAll();
		
		ArrayList<Double> score_list = new ArrayList<Double>();
		
		for(int i = 0; i<keywordList.size(); i++){
			
			KeywordVO vo = keywordList.get(i);
			List<GuidewordVO> gvoList = gService.listAllByKeyword(vo.getKno());
			List<NewsVO> newsList = nService.listUrlByKeyword(vo.getKno());
			
			if(vo.isExtracting()){
				
				ArrayList<String> guidewordList = new ArrayList<String>();
				for (int k = 0; k < gvoList.size(); k++) {
					guidewordList.add(gvoList.get(k).getGuideword());
				}

				ArrayList<String> url_list = new ArrayList<String>();
				for(int l = 0; l<newsList.size(); l++){
					url_list.add(newsList.get(l).getUrl());
				}
				score_list = calcTfIdF(url_list, guidewordList);
				
				for(int j = 0; j<newsList.size(); j++){
					
					NewsVO nvo = newsList.get(j);
					nvo.setScore(score_list.get(i));
					nService.updateScore(nvo);
				}
			}
			
		}
		return "redirect:/?page=1&perPageNum=8?tab=news";
	}
		
	
	private boolean metadataCrawlingRun(Integer kno, ArrayList<String> urlList){
		
		for(int i =0; i<urlList.size(); i++){
			
			Document doc;
			try {
				
				NewsVO vo = new NewsVO();
				String url = urlList.get(i);
				//double score = scoreList.get(i);
				//double score = 0;
				doc = Jsoup.connect(url).timeout(30000).get();
				String title = "";
				Elements metaOgTitle = doc.select("meta[property=og:title]");
				if (metaOgTitle != null) {
					title = metaOgTitle.attr("content");
				} else {
					title = doc.title();
				}
				
				String imageUrl = "";
				Elements metaOgImage = doc.select("meta[property=og:image]");
				if (metaOgImage != null) {
					imageUrl = metaOgImage.attr("content");
				}

				String description = "";
				Elements metaOgDescription = doc.select("meta[property=og:description]");
				if (metaOgDescription != null) {
					description = metaOgDescription.attr("content");
				}
				
				if(title == ""){
					continue;
				}
				else if(imageUrl == "" && description == "")
					continue;
				
				vo.setUrl(url);
				vo.setNews_title(title);
				vo.setKeyword_id(kno);
				
				if(imageUrl == ""){
					vo.setThumbnail_flag(false);
				}
				else{
					vo.setThumbnail_flag(true);
					vo.setThumbnail_url(imageUrl);
				}
				
				String temp = "";
				if(description.length() > 190) {
					temp = description.substring(0, 170) + "...";
					description = temp;
				}
				vo.setContents(description);
				vo.setCrawling(true);
				//vo.setScore(score);
				try {
					nService.regist(vo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
		return true;
	}

	private ArrayList<Double> calcTfIdF(ArrayList<String> urlList, ArrayList<String> gwordList) {

		ArrayList<String> documentList = new ArrayList<String>();
		for (int i = 0; i < urlList.size(); i++) {

			Document doc;
			try {
				doc = Jsoup.connect((String) urlList.get(i)).timeout(30000).get();
				
				String contents = doc.body().text();

				if (contents != "")
					documentList.add(contents);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ArrayList<String> wordList = new ArrayList<String>();
		
		TF_IDF tf_idf = new TF_IDF(documentList);

		for (String s : tf_idf.getWordVector()) {
			wordList.add(s); 	// Ű���� ������ ��. index�� Ű������ ���̵�
		}
		
		ArrayList docDataList = new ArrayList();	//��ť��Ʈ�� ���� ����Ʈ�� ��� ����Ʈ

		for (double[] docV : tf_idf.getTF_IDFMatrix()) {

			ArrayList<Double> point_list = new ArrayList<Double>();
		
			for (double v : docV) {
				point_list.add(v);	//Ű���� �� tf-idf ��
			}
			docDataList.add(point_list);
		}

		//Ű���� �� ���̵���带 �����ϴ� �ε����� ��� ����	
		ArrayList<Integer> keywordIndexList = new ArrayList<Integer>();
				
		//Ű���� �� ���̵���带 �����ϴ� ���� ã�� ����
		for (int i = 0; i < wordList.size(); i++) {	

			String word_temp = wordList.get(i);
			
			for(int j =0; j < gwordList.size(); j++ ){
				
				if (word_temp.contains(gwordList.get(j))) {
					keywordIndexList.add(j);
				}
			}
		}

		//��ť��Ʈ �� �� ���̵���带 �����ϴ� �ܾ���� tf-idf ���� ��� ����Ʈ
		ArrayList<Double> docSumPointList = new ArrayList<Double>();
		
		//ArrayList<Double> point_list = new ArrayList<Double>();

		for (int i = 0; i < docDataList.size(); i++) {

			
			ArrayList<Double> tempDataList = new ArrayList<Double>();
			tempDataList = (ArrayList) docDataList.get(i);

			double sum = 0;
			//��ť��Ʈ �� �� ���̵���带 �����ϴ� �ܾ���� tf-idf ���� ���ϴ� ����
			for (int j = 0; j < keywordIndexList.size(); j++) {

				Integer index = keywordIndexList.get(j);
				sum += tempDataList.get(index);
			}

			docSumPointList.add(sum);
		}

		return docSumPointList;
	}

	private void crawingNews(Integer kno, String s_keyword, Integer page) throws Exception {
		
		try {

			String keyword = URLEncoder.encode(s_keyword, "UTF-8"); // ����������
																	// �ѱ����ڵ�
			String url = "http://news.naver.com/main/search/search.nhn?query=" + keyword
					+ "&display=10&start=1&target=webkr&sm=top_hty&fbm=1&ie=utf8&page=" + page.toString();

			Document doc = Jsoup.connect(url).timeout(30000).get();	
			
			Elements links = doc.getElementsByClass("srch_lst");
			
			for (Element link : links) {
				String dsc_t = link.select("p.dsc").first().text();
				String dsc = dsc_t.replace("\"", "'");
				Element img = link.select("img").first();
				
				NewsVO vo = new NewsVO();
				vo.setKeyword_id(kno);
				
				if(img != null) {
					String img_url = img.attr("src").replace("/thumb80", "/thumb");
					vo.setThumbnail_flag(true);
					vo.setThumbnail_url(img_url);;
				}
				else
					vo.setThumbnail_flag(false);
				
				Elements els = link.getElementsByTag("a"); // a�±� ����
				
				for (Element el : els) {

					if (el.attr("data-url") != "") {

						String tit =  el.attr("data-title").replace("\"", "'");
						vo.setNews_title(tit);
						vo.setCrawling(true);
						vo.setUrl(el.attr("data-url"));
						if(dsc.toString().length() > 190)
							vo.setContents(dsc.toString().substring(0, 170) + "...");
						
						vo.setContents(dsc.toString());
						nService.regist(vo);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void crawingVideo(Integer kno, String s_keyword, Integer Page) throws Exception {
		
		try {

			String keyword = URLEncoder.encode(s_keyword, "UTF-8"); // ����������
																	// �ѱ����ڵ�
			
			String url = "https://www.youtube.com/results?search_query=" + keyword
					+ "&sp=EgIQAQ%253D%253D" + "&page=" + Page.toString();
		
			Document doc = Jsoup.connect(url).timeout(30000).get();

			Elements links = doc.getElementsByClass("item-section").first().select("div.yt-lockup");

			for (Element item : links) {
				String id = item.attr("data-context-item-id");
				String title = item.select("h3").first().select("a").attr("title");
				
				VideoVO vo = new VideoVO();
				vo.setKeyword_id(kno);
				
				vo.setUrl("https://www.youtube.com/watch?v=" + id);
				vo.setTitle(title);
				vo.setThumbnail_url("http://i1.ytimg.com/vi/" + id + "/sddefault.jpg");
				vo.setCrawling(true);
				vService.regist(vo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@RequestMapping(value = "/start")
	private String run() throws Exception {

		List<KeywordVO> keywordList = kService.listAll();
		KeywordVO vo;
		

		for (int i = 0; i < keywordList.size(); i++) {

			vo = keywordList.get(i);
			if (vo.isCrawling() == false) {
				
				for(int j = 1; j<=1; j++){
				crawingNews(vo.getKno(), vo.getWord(), j);
				crawingVideo(vo.getKno(), vo.getWord(), j);
				vo.setCrawling(true);
				kService.updateCrawling(vo);
				}
			}
		}
		
		return "redirect:/?page=1&perPageNum=8";
	}
	
	
	@RequestMapping(value = "/video")
	private String videoCrawling() throws Exception {

		List<KeywordVO> keywordList = kService.listAll();
		KeywordVO vo;
		

		for (int i = 0; i < keywordList.size(); i++) {

			vo = keywordList.get(i);
			if (vo.isCrawling() == false) {
				crawingVideo(vo.getKno(), vo.getWord(), 3);
				vo.setCrawling(true);
				kService.updateCrawling(vo);
			}
		}
		
		return "redirect:/?page=1&perPageNum=8";
	}

	
	private ArrayList<String> metadataCrawling(Integer page) throws Exception {

		ArrayList<String> linkList = new ArrayList();
		
			String keyword = URLEncoder.encode("Ŭ������ǻ��", "UTF-8"); // ����������
			//Integer page = 1;														// �ѱ����ڵ�
			String url = "http://news.naver.com/main/search/search.nhn?query=" + keyword
					+ "&display=10&start=1&target=webkr&sm=top_hty&fbm=1&ie=utf8&page=" + page.toString();

			Document doc = Jsoup.connect(url).timeout(30000).get();
			
			Element links = doc.getElementsByClass("srch_lst").first();
			
			Elements els = links.getElementsByTag("a"); // a�±� ����
			//System.out.println(els);
				
			for (Element el : els) {

				if (el.attr("data-url") != "") {

					linkList.add(el.attr("data-url"));	
				}
			}
	
			return linkList;
	}
	

	


}
