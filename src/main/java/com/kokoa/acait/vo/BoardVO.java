package com.kokoa.acait.vo;

public class BoardVO extends RateVO{
  private int boardNo;
  private String acadCd;
  private String title;
  private String content;
  private String pwd;
  private String delYn;  
  private String regDate;
  private String updtDate;
  private String hit;
  
  public String getAcadCd() {
    return acadCd;
  }
  public void setAcadCd(String acadCd) {
    this.acadCd = acadCd;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getPwd() {
    return pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getDelYn() {
    return delYn;
  }
  public void setDelYn(String delYn) {
    this.delYn = delYn;
  }
  public String getRegDate() {
    return regDate;
  }
  public void setRegDate(String regDate) {
    this.regDate = regDate;
  }
  public String getUpdtDate() {
    return updtDate;
  }
  public void setUpdtDate(String updtDate) {
    this.updtDate = updtDate;
  }
public String getHit() {
	return hit;
}
public void setHit(String hit) {
	this.hit = hit;
}
public int getBoardNo() {
	return boardNo;
}
public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}
@Override
public String toString() {
	return "BoardVO [boardNo=" + boardNo + ", acadCd=" + acadCd + ", title=" + title + ", content=" + content + ", pwd="
			+ pwd + ", delYn=" + delYn + ", regDate=" + regDate + ", updtDate=" + updtDate + ", hit=" + hit + "]";
}
}