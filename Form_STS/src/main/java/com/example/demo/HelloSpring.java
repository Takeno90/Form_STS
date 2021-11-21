package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSpring {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndex(Model model) {
		model.addAttribute("th_greet", "こんにちは！氏名を入力ください");
		return "index";
	}

	@RequestMapping(value="/",method=RequestMethod.POST)
	public String postIndex(@RequestParam("nickname")String nickname,
							@RequestParam("radio_1")String sex,
							@RequestParam("favorite_distribution")String distribution,
							Model model) {
		String sexuality = sex.equals("male") ? "君" : "さん";
		String message = "こんにちは！" + nickname + sexuality + "の好きなディストリビューションは" + distribution + "ですね。";
		model.addAttribute("th_greet",message);
		return "result";
	}


}
