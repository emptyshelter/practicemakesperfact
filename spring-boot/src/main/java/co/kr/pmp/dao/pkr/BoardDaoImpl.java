package co.kr.pmp.dao.pkr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Board> listAll(int start, int end, String searchOption, String keyword) {
		//검색 옵션, 키워드 맵에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		//BETWEEN #{start} #{end}에 입력될 값을 맵에 
		map.put("start", start);
		map.put("end", end);
		
		return sqlSession.selectList("board.listAll",map);
	}

	@Override
	public void increaseViewCnt(int boardNo) {
		sqlSession.update("board.increseViewCnt",boardNo);
	}

	@Override
	public int countArticle(String searchOption, String keyword) {
		// 검색 옵션, 키워드 맵에 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("board.countArticle", map);
	}


	
}
