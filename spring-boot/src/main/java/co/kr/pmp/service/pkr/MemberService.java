package co.kr.pmp.service.pkr;

import javax.servlet.http.HttpSession;

import co.kr.pmp.domain.pkr.Member;

public interface MemberService {
	
		// 01_01. 회원 로그인 체크
		public boolean loginCheck(Member member, HttpSession session);
		// 01_02. 회원 로그인 정보
		public Member viewMember(Member member);
		// 02. 회원 로그아웃
		public void logout(HttpSession session);
}
