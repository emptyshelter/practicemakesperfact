package co.kr.pmp.web.pkr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pmp.domain.pkr.Member;
import co.kr.pmp.service.pkr.MemberService;

@Controller //컨트롤러 빈을 생성. 스프링에서 관리 
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	//로그인 화면
	@RequestMapping("login.do")
	public String login() {
		return "member/login"; // views/member/login.jsp로 포워딩
	}
	
	//로그인 체크
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute Member member, HttpSession session) {
		boolean result = memberService.loginCheck(member, session);
		ModelAndView mav = new ModelAndView();
		if(result==true) {
			mav.setViewName("home");
			mav.addObject("msg","success");
		}else {
			//실패 시, login.jsp로 이동
			mav.setViewName("member/login");
			mav.addObject("msg","failure");
		}
		return mav;
	}
	
	//로그아웃 처리
		@RequestMapping("logout.do")
		public ModelAndView logout(HttpSession session){
			memberService.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("member/login");
			mav.addObject("msg", "logout");
			return mav;
		}

}
