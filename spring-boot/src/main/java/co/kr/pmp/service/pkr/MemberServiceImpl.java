package co.kr.pmp.service.pkr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.pmp.dao.pkr.MemberDao;
import co.kr.pmp.domain.pkr.Member;

@Service //스프링 관리하는 service bean으로 등록
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDao memberDao;
		// 회원 로그인체크
		@Override
		public boolean loginCheck(Member member, HttpSession session) {
			boolean result = memberDao.loginCheck(member);
			if (result) { // true일 경우 세션에 등록
				Member memberOk = viewMember(member);
				// 세션 변수 등록
				session.setAttribute("userId", memberOk.getMemberId());
				session.setAttribute("userName", memberOk.getMemberName());
			} 
			return result;
		}
		// 회원 로그인 정보
		@Override
		public Member viewMember(Member member) {
			return memberDao.viewMember(member);
		}
		// 회원 로그아웃
		@Override
		public void logout(HttpSession session) {
			// 세션 변수 개별 삭제
			// session.removeAttribute("userId");
			// 세션 정보를 초기화 시킴
			session.invalidate();
		}

}
