package idv.ytchang.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Springboot1Controller {

	public Springboot1Controller() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("")
	@ResponseBody
	public String index(Model model) {
		return "HOMEPAGE!";
	}
	
	@RequestMapping("welcome")
	@ResponseBody
	public String welcome(Model model) {
		return "Welcome!";
	}

}
