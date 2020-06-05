package co.kr.pmp.web.ss;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ss")
public class WelcomeController {	
	
	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {
		
		return "/KSS/welcome";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "/KSS/test";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "/KSS/success";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "welcome";
	}

}
