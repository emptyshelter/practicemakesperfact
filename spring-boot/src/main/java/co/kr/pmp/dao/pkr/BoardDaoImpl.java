package co.kr.pmp.dao.pkr;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.kr.pmp.domain.pkr.Board;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(Board board) {
		sqlSession.insert("board.insert",board);
	}

	@Override
	public Board view(int boardNo) {
		return sqlSession.selectOne("board.view",boardNo);
	}

	@Override
	public void updateArticle(Board board) {
		sqlSession.update("board.updateArticle",board);
	}

	@Override
	public void deleteArticle(int boardNo) {
		sqlSession.delete("board.deleteArticle",boardNo);
	}

	@Override
	public List<Board> listAll() {
		return sqlSession.selectList("board.listAll");
	}

	@Override
	public void increaseViewCnt(int boardNo) {
		sqlSession.update("board.increseViewCnt",boardNo);
	}


	
}
