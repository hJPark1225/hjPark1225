package org.kedu.controller;

import java.util.Locale;

import javax.inject.Inject;

import org.kedu.service.KeywordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private KeywordService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
			
		logger.info("show all list..........");
		model.addAttribute("list", service.listAll());
		
		return "home";
	}
}
