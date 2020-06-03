package co.kr.pmp.HJY.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HJY")
public class kakaoController {
	@RequestMapping("/hello")
	public String hello() {
		return "/HJY/hello";
	}
}
