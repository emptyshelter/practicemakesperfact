package co.kr.pmp.service.pkr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.pmp.dao.pkr.BoardDao;
import co.kr.pmp.domain.pkr.Board;


@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDao boardDao;
	
	//게시글 작성
	@Override
	public void insert(Board board) {
		String title = board.getTitle();
		String contents = board.getContents();
		String writer = board.getWriter();
		
		title = title.replace("<","&lt;");
		title = title.replace("<","&gt;");
		writer = writer.replace("<","&lt;");
		writer = writer.replace("<","&gt;");
		
		//공백문자 처리
		title = title.replace(" ",  "&nbsp;&nbsp;");
		writer = writer.replace(" ",  "&nbsp;&nbsp;");
		
		//줄 바꿈 문자 처리 
		contents = contents.replace("\n","<br>");
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		
		boardDao.insert(board);
	}
	
	//게시글 1개 보기 
	@Override
	public Board view(int boardNo) {
		return boardDao.view(boardNo);
	}
	
	//게시글 수정
	@Override
	public void updateArticle(Board board) {
		boardDao.updateArticle(board);
	}
	
	//게시글 삭제
	@Override
	public void deleteArticle(int boardNo) {
		boardDao.deleteArticle(boardNo);
	}
	
	//게시글 전체 조회
	@Override
	public List<Board> listAll(int start, int end, String searchOption, String keyword) {
		return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	//게시글 조회 수 증가
	@Override
	public void increaseViewCnt(int boardNo,HttpSession session) {
		long update_time = 0;
		//세션에 저장된 조회 시간 검색
		//최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행되지 않음
		
		if(session.getAttribute("update_time_"+boardNo)!=null) {
			update_time = (Long) session.getAttribute("update_time_"+boardNo);
		}
		
		long current_time = System.currentTimeMillis();
		//시스템의 현재 시간을 저장 
		
		if(current_time - update_time > 5*1000) {
			boardDao.increaseViewCnt(boardNo);
			//일정 시간 경과 후 조회 수 증가 처리 (24*60*60*1000) = 24시간
			//시스템 현재 시간 - 열람시간 > 일정시간(조회 수 증가 가능하도록 설정한 시간)
			session.setAttribute("update_time_"+boardNo,current_time);
			//세션에 시간을 저장 : "update_time_+boardNo는 다른 변수와 중복되지 않도록 한 것"
		}
	}
	
	//게시글 레코드 갯수
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		
		return boardDao.countArticle(searchOption,keyword);
	}





	
}
