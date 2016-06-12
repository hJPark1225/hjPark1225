package org.kedu.controller;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.PageMaker;
import org.kedu.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/news/*")
public class NewstController {

	private static final Logger logger = LoggerFactory.getLogger(NewstController.class);

	@Inject
	private NewsService service;

		
	@RequestMapping(value = "/listAll/{kno}", method = RequestMethod.GET)
	public String newsListAll(Model model, @PathVariable("kno") int kno) throws Exception {

		logger.info("show all list..........");
		System.out.println(service.listAll());
		model.addAttribute("list", service.listAllByKeyword(kno));
		
		return "/news/listAll";
	}
	

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void newsListPage(Criteria cri, Model model) throws Exception {

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
		
		return "/news/listPage";
	}
	
	/*
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * String registPOST(KeywordVO keyword, RedirectAttributes rttr)throws
	 * Exception{
	 * 
	 * logger.info("regist post..........."); logger.info(keyword.toString());
	 * 
	 * service.regist(keyword);
	 * 
	 * rttr.addFlashAttribute("msg", "SUCCESS"); return
	 * "redirect:/keyword/listAll"; }
	 * 
	 * @RequestMapping(value = "/listAll", method = RequestMethod.GET) public
	 * void listAll(Model model)throws Exception { logger.info(
	 * "show all list.........."); model.addAttribute("list",
	 * service.listAll()); }
	 * 
	 * @RequestMapping(value = "/read", method = RequestMethod.GET) public void
	 * read(@RequestParam("kno") int kno, Model model) throws Exception {
	 * model.addAttribute(service.read(kno)); }
	 * 
	 * @RequestMapping(value ="/remove", method = RequestMethod.POST) public
	 * String remove(@RequestParam("kno") int kno, RedirectAttributes rttr)
	 * throws Exception { service.remove(kno);
	 * 
	 * rttr.addFlashAttribute("msg", "SUCCESS");
	 * 
	 * return "redirect:/keyword/listAll"; }
	 */

}
