package com.kokoa.acait.vo;

public class BoardVO extends rateVO{
  private int board_no;
  private String acadCd;
  private String title;
  private String content;
  private String pwd;
  private String del_yn;  
  private String reg_date;
  private String updt_date;
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
  public String getDel_yn() {
    return del_yn;
  }
  public void setDel_yn(String del_yn) {
    this.del_yn = del_yn;
  }
  public String getReg_date() {
    return reg_date;
  }
  public void setReg_date(String reg_date) {
    this.reg_date = reg_date;
  }
  public String getUpdt_date() {
    return updt_date;
  }
  public void setUpdt_date(String updt_date) {
    this.updt_date = updt_date;
  }
public String getHit() {
	return hit;
}
public void setHit(String hit) {
	this.hit = hit;
}
public int getBoard_no() {
	return board_no;
}
public void setBoard_no(int board_no) {
	this.board_no = board_no;
}
}