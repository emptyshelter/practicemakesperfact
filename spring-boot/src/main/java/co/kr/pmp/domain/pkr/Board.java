package co.kr.pmp.domain.pkr;

import java.util.Date;

public class Board {
	
	private int boardNo; 
	private String writer;
	private String title;
	private String contents;
	private Date regDate;
	private int viewCount;
	//글의 순서번호 관리(그룹, 댓글의 뎁스)
	private int groupNo;
	private int step;
	private int depth;
	
	
	public Board(int boardNo, String writer, String title, String contents, Date regDate, int viewCount, int groupNo,
			int step, int depth) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.viewCount = viewCount;
		this.groupNo = groupNo;
		this.step = step;
		this.depth = depth;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", writer=" + writer + ", title=" + title + ", contents=" + contents
				+ ", regDate=" + regDate + ", readCount=" + viewCount + ", groupNo=" + groupNo + ", step=" + step
				+ ", depth=" + depth + "]";
	}

}
