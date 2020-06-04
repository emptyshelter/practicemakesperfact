package co.kr.pmp.service.pkr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import co.kr.pmp.domain.pkr.Board;


@Service
public interface BoardService {
	
	// 게시판 글 작성
	public void insert(Board board);

	// 게시글 상세 보기
	public Board view(int boardNo);

	// 게시글 수정
	public void updateArticle(Board board);

	// 게시글 삭제
	public void deleteArticle(int boardNo);

	// 게시글 전체 목록
	public List<Board> listAll(int start, int end, String searchOption, String keyword);

	// 게시글 조회 수 증가
	public void increaseViewCnt(int boardNo, HttpSession session);
	
	// 게시글 레코드 갯수
	public int countArticle(String searchOption, String keyword) throws Exception;
	
	
}
