package org.kedu.web;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	private static final Logger logger =
			LoggerFactory.getLogger(SampleController.class);
	
/*
	@RequestMapping("/doA")
	public Callable<String> callableWithView(final Model model) {
		  return new Callable<String>() {
		    @Override
		    public String call() throws Exception {
		      Thread.sleep(2000);
		      model.addAttribute("movie", "a");
		      return "/doA";
		    }
		  };
	}*/
	public void test() {System.out.println("gaha");
	}
	/*
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		
		logger.info("doC called......");
		logger.info("MSG : " + msg);
		return "result";
	}
	
	
	@RequestMapping("/doD")
	public void doD(Model model){
		ProductVO vo = new ProductVO();
		vo.setName("sample");
		vo.setPrice(30000);
		
		//model.addAttribute("vo", vo);
		model.addAttribute(vo); // -> productVo
	}
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr){
		logger.info("doE called but redirect to /doF.............");
		
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected");
		return "redirect:/doF";
	}
	
	@RequestMapping("/doF")
	public void doF(String msg){
		
		logger.info("doF called..............."+ msg);
	}
	
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON(){
		ProductVO vo = new ProductVO();
		vo.setName("sample");
		vo.setPrice(30000);
		
		return vo;
	}*/
	
	
}
