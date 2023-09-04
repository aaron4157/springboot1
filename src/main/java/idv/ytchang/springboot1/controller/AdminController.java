package idv.ytchang.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("")
	@ResponseBody
	public String index(Model model) {
		return "site: /admin";
	}

}
