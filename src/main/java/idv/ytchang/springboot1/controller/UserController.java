package idv.ytchang.springboot1.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("")
	public String index(Model model) {
		
		model.addAttribute("now", new Date());
		return "user/index";
	}
}
