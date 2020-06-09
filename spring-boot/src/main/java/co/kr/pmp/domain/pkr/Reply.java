package co.kr.pmp.domain.pkr;

import java.sql.Date;

public class Reply {
	//null 값 처리가 용이하기 때문에 SQL과 연동할 경우 처리가 용이
	private Integer rNo;
	private Integer bNo;
	private String replyer;
	private String replyText;
	private String memberName;
	private Date regDate;
	private Date updataDate;
	private String writer;
	private String secretReply;
	
	
	public Integer getrNo() {
		return rNo;
	}
	public void setrNo(Integer rNo) {
		this.rNo = rNo;
	}
	public Integer getbNo() {
		return bNo;
	}
	public void setbNo(Integer bNo) {
		this.bNo = bNo;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplyText() {
		return replyText;
	}
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdataDate() {
		return updataDate;
	}
	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSecretReply() {
		return secretReply;
	}
	public void setSecretReply(String secretReply) {
		this.secretReply = secretReply;
	}
	@Override
	public String toString() {
		return "reply [rNo=" + rNo + ", bNo=" + bNo + ", replyer=" + replyer + ", replyText=" + replyText
				+ ", memberName=" + memberName + ", regDate=" + regDate + ", updataDate=" + updataDate + ", writer="
				+ writer + ", secretReply=" + secretReply + "]";
	}
	
}
