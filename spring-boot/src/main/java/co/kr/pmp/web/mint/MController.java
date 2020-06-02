package co.kr.pmp.web.mint;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.pmp.domain.mint.Mdto;
import co.kr.pmp.service.mint.MService;

@Controller
public class MController {
	@Autowired
	private MService mService;
	
	@GetMapping("/index")
	public String index(HttpServletRequest request) {
		List<Mdto>testList = mService.Mtest();
		request.setAttribute("list", testList);
		System.out.println("테스트메세지");
		return "index2";
	}
	@RequestMapping("/test")
	@ResponseBody
	public String testP() {
		return "hello test";
	}
}
