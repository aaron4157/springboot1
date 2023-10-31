package idv.ytchang.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Springboot1Controller {

	public Springboot1Controller() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("")
	public String index(Model model) {
		
		model.addAttribute("sidepanel_active", "index");
		return "index";
	}
	
	@RequestMapping("about")
	public String welcome(Model model) {
		
		model.addAttribute("body_class", "inner_page");
		model.addAttribute("sidepanel_active", "about");
		return "about";
	}
	
	@RequestMapping("birds")
	public String birds(Model model) {
		
		model.addAttribute("body_class", "inner_page");
		model.addAttribute("sidepanel_active", "birds");
		return "birds";
	}
	
	@RequestMapping("testimonial")
	public String testimonial(Model model) {
		
		model.addAttribute("body_class", "inner_page");
		model.addAttribute("sidepanel_active", "testimonial");
		return "testimonial";
	}

	@RequestMapping("contact")
	public String contact(Model model) {
		
		model.addAttribute("body_class", "inner_page");
		model.addAttribute("sidepanel_active", "contact");
		return "contact";
	}
	
	@RequestMapping("blank")
	public String text(Model model) {
		
		model.addAttribute("body_class", "inner_page");
		model.addAttribute("sidepanel_active", "blank");
		return "blank";
	}
}
