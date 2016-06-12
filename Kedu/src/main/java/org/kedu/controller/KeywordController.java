package org.kedu.controller;

import java.util.List;

import javax.inject.Inject;

import org.kedu.domain.Criteria;
import org.kedu.domain.GuidewordVO;
import org.kedu.domain.KeywordVO;
import org.kedu.domain.PageMaker;
import org.kedu.service.GuidewordService;
import org.kedu.service.KeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snu.ids.ha.index.Keyword;
import org.snu.ids.ha.index.KeywordExtractor;
import org.snu.ids.ha.index.KeywordList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/keyword/*")
public class KeywordController {

	private static final Logger logger = LoggerFactory.getLogger(KeywordController.class);
	
	@Inject
	private KeywordService service;
	
	@Inject
	private GuidewordService gService;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET(KeywordVO keyword, Model model)throws Exception{
		
		logger.info("register get........");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(KeywordVO keyword, RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post...........");
		logger.info(keyword.toString());
		
		service.regist(keyword);
		//extrtGrd(keyword);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/keyword/listPage";
	}
	
	@RequestMapping(value = "/extract", method = RequestMethod.GET)
	public String extracGuideword(Model model)throws Exception{
		
		List<KeywordVO> keywords= service.listAll();
		
		for(KeywordVO keyword : keywords){
			
			if(!keyword.isExtracting()){
				
				String strToExtrtKwrd = keyword.getWord();

				KeywordExtractor ke = new KeywordExtractor();
				KeywordList kl = ke.extractKeyword(strToExtrtKwrd, true);
				for( int i = 0; i < kl.size(); i++ ) {
					Keyword kwrd = kl.get(i);
					//System.out.println(kwrd.getString() + "\t" + kwrd.getCnt());
					GuidewordVO gvo = new GuidewordVO();
					gvo.setGuideword(kwrd.getString());
					gvo.setKeyword_id(keyword.getKno());
					gService.regist(gvo);
				}
				
				keyword.setExtracting(true);
				service.updateExtracting(keyword);
			}
		}
		
		return "redirect:/keyword/listPage";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model)throws Exception {
		logger.info("show all list..........");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("kno") int kno, Model model)
		throws Exception {
		model.addAttribute(service.read(kno));
	}
	
	@RequestMapping(value ="/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("kno") int kno,
			RedirectAttributes rttr) throws Exception {
		service.remove(kno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/keyword/listAll";
	}
	
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void keywordListPage(Criteria cri, Model model) throws Exception {

		logger.info("show list Page with Criteria..........");
		//System.out.println(service.listAll());
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {

		logger.info(cri.toString());
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
			
}
