package co.kr.pmp.dao.pkr;

import java.util.List;

import co.kr.pmp.domain.pkr.Board;

public interface BoardDao {
	
	//게시판 글 작성
	public void insert(Board board);
	
	//게시글 상세 보기 
	public Board view(int boardNo);
	
	//게시글 수정
	public void updateArticle(Board board);
	
	//게시글 삭제
	public void deleteArticle(int boardNo);
	
	//게시글 전체 목록
	public List<Board> listAll();
	
	//게시글 조회 수 증가
	public void increaseViewCnt(int boardNo);
	

}
