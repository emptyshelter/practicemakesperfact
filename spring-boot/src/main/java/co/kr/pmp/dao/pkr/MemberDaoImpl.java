package co.kr.pmp.dao.pkr;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.pmp.domain.pkr.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	SqlSession sqlSession;
	
	//회원 로그인 체크
	@Override
	public boolean loginCheck(Member member) {
		String name = sqlSession.selectOne("member.loginCheck", member);
		return (name == null) ? false : true;
	}
	//회원 로그인 정보
	@Override
	public Member viewMember(Member member) {
		return sqlSession.selectOne("member.viewMember", member);
	}
	//회원 로그아웃
	@Override
	public void logout(HttpSession sessin) {
	}

}
