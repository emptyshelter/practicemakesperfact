package co.kr.pmp.web.pkr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.pmp.domain.pkr.Board;
import co.kr.pmp.service.pkr.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	//게시글 전체 조회 
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="title") String searchOption,
							@RequestParam(defaultValue="") String keyword,
							@RequestParam(defaultValue="1") int curPage) throws Exception{
		//레코드의 갯수 계산 
		int count = boardService.countArticle(searchOption, keyword);
		
		//페이지 나누기 처리
		Board board = new Board(count, curPage);
		int start = board.getPageBegin();
		int end = board.getPageEnd();
		
		List<Board> list = boardService.listAll(start, end, searchOption, keyword);
		
		// 데이터를 맵에 저장
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("list", list); // list
				map.put("count", count); // 레코드의 갯수
				map.put("searchOption", searchOption); // 검색옵션
				map.put("keyword", keyword); // 검색키워드
				map.put("board", board);
				// ModelAndView - 모델과 뷰
				ModelAndView mav = new ModelAndView();
				/*mav.addObject("list", list); // 데이터를 저장
				mav.addObject("count", count);
				mav.addObject("searchOption", searchOption);
				mav.addObject("keyword", keyword);*/
				mav.addObject("map", map); // 맵에 저장된 데이터를 mav에 저장
				mav.setViewName("board/list"); // 뷰를 list.jsp로 설정
				return mav; // list.jsp로 List가 전달된다.
	}
	
	//게시글 작성화면
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/write"; // wirte.jsp로 이동
	}
	
	//게시글 작성
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute Board board) {
		boardService.insert(board);
		return "redirect:list.do"; //작성 후 전체 list view로 이동
	}
	
	//게시글 1개 내용 조회 
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int boardNo, HttpSession session) {
		//조회 수 증가 처리
		boardService.increaseViewCnt(boardNo, session);
		//데이터와 화면 함께 전달할 객체
		ModelAndView mav = new ModelAndView();
		//view 이름
		mav.setViewName("board/view");
		//view에 넘겨줄 데이터
		mav.addObject("dto",boardService.view(boardNo));
		
		return mav;
		
	}
	
	//게시글 수정
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute Board board) {
		boardService.updateArticle(board);
		return "redirect:list.do"; //수정 후 전체 list view로 이동
	}
	
	//게시글 삭제
	@RequestMapping(value="delelte.do")
	public String delete(@RequestParam int boardNo) {
		boardService.deleteArticle(boardNo);
		return "redirect:list.do"; //삭제 후 전체 list view로 이동
	}
	
	
}
