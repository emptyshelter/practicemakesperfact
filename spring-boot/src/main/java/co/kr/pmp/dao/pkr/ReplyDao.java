package co.kr.pmp.dao.pkr;

import java.util.List;

import co.kr.pmp.domain.pkr.Reply;

public interface ReplyDao {
	// 1. 댓글 입력
		public void create(Reply reply);
		// 2. 댓글 목록
		public List<Reply> list(Integer bno, int start, int end);
		// 3. 댓글 상세보기
		public Reply detail(Integer rno);
		// 4. 댓글 수정
		public void update(Reply reply);
		// 5. 댓글 삭제
		public void delete(Integer rNo);
		// 6. 댓글 갯수
		public int count(Integer bNo);
}
