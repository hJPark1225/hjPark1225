package org.kedu.crawler;

import javax.inject.Inject;

import org.kedu.service.KeywordService;
import org.kedu.service.NewsService;
import org.kedu.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/craw/*")
public class SearchCrawler {

	private static final Logger logger = LoggerFactory.getLogger(SearchCrawler.class);

	@Inject
	private KeywordService kService;

	@Inject
	private NewsService nService;
	
	@Inject
	private VideoService vService;
	
	
}