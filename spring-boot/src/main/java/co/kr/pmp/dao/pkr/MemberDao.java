package co.kr.pmp.dao.pkr;

import javax.servlet.http.HttpSession;

import co.kr.pmp.domain.pkr.Member;

public interface MemberDao {
	
	//회원 로그인 체크
	public boolean loginCheck(Member member);
	
	//회원 로그인 정보
	public Member viewMember(Member member);
	
	//회원 로그아웃
	public void logout(HttpSession session);
}
