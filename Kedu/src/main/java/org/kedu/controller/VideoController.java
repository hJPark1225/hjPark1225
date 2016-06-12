package org.kedu.controller;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.PageMaker;
import org.kedu.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/video/*")
public class VideoController {

	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	@Inject
	private VideoService service;
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void videoListAll(Model model) throws Exception {

		logger.info("show all list..........");
		//System.out.println(service.listAll());
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void videoListPage(Criteria cri, Model model) throws Exception {

		logger.info("show list Page with Criteria..........");
		//System.out.println(service.listAll());
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage/{kno}", method = RequestMethod.GET)
	public String listPage(Criteria cri, Model model, @PathVariable("kno") int kno) throws Exception {

		logger.info(cri.toString());
		cri.setKno(kno);
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("kno", kno);
		
		return "/video/listPage";
	}
}
