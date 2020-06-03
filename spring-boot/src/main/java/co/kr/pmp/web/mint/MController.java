package co.kr.pmp.web.mint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.pmp.service.mint.MService;

@Controller
@RequestMapping("/mint")
public class MController {
	@Autowired
	private MService mService;
	
	@GetMapping("/login")
	public String index(HttpServletRequest request) {
		System.out.println("테스트메세지");
		return "/mint/login";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String testP() {
		return "hello test";
	}
}
